package club.javalearn.ims.system.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description 日志记录信息
 */
@Table(name = "sys_log")
@Entity
@Data
public class Log implements Serializable {

    public static Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="log_sequences")
    @TableGenerator(name="log_sequences",allocationSize=1,initialValue=1,table="jpa_sequences")
    private Long logId;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 访问时间
     */
    private Date createDate;

    /**
     * 时长
     */
    private Long time;

    /**
     * 用户ID
     */
    private String userName;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 访问IP
     */
    private String ip;

    /**
     * 参数
     */
    private String params;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 方法类型
     */
    private String method;

    /**
     * 状态
     */
    private String status;

    /**
     * 返回值
     */
    @Column(length = 4000)
    private String result;

    /**
     * 错误消息
     */
    @Column(length = 4000)
    private String errorMessage;

}
