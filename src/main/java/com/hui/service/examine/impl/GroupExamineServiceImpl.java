package com.hui.service.examine.impl;

import com.hui.entity.examine.FirstObsPoint;
import com.hui.entity.examine.GroupExamine;
import com.hui.mapper.examine.GroupExamineMapper;
import com.hui.service.examine.FirstObsPointService;
import com.hui.service.examine.GroupExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

/**
 * @author huang jiehui
 * @date 2021/5/17 23:06
 */
@Service
public class GroupExamineServiceImpl implements GroupExamineService {

    @Autowired
    FirstObsPointService service;

    GroupExamineMapper examineMapper;

    public GroupExamineServiceImpl(GroupExamineMapper examineMapper) {
        this.examineMapper = examineMapper;
    }

    @Override
    public List<GroupExamine> selectByUnitId(Long unitId) {
        Set<FirstObsPoint> firstObsPointSet =  service.selectAll(unitId);
        Double points = 0.00D;
        for (FirstObsPoint f:
             firstObsPointSet) {
            points += f.getPoints() * f.getWeight();
        }
        List<GroupExamine> groupExamines = examineMapper.selectByUnitId(unitId);
        for (GroupExamine g:
             groupExamines) {
            if ("日常考核".equals(g.getExamineName())) {
                g.setPoints(points);
            }
        }
        UnitServiceImpl.createGroupExamine(unitId, groupExamines);
        return groupExamines;
    }
}
