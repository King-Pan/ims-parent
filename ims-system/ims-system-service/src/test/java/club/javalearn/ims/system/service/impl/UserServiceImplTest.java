package club.javalearn.ims.system.service.impl;

import club.javalearn.ServiceApplication;
import club.javalearn.ims.system.entity.User;
import club.javalearn.ims.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}