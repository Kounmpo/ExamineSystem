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
        List<GroupExamine> groupExamines = examineMapper.selectByUnitId(unitId);
        for (GroupExamine g:
             groupExamines) {
            if ("日常考核".equals(g.getExamineName())) {
                g.setPoints(service.getUnitDailyPoints(unitId));
            }
        }
        return groupExamines;
    }

    @Override
    public Double selectPointsByUnitId(Long unitId) {
        List<GroupExamine> list = selectByUnitId(unitId);
        double pointsSum = 0.0d;
        for (GroupExamine g:
             list) {
            pointsSum += g.getPoints() * g.getWeight();
        }
        return pointsSum;
    }

    @Override
    public int updateByPrimaryKey(GroupExamine record) {
        return examineMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByUnitId(Long unitId) {
        return examineMapper.deleteByUnitId(unitId);
    }

    @Override
    public void insert(List<GroupExamine> groupExamineList) {
        for (GroupExamine g:
             groupExamineList) {
            examineMapper.insertSelective(g);
        }
    }
}
