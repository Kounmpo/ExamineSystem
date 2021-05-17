package com.hui.mapper.examine;

import com.hui.entity.examine.Unit;

/**
 * Unit实体类对应的mapper文件
 * @author huang jiehui
 * @date 2021/4/14 13:38
 * @version 1.0
 */
public interface UnitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}
