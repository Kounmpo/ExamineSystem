package com.hui.mapper.examine;


import com.hui.entity.examine.SystemRole;

/**
 * 系统角色表对象的mapper
 * @author 15837
 */
public interface SystemRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(SystemRole record);

    int insertSelective(SystemRole record);

    SystemRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(SystemRole record);

    int updateByPrimaryKey(SystemRole record);
}