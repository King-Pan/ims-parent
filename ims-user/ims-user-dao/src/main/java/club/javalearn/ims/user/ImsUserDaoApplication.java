package club.javalearn.ims.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("club.javalearn.ims.user.mapper")
public class ImsUserDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsUserDaoApplication.class,args);
    }
}
