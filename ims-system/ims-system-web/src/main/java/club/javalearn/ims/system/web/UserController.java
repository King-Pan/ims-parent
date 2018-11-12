package club.javalearn.ims.system.web;

import club.javalearn.ims.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description 用户控制器
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public Object getList(){
        return userService.findUserByName("king-pan");
    }
}
