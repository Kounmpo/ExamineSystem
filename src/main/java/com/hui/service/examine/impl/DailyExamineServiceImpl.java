package com.hui.service.examine.impl;

import com.hui.entity.examine.DailyExamine;
import com.hui.mapper.examine.DailyExamineMapper;
import com.hui.service.examine.DailyExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/18 20:45
 */
@Service
public class DailyExamineServiceImpl implements DailyExamineService {
    DailyExamineMapper dailyExamineMapper;

    @Autowired
    public DailyExamineServiceImpl(DailyExamineMapper dailyExamineMapper) {
        this.dailyExamineMapper = dailyExamineMapper;
    }

    @Override
    public List<DailyExamine> selectByUnitId(Long unitId) {
        return dailyExamineMapper.selectByUnitId(unitId);
    }

    @Override
    public List<DailyExamine> selectByCadreId(Long cadreId) {
        return dailyExamineMapper.selectByCadreId(cadreId);
    }

}
