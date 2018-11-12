package club.javalearn.ims.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description 权限信息
 */
@Setter
@Getter
@Entity
@ToString(exclude = {"roles"})
@Table(name = "sys_permission")
public class Permission implements Serializable {

    public static Long serialVersionUID = 1L;

    /**
     * 权限编码
     */
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="permission_sequences")
    @TableGenerator(name="permission_sequences",allocationSize=1,initialValue=1,table="jpa_sequences")
    private Long permissionId;

    /**
     * 权限名称
     */
    @Column(length = 100)
    private String permissionName;

    /**
     * 权限描述
     */
    @Column(length = 2000)
    private String description;

    /**
     * 权限链接
     */
    @Column(length = 256)
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 资源表达式
     */
    private String expression;

    /**
     * 权限类型: 0: 目录 1：链接 2:按钮
     */
    @Column(length = 1)
    private String permissionType;

    /**
     * 权限父节点编码
     */
    private Long parentId;

    /**
     * 上级资源名称
     */
    private String parentName;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


    @ManyToMany(mappedBy = "permissions",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Permission){
            Permission resource = (Permission)obj;
            return  resource.getPermissionId().equals(this.getPermissionId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getPermissionId().hashCode();
    }
}
