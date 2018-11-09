package club.javalearn.ims.user.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author king-pan
 * @date 2018/11/9
 * @Description 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {


    public ModelAndView page(){
        ModelAndView view = new ModelAndView();
        view.setViewName("system/user");
        return view;
    }


}
