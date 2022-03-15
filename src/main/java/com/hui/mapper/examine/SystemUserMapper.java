package com.hui.mapper.examine;

import com.hui.entity.examine.SystemUser;
import org.springframework.security.core.userdetails.User;
import java.util.List;

/**
 * 系统用户表对应的mapper文件
 * @author 15837
 */
public interface SystemUserMapper {

    List<SystemUser> selectSelective(SystemUser record);

    int deleteByPrimaryKey(Long userId);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

    SystemUser selectByRealName(SystemUser user);

    SystemUser selectUser(SystemUser record);
}