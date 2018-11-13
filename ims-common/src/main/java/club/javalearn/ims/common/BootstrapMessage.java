package club.javalearn.ims.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/11/13
 * @Description ${DESCRIPTION}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BootstrapMessage<T> implements Message {
    private List<T> rows;
    private Long start;
    private Long limit;
    private Long total;
}
