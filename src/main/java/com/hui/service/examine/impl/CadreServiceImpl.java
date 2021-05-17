package com.hui.service.examine.impl;

import com.hui.entity.examine.Cadre;
import com.hui.mapper.examine.CadreMapper;
import com.hui.service.examine.CadreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/17 0:30
 */
@Service
public class CadreServiceImpl implements CadreService {
    private final CadreMapper cadreMapper;

    @Autowired
    public CadreServiceImpl(CadreMapper cadreMapper) {
        this.cadreMapper = cadreMapper;
    }

    @Override
    public List<Cadre> selectSelective(Cadre cadre) {
        return cadreMapper.selectSelective(new Cadre());
    }
}
