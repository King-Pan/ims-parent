package club.javalearn.ims.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author king-pan
 * @date 2018/11/12
 * @Description 角色信息
 */


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sys_role")
@ToString(exclude = {"users","permissions"})
public class Role implements Serializable {

    public static Long serialVersionUID = 1L;

    /**
     * 角色编码
     */
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="role_sequences")
    @TableGenerator(name="role_sequences",allocationSize=1,initialValue=1,table="jpa_sequences")
    private Long roleId;

    /**
     * 角色名称
     */
    @NotEmpty
    @Column(length = 256)
    private String roleName;



    /**
     * 角色编码
     */
    @NotEmpty
    @Column(length = 56)
    private String roleCode;


    /**
     * 角色备注
     */
    @Column(length = 2000)
    private String remark;

    /**
     * 角色状态
     */
    @Column(length = 10)
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "sys_role_permission",joinColumns ={@JoinColumn(name = "role_id", referencedColumnName = "roleId")},
            inverseJoinColumns =  {@JoinColumn(name = "permission_id", referencedColumnName = "permissionId")})
    @JsonIgnore
    private Set<Permission> permissions = new HashSet<>();

    @Transient
    private List<Long> permissionIdList;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Role){
            Role role =(Role)obj;
            return role.getRoleId().equals(this.getRoleId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return  this.getRoleId()!=null?this.getRoleId().hashCode():0;
    }
}
