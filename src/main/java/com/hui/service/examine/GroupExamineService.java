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
}
