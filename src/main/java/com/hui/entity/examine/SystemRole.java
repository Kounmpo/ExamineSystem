package com.hui.entity.examine;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * system_role
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemRole implements Serializable {
    /**
     * 主键角色ID
     */
    private Long roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色说明
     */
    private String roleComment;

    private static final long serialVersionUID = 1L;
}