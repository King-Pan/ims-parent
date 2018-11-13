package club.javalearn.ims.system.service.impl;

import club.javalearn.ServiceApplication;
import club.javalearn.ims.system.entity.User;
import club.javalearn.ims.system.repository.UserRepository;
import club.javalearn.ims.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description ${DESCRIPTION}
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUserByName() {
        System.out.println(userService.findUserByName("king-pan"));
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setCreateTime(new Date());
        user.setEmail("444@qq.com");
        user.setUpdateTime(new Date());
        user.setNickName("哈哈");
        user.setUserName("king-pan");
        user.setSalt("1111");
        userService.addUser(user);
    }

    @Test
    public void testList(){

        User user = new User();
        user.setNickName("111");
        user.setEmail("222");
        Pageable pageable = new PageRequest(1,10);
        userService.pageList(user,pageable);
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void  testKz(){
        User user = userRepository.findByUserName("king-pan");
        user.setUserId(4L);
        user.setUserName("woshizhongguoren");
        user.setPassword("1111111zseffds");
        userRepository.dynamicUpdate(user);
    }
}