package com.hui.service.examine;


import com.hui.entity.examine.DailyExamine;
import java.util.List;

/**
 * @author 15837
 */
public interface DailyExamineService {
    /**
     * 通过unitId查询日常考核结果
     * @param unitId the unitId
     * @return List<DailyExamine>
     */
    List<DailyExamine> selectByUnitId(Long unitId);

    /**
     * 通过cadreId查询日常考核结果
     * @param cadreId the cadreId
     * @return List<DailyExamine>
     */
    List<DailyExamine> selectByCadreId(Long cadreId);
}
