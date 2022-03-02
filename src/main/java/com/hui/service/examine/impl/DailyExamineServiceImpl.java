package com.hui.service.examine.impl;

import com.hui.entity.examine.DailyExamine;
import com.hui.entity.examine.SecondaryObsPoint;
import com.hui.mapper.examine.DailyExamineMapper;
import com.hui.mapper.examine.SecondaryObsPointMapper;
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
    SecondaryObsPointMapper mapper;

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

    @Override
    public List<DailyExamine> selectDailyByCadreId(Long cadreId) {
        List<DailyExamine> dailyExamineList = selectByCadreId(cadreId);
        for (DailyExamine d:
             dailyExamineList) {
            SecondaryObsPoint s = mapper.selectByPrimaryKey(d.getSecondaryId());
            d.setSecondaryName(s.getName());
            d.setWeight(s.getWeight());
        }
        return dailyExamineList;
    }

    @Override
    public List<DailyExamine> selectDailyByUnitId(Long unitId) {
        List<DailyExamine> dailyExamineList =selectByUnitId(unitId);
        for (DailyExamine d:
             dailyExamineList) {
            SecondaryObsPoint s = mapper.selectByPrimaryKey(d.getSecondaryId());
            d.setSecondaryName(s.getName());
            d.setWeight(s.getWeight());
        }
        return dailyExamineList;
    }

    @Override
    public int deleteByCadreId(Long cadreId) {
        return dailyExamineMapper.deleteByCadreId(cadreId);
    }

    @Override
    public int deleteByUnitId(Long unitId) {
        return dailyExamineMapper.deleteByUnitId(unitId);
    }

    @Override
    public void insertSelective(List<DailyExamine> dailyExamineList) {
        for (DailyExamine dailyExamine:
             dailyExamineList) {
            dailyExamineMapper.insertSelective(dailyExamine);
        }
    }

}
