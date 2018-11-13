package club.javalearn.ims.system.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author king-pan
 * @date 2018/11/13
 * @Description ${DESCRIPTION}
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {
    boolean support(String modelType);

    T dynamicUpdate(T t);
}
