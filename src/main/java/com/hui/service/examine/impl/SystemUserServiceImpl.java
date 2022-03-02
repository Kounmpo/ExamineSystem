package com.hui.service.examine.impl;

import com.hui.entity.examine.SystemUser;
import com.hui.mapper.examine.SystemUserMapper;
import com.hui.service.examine.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/23 18:26
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    SystemUserMapper mapper;
    @Override
    public List<SystemUser> selectSelective(SystemUser record) {
        return mapper.selectSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SystemUser record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryId(long userId) {
        return mapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(SystemUser user) {
        return mapper.insertSelective(user);
    }

    @Override
    public SystemUser selectByRealName(SystemUser user) {
        return mapper.selectByRealName(user);
    }

    @Override
    public SystemUser selectUser(SystemUser record) {
        return mapper.selectUser(record);
    }
}
