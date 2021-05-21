package com.hui.mapper.examine;

import com.hui.entity.examine.DailyExamine;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 领导班子、领导干部的日常考核结果
 * @author 15837
 */
public interface DailyExamineMapper {
    int deleteByPrimaryKey(Long dailyId);

    int insert(DailyExamine record);

    int insertSelective(DailyExamine record);

    DailyExamine selectByPrimaryKey(Long dailyId);

    /**
     * 查询部门日常考核详情
     * @param unitId the unitId
     * @return List<DailyExamine>
     */
    List<DailyExamine> selectByUnitId(@Param("unitId") Long unitId);

    /**
     * 查询干部日常考核详情
     * @param cadreId the cadreId
     * @return List<DailyExamine>
     */
    List<DailyExamine> selectByCadreId(@Param("cadreId") Long cadreId);

    int updateByPrimaryKeySelective(DailyExamine record);

    int updateByPrimaryKey(DailyExamine record);
}