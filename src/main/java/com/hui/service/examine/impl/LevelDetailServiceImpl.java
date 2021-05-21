package com.hui.service.examine.impl;

import com.hui.constant.Constants;
import com.hui.entity.examine.ExamineLevel;
import com.hui.entity.examine.LevelDetail;
import com.hui.mapper.examine.ExamineLevelMapper;
import com.hui.mapper.examine.LevelDetailMapper;
import com.hui.service.examine.FirstObsPointService;
import com.hui.service.examine.LevelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.security.auth.login.Configuration;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/20 13:59
 */
@Service
public class LevelDetailServiceImpl implements LevelDetailService {

    @Autowired
    LevelDetailMapper mapper;

    @Autowired
    FirstObsPointService pointService;

    @Autowired
    ExamineLevelMapper levelMapper;

    @Override
    public List<LevelDetail> getLevelDetailByCadreId(Long cadreId) {
        double pointsCount = 0.0d;
        List<LevelDetail> levelDetailList = mapper.selectByCadreId(cadreId);
        for (LevelDetail l:
             levelDetailList) {
            Double unitDaily = pointService.getUnitDailyPoints(l.getUnitId());
            Double cadreDaily = pointService.getCadreDailyPoints(l.getCadreId());
            ExamineLevel examineLevel = levelMapper.selectByPrimaryKey(l.getExamineId());
            l.setUnitExamine(unitDaily * Constants.WEIGHT3);
            l.setCadreExamine(cadreDaily * Constants.WEIGHT2);
            l.setSchoolLeader(l.getSchoolLeader() * Constants.WEIGHT4);
            l.setThisUnit(l.getThisUnit() * Constants.WEIGHT6);
            l.setServiceObject(l.getServiceObject() * Constants.WEIGHT2);
            l.setStudyAchievement(l.getStudyAchievement() * Constants.WEIGHT1);
            l.setLevelName(examineLevel.getLevelName());
            double points = l.getSchoolLeader() + l.getThisUnit() + l.getServiceObject() + l.getStudyAchievement() +
                    l.getUnitExamine() + l.getCadreExamine();
            l.setPointsSum(Math.round(( points * 100 ) / 100.0 ));
        }
        return levelDetailList;
    }

    @Override
    public Double getLevelPoints(Long cadreId) {
        List<LevelDetail> list = getLevelDetailByCadreId(cadreId);
        double points = 0.0d;
        for (LevelDetail l:
             list) {
            double point = l.getSchoolLeader() + l.getThisUnit() + l.getServiceObject() + l.getStudyAchievement() +
                    l.getUnitExamine() + l.getCadreExamine();
            if ("学院".equals(l.getLevelName())) {
                point *= 0.2;
            } else if ("机关".equals(l.getLevelName())) {
                point *= 0.3;
            } else {
                point *= 0.5;
            }
            points += Math.round(( point * 100 ) / 100.0 );
        }
        return points;
    }
}
