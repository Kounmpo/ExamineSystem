package com.hui.service.examine.impl;

import com.hui.entity.examine.DailyExamine;
import com.hui.entity.examine.SecondaryObsPoint;
import com.hui.mapper.examine.SecondaryObsPointMapper;
import com.hui.service.examine.DailyExamineService;
import com.hui.service.examine.SecondaryObsPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/18 20:51
 */
@Service
public class SecondaryObsPointServiceImpl implements SecondaryObsPointService {
    @Autowired
    SecondaryObsPointMapper mapper;

    @Autowired
    DailyExamineService examineService;

    @Override
    public List<SecondaryObsPoint> selectAll(Long unitId) {
        List<SecondaryObsPoint> obsPoints = new ArrayList<>();
        List<DailyExamine> dailyExamines = examineService.selectByUnitId(unitId);
        return getObsPointList(obsPoints, dailyExamines);
    }

    @Override
    public List<SecondaryObsPoint> selectAllCadre(Long cadreId) {
        List<SecondaryObsPoint> obsPoints = new ArrayList<>();
        List<DailyExamine> dailyExamines = examineService.selectByCadreId(cadreId);
        return getObsPointList(obsPoints, dailyExamines);
    }

    public List<SecondaryObsPoint> getObsPointList(List<SecondaryObsPoint> obsPoints, List<DailyExamine> dailyExamines) {
        for (DailyExamine d:
                dailyExamines) {
            SecondaryObsPoint obsPoint = mapper.selectByPrimaryKey(d.getSecondaryId());
            obsPoint.setPoints1(d.getObsLevel());
            obsPoint.setPoints2(d.getObsLevel() * obsPoint.getWeight());
            obsPoints.add(obsPoint);
        }
        return obsPoints;
    }
}
