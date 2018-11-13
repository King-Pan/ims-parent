package club.javalearn.ims.system.repository;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author king-pan
 * @date 2018/11/13
 * @Description ${DESCRIPTION}
 */
@Slf4j
public class JpaReflectUtils<ID extends Serializable> {

    public static String getPkColumn(Class clazz) {
        String pkColumn = null;
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if(field.getAnnotation(Id.class) != null){
                    pkColumn = field.getName();

                    break;
                }
            }
        } catch (Exception e) {
            log.error("通过反射获取jpa主键字段失败",e);
            throw new RuntimeException("通过反射获取jpa主键字段失败");
        }
        return pkColumn;
    }

    public static Object getPkValue(Object obj) {
        Class cls = obj.getClass();
        Object val = null;
        String pkColumn = getPkColumn(cls);
        try {
            Method method = cls.getMethod(toGetter(pkColumn));
            method.setAccessible(true);
            val = method.invoke(obj,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    /**
     * Get getter method name by field name
     * @param fieldname
     * @return
     */
    public static String toGetter(String fieldName) {

        if (fieldName == null || fieldName.length() == 0) {
            return null;
        }

        /* If the second char is upper, make 'get' + field name as getter name. For example, eBlog -> geteBlog */
        if (fieldName.length() > 2) {
            String second = fieldName.substring(1, 2);
            if (second.equals(second.toUpperCase())) {
                return new StringBuffer("get").append(fieldName).toString();
            }
        }

        /* Common situation */
        fieldName = new StringBuffer("get").append(fieldName.substring(0, 1).toUpperCase())
                .append(fieldName.substring(1)).toString();

        return  fieldName;
    }

    public static void main(String[] args) {
        System.out.println(toGetter("name"));
    }
}
