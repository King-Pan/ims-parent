package club.javalearn;

import club.javalearn.ims.system.repository.BaseRepositoryImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description ${DESCRIPTION}
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class,args);
    }

    /**
     *   让Spring管理JPAQueryFactory
     */
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
}
