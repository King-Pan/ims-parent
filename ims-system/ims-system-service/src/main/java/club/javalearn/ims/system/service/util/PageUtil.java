package club.javalearn.ims.system.service.util;

import club.javalearn.ims.common.BootstrapMessage;
import club.javalearn.ims.common.Message;
import com.querydsl.core.QueryResults;

/**
 * @author king-pan
 * @date 2018/11/13
 * @Description ${DESCRIPTION}
 */
public class PageUtil {

    public static Message getMessage(QueryResults results){
        Message message = new BootstrapMessage(results.getResults(),results.getOffset(),results.getLimit(),results.getTotal());
        return message;
    }
}
