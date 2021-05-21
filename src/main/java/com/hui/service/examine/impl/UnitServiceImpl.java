package com.hui.service.examine.impl;

import com.hui.constant.Constants;
import com.hui.entity.examine.GroupExamine;
import com.hui.entity.examine.Unit;
import com.hui.mapper.examine.GroupExamineMapper;
import com.hui.mapper.examine.UnitMapper;
import com.hui.service.examine.FirstObsPointService;
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


    @Autowired
    public UnitServiceImpl(UnitMapper unitMapper, GroupExamineMapper groupExamineMapper) {
        this.unitMapper = unitMapper;
    }

    @Override
    public List<Unit> selectAll() {
        return unitMapper.selectAll();
    }
}
