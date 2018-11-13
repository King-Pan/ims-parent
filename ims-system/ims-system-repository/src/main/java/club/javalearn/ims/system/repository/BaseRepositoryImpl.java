package club.javalearn.ims.system.repository;

import club.javalearn.ims.common.utils.BeanCopyUtil;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author king-pan
 * @date 2018/11/13
 * @Description ${DESCRIPTION}
 */
@Transactional(readOnly = false,rollbackFor =RuntimeException.class,propagation = Propagation.REQUIRED)
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID>   {


    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> entityClass;


    public BaseRepositoryImpl(JpaEntityInformation entityInformation,
                              EntityManager entityManager) {
        super(entityInformation, entityManager);

        // Keep the EntityManager around to used from the newly introduced methods.
        this.entityManager = entityManager;
    }

    @Override
    public boolean support(String modelType) {
        System.out.println("调用support方法");
        return false;
    }

    @Modifying
    @Override
    public T dynamicUpdate(T t) {
        System.out.println("调用dynamicUpdate方法");
        //通过反射获取主键的值
        Object val = JpaReflectUtils.getPkValue(t);
        if(val!=null){
            T dbT = getOne((ID) val);
            if(dbT!=null){
                BeanCopyUtil.beanCopy(dbT,t);
            }
        }
        return entityManager.merge(t);
    }
}
