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

    /**
     * 编辑日常考核数据
     * @param cadreId the cadreId
     * @return List<DailyExamine>
     */
    List<DailyExamine> selectDailyByCadreId(Long cadreId);

    /**
     * 编辑领导班子日常考核数据
     * @param unitId the unitId
     * @return List<DailyExamine>
     */
    List<DailyExamine> selectDailyByUnitId(Long unitId);

    /**
     * 通过cadreId删除干部日常考核数据
     * @param cadreId the cadreId
     * @return int
     */
    int deleteByCadreId(Long cadreId);

    /**
     * 通过unitId删除部门考核数据
     * @param unitId the unitId
     * @return int
     */
    int deleteByUnitId(Long unitId);

    /**
     * 批量插入干部日常考核数据
     * @param dailyExamineList
     * @return int
     */
    void insertSelective(List<DailyExamine> dailyExamineList);
}
