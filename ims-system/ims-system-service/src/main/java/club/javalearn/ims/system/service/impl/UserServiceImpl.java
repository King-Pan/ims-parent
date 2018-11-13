package club.javalearn.ims.system.service.impl;

import club.javalearn.ims.common.Message;
import club.javalearn.ims.system.entity.QUser;
import club.javalearn.ims.system.entity.User;
import club.javalearn.ims.system.repository.UserRepository;
import club.javalearn.ims.system.service.UserService;
import club.javalearn.ims.system.service.util.PageUtil;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public User findUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Message<User> pageList(User user, Pageable pageable) {

        QUser qUser = QUser.user;
        List<Predicate> wherePredicate = new ArrayList<>();
        if(user!=null){
            if(StringUtils.isNoneBlank(user.getNickName())){
                wherePredicate.add(qUser.nickName.like("%1哈哈%"));
            }
            if(StringUtils.isNoneBlank(user.getEmail())){
                wherePredicate.add(qUser.email.like("%44%"));
            }
        }
        Predicate[] predicates = new Predicate[]{};
        JPAQuery<User> jpaQuery = jpaQueryFactory.select(qUser).from(qUser);
        if(CollectionUtils.isNotEmpty(wherePredicate)){
            jpaQuery.where(wherePredicate.toArray(predicates));
        }
        QueryResults results = jpaQuery.fetchResults();
        System.out.println(results.getTotal());
        System.out.println(results.isEmpty());
        return null;
    }
}
