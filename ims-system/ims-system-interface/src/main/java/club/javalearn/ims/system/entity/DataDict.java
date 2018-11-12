package club.javalearn.ims.system.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description 数据字典表
 */
@Data
@Entity
@Table(name = "sys_data_dict")
public class DataDict implements Serializable {

    /**
     * 主键字段
     */
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="data_dict_sequences")
    @TableGenerator(name="data_dict_sequences",allocationSize=1,initialValue=1,table="jpa_sequences")
    private Long id;
    /**
     * 父类ID
     */
    private Long parentId;
    /**
     * 类型
     */
    private String type;
    /**
     * 字典code
     */
    private String dictCode;
    /**
     * 字典值
     */
    @Column(length = 4000)
    private String dictValue;
    /**
     * 排序字段
     */
    private int orderNum;
}
