package com.hui.service.examine.impl;

import com.hui.constant.Constants;
import com.hui.entity.examine.GroupExamine;
import com.hui.entity.examine.Unit;
import com.hui.mapper.examine.GroupExamineMapper;
import com.hui.mapper.examine.UnitMapper;
import com.hui.service.examine.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/17 23:08
 */
@Service
public class UnitServiceImpl implements UnitService {
    private final UnitMapper unitMapper;
    private final GroupExamineMapper groupExamineMapper;

    @Autowired
    public UnitServiceImpl(UnitMapper unitMapper, GroupExamineMapper groupExamineMapper) {
        this.unitMapper = unitMapper;
        this.groupExamineMapper = groupExamineMapper;
    }

    @Override
    public List<Unit> selectAll() {
        List<Unit> units = unitMapper.selectAll();
        for (Unit unit:
             units) {
            Long unitId = unit.getUnitId();
            List<GroupExamine> groupExamines = groupExamineMapper.selectByUnitId(unitId);
            createGroupExamine(unitId, groupExamines);
            double yearCountPoints = 0.0;
            for (GroupExamine g:
                 groupExamines) {
                double points = g.getPoints();
                yearCountPoints = yearCountPoints + points * g.getWeight();
            }
            unit.setYearCountPoints(yearCountPoints);
            double p = unit.getYearCountPoints();
            if (p >= 90.0 && p <= 100.0) {
                unit.setYearExamineLevel(Constants.EXCELLENT);
            } else if (p >= 80.0 && p <= 89.99) {
                unit.setYearExamineLevel(Constants.QUALIFIED);
            } else if (p >= 70.0 && p <= 79.99) {
                unit.setYearExamineLevel(Constants.BASIC_QUALIFIED);
            } else {
                unit.setYearExamineLevel(Constants.UNQUALIFIED);
            }
        }
        Collections.sort(units);
        return units;
    }

    public static void createGroupExamine(Long unitId, List<GroupExamine> groupExamines) {
        if(groupExamines.isEmpty()) {
            GroupExamine g1 = new GroupExamine();
            GroupExamine g2 = new GroupExamine();
            GroupExamine g3 = new GroupExamine();
            g1.setUnitId(unitId);
            g1.setExamineName("日常考核");
            g1.setPoints(0.00);
            g1.setWeight(Constants.WEIGHT4);

            g2.setUnitId(unitId);
            g2.setExamineName("单位考核考核");
            g2.setPoints(0.00);
            g2.setWeight(Constants.WEIGHT5);

            g3.setUnitId(unitId);
            g3.setExamineName("班子年度考核");
            g3.setPoints(0.00);
            g3.setWeight(Constants.WEIGHT7);

            groupExamines.add(g1);
            groupExamines.add(g2);
            groupExamines.add(g3);
        }
    }
}
