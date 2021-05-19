package com.hui.mapper.examine;

import com.hui.entity.examine.Unit;
import java.util.List;

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

    /**
     * 首页的领导班子查询，包括条件查询，详情查询
     * @return List<Unit>
     */
    List<Unit> selectAll();

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}
