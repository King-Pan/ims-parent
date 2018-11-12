package club.javalearn.ims.system.service.impl;

import club.javalearn.ims.system.entity.User;
import club.javalearn.ims.system.repository.UserRepository;
import club.javalearn.ims.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description 用户服务类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> pageList(User user, Pageable pageable) {


        return null;
    }
}