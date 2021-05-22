package com.hui.service.examine.impl;

import com.hui.entity.examine.Cadre;
import com.hui.entity.examine.DailyExamine;
import com.hui.mapper.examine.CadreMapper;
import com.hui.mapper.examine.DailyExamineMapper;
import com.hui.service.examine.CadreService;
import com.hui.service.examine.LevelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/17 0:30
 */
@Service
public class CadreServiceImpl implements CadreService {

    @Autowired
    LevelDetailService service;

    @Autowired
    DailyExamineMapper mapper;

    private final CadreMapper cadreMapper;

    @Autowired
    public CadreServiceImpl(CadreMapper cadreMapper) {
        this.cadreMapper = cadreMapper;
    }

    @Override
    public List<Cadre> selectSelective(Cadre cadre) {
        return cadreMapper.selectSelective(new Cadre());
    }

    @Override
    public List<Cadre> selectForIndex(Cadre cadre) {
        List<Cadre> cadreList = cadreMapper.selectForIndex(cadre);
        for (Cadre c:
             cadreList) {
            c.setPoints(service.getLevelPoints(cadre.getCadreId()));
        }
        return cadreList;
    }

    @Override
    public int updateBySelective(Cadre cadre) {
        return cadreMapper.updateByPrimaryKeySelective(cadre);
    }

    @Override
    public void batchDelete(List<Cadre> cadres) {
        for (Cadre c:
             cadres) {
            cadreMapper.deleteByPrimaryKey(c.getCadreId());
            mapper.deleteByCadreId(c.getCadreId());
        }
    }

    @Override
    public int insert(Cadre cadre) {
        return cadreMapper.insertSelective(cadre);
    }
}
