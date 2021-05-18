package com.hui.mapper.examine;

import com.hui.entity.examine.DailyExamine;

/**
 * 领导班子、领导干部的日常考核结果
 * @author 15837
 */
public interface DailyExamineMapper {
    int deleteByPrimaryKey(Long dailyId);

    int insert(DailyExamine record);

    int insertSelective(DailyExamine record);

    DailyExamine selectByPrimaryKey(Long dailyId);

    int updateByPrimaryKeySelective(DailyExamine record);

    int updateByPrimaryKey(DailyExamine record);
}