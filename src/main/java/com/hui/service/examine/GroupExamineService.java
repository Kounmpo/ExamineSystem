package com.hui.service.examine;


import com.hui.entity.examine.GroupExamine;
import java.util.List;

/**
 * @author jiehui.huang
 */
public interface GroupExamineService {
    /**
     * 通过unit_id查询记录
     * @param unitId the unit_id
     * @return List<GroupExamine>
     */
    List<GroupExamine> selectByUnitId(Long unitId);

    /**
     * 领导班子年度考核的总分
     * @param unitId theUnitId
     * @return Double
     */
    Double selectPointsByUnitId(Long unitId);

    /**
     * 通过主键更新年度考核结果
     * @param record the record
     * @return int
     */
    int updateByPrimaryKey(GroupExamine record);

    /**
     * 通过主键删除年度考核结果
     * @param unitId the unitId
     * @return int
     */
    int deleteByUnitId(Long unitId);

    /**
     * 新增领导班子年度额考核
     * @param groupExamineList
     */
    void insert(List<GroupExamine> groupExamineList);
}
