package club.javalearn.ims.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @author king-pan
 * @date 2018/11/13
 * @Description Spring拷贝对象属性工具
 */
public class BeanCopyUtil {
    /**
     *  拷贝source对象属性到target目标对象中
     * @param source 源对象
     * @param target 目标对象
     * @param <T>
     */
    public static <T> void beanCopy(T source, T target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    /**
     *  拷贝source对象属性到target目标对象中,另外过滤一些忽略的属性
     * @param source  源对象
     * @param target   目标对象
     * @param ignoreProperties   忽略的属性
     * @param <T>
     */
    public static <T> void beanCopyWithIngore(T source, T target, String... ignoreProperties) {
        String[] pns = getNullAndIgnorePropertyNames(source, ignoreProperties);
        BeanUtils.copyProperties(source, target, pns);
    }

    /**
     *  获取对象的空属性和忽略属性的数组
     * @param source  源对象
     * @param ignoreProperties 忽略属性数组
     * @return
     */
    public static String[] getNullAndIgnorePropertyNames(Object source, String... ignoreProperties) {
        Set<String> emptyNames = getNullPropertyNameSet(source);
        for (String s : ignoreProperties) {
            emptyNames.add(s);
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


    /**
     * 获取空属性名称数组
     * @param source 源对象
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        Set<String> emptyNames = getNullPropertyNameSet(source);
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     *  获取空属性名称集合
     * @param source 源对象
     * @return 空属性名集合
     */
    public static Set<String> getNullPropertyNameSet(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        return emptyNames;
    }
}
