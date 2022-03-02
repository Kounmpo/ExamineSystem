package com.hui.service.examine;


import com.hui.entity.examine.SystemUser;
import java.util.List;

/**
 * @author 15837
 */
public interface SystemUserService {
    /**
     * 系统用户的条件查询
     * @param record the record
     * @return List<SystemUser>
     */
    List<SystemUser> selectSelective(SystemUser record);

    /**
     * 条件更新
     * @param record the record
     * @return int
     */
    int updateByPrimaryKeySelective(SystemUser record);

    /**
     * 删除用户
     * @param userId
     * @return int
     */
    int deleteByPrimaryId(long userId);

    /**
     * 插入
     * @param user user
     * @return int
     */
    int insert(SystemUser user);

    /**
     * 通过realName查询
     * @param user the user
     * @return SystemUser
     */
    SystemUser selectByRealName(SystemUser user);

    /**
     * 登录
     * @param record the record
     * @return SystemUser
     */
    SystemUser selectUser(SystemUser record);
}
