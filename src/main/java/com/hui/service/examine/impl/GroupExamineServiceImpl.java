package com.hui.service.examine.impl;

import com.hui.entity.examine.GroupExamine;
import com.hui.mapper.examine.GroupExamineMapper;
import com.hui.service.examine.GroupExamineService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/17 23:06
 */
@Service
public class GroupExamineServiceImpl implements GroupExamineService {
    GroupExamineMapper examineMapper;

    public GroupExamineServiceImpl(GroupExamineMapper examineMapper) {
        this.examineMapper = examineMapper;
    }

    @Override
    public List<GroupExamine> selectByUnitId(Long unitId) {
        List<GroupExamine> groupExamines = examineMapper.selectByUnitId(unitId);
        UnitServiceImpl.createGroupExamine(unitId, groupExamines);
        return groupExamines;
    }
}
