package club.javalearn.ims.system.repository;

import club.javalearn.ims.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description 用户持久化
 */
public interface UserRepository extends BaseRepository<User,Long>, JpaRepository<User,Long> {

    /**
     * 通过用户名查找用户信息
     * @param userName 用户名
     * @return
     */
    User findByUserName(String userName);

}
