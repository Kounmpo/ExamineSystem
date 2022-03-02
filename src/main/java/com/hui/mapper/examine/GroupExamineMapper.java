package com.hui.mapper.examine;

import com.hui.entity.examine.DailyExamine;
import com.hui.entity.examine.GroupExamine;
import com.hui.entity.examine.Unit;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * GroupExamine实体类对应的mapper文件
 * @author huang jiehui
 * @date 2021/4/14 13:38
 * @version 1.0
 */
public interface GroupExamineMapper {
    int deleteByPrimaryKey(@Param("groupId") Long groupId);

    int deleteByUnitId(@Param("unitId") Long unitId);

    int insert(Unit record);

    int insertSelective(GroupExamine record);

    /**
     * 通过主键查询一条记录
     * @param groupId the groupId
     * @return unit
     */
    GroupExamine selectByPrimaryKey(@Param("groupId") Long groupId);

    /**
     * 通过unit_id查询考核结果
     * @param unitId the unitId
     * @return List<GroupExamine>
     */
    List<GroupExamine> selectByUnitId(@Param("unitId") Long unitId);

    int updateByPrimaryKeySelective(GroupExamine record);

    int updateByPrimaryKey(GroupExamine record);

    int deleteByUnitId(@Param("unitId") long unitId);
}
