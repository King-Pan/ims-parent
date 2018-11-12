package club.javalearn.ims.system.service;

import club.javalearn.ims.system.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description 用户服务接口
 */
public interface UserService {
    /**
     * 通过用户名查询用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    User findUserByName(String userName);


    /**
     * 添加用户
     * @param user 用户信息
     * @return 用户信息
     */
    User addUser(User user);

    /**
     * 分页查询
     * @param user
     * @param pageable
     * @return
     */
    List<User> pageList(User user, Pageable pageable);
}
