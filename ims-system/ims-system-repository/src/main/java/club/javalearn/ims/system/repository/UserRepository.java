package club.javalearn.ims.system.repository;

import club.javalearn.ims.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description 用户持久化
 */
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    /**
     * 通过用户名查找用户信息
     * @param userName 用户名
     * @return
     */
    User findByUserName(String userName);
}
