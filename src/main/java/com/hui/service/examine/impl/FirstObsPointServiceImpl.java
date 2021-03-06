package com.hui.service.examine.impl;

import com.hui.entity.examine.FirstObsPoint;
import com.hui.entity.examine.SecondaryObsPoint;
import com.hui.mapper.examine.FirstObsPointMapper;
import com.hui.mapper.examine.SecondaryObsPointMapper;
import com.hui.service.examine.FirstObsPointService;
import com.hui.service.examine.SecondaryObsPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author huang jiehui
 * @date 2021/5/18 20:48
 */
@Service
public class FirstObsPointServiceImpl implements FirstObsPointService {

    @Autowired
    FirstObsPointMapper mapper;

    @Autowired
    SecondaryObsPointService service;

    @Override
    public Set<FirstObsPoint> selectAll(Long unitId) {
        Set<Long> fidsSet = new HashSet<>();
        List<SecondaryObsPoint> secondaryObsPointList = service.selectAll(unitId);
        Set<FirstObsPoint> firstObsPoints = new TreeSet<>();
        FirstObsPoint firstObsPoint = null;
        for (SecondaryObsPoint sop:
             secondaryObsPointList) {
            fidsSet.add(sop.getFirstId());
        }

        for (Long id:
             fidsSet) {
            List<SecondaryObsPoint> secondaryObsPointList1 = new ArrayList<>();
            Double points2 = 0.00D;
            for (SecondaryObsPoint sop:
                 secondaryObsPointList) {
                if (id.equals(sop.getFirstId())) {
                    secondaryObsPointList1.add(sop);
                    firstObsPoint = mapper.selectByPrimaryKey(id);
                    points2 += Math.round((sop.getPoints2() * 100) / 100.0);
                }
            }
            firstObsPoint.setPoints(points2);
            firstObsPoint.setObsPointList(secondaryObsPointList1);
            firstObsPoints.add(firstObsPoint);

        }
        return firstObsPoints;
    }

    @Override
    public Double getUnitDailyPoints(Long unitId) {
        double points = 0.0D;
        Set<FirstObsPoint> pointSet = selectAll(unitId);
        for (FirstObsPoint f:
             pointSet) {
            double p = f.getPoints() * f.getWeight();
            BigDecimal bg = new BigDecimal(p);
            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            points += f1;
        }
        return points;
    }

    @Override
    public Set<FirstObsPoint> selectAllCadre(Long cadreId) {
        Set<Long> fidsSet = new HashSet<>();
        List<SecondaryObsPoint> secondaryObsPointList = service.selectAllCadre(cadreId);
        Set<FirstObsPoint> firstObsPoints = new TreeSet<>();
        FirstObsPoint firstObsPoint = null;
        for (SecondaryObsPoint sop:
                secondaryObsPointList) {
            fidsSet.add(sop.getFirstId());
        }

        for (Long id:
                fidsSet) {
            List<SecondaryObsPoint> secondaryObsPointList1 = new ArrayList<>();
            double points2 = 0.00D;
            for (SecondaryObsPoint sop:
                    secondaryObsPointList) {
                if (id.equals(sop.getFirstId())) {
                    secondaryObsPointList1.add(sop);
                    firstObsPoint = mapper.selectByPrimaryKey(id);
                    points2 += Math.round(( sop.getPoints2() * 100 ) / 100.0 );
                }
            }
            firstObsPoint.setPoints(points2);
            firstObsPoint.setObsPointList(secondaryObsPointList1);
            firstObsPoints.add(firstObsPoint);

        }
        return firstObsPoints;
    }

    @Override
    public Double getCadreDailyPoints(Long cadreId) {
        double points = 0.00D;
        Set<FirstObsPoint> pointSet = selectAllCadre(cadreId);
        for (FirstObsPoint f:
                pointSet) {
            double p = ( Math.round((f.getPoints() * f.getWeight()) * 100) / 100.0);
            points += p;
        }
        return points;
    }

}
