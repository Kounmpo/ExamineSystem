package com.hui.entity.examine;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Transient;

/**
 * system_user
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser implements Serializable {
    /**
     * 用户ID，作为主键与其他表关联
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户编码
     */
    private String code;

    /**
     * 角色Id
     */
    private Long roleId;

    private static final long serialVersionUID = 1L;

    @Transient
    private String roleName;
}