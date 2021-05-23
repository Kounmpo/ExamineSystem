package com.hui.service.examine;

import com.hui.entity.examine.Unit;
import java.util.List;

/**
 * @author jiehui.huang
 */
public interface UnitService {
    /**
     * 查询所有的单位考核结果
     * @return List<Unit>
     */
    List<Unit> selectAll();

    /**
     * 编辑单位信息
     * @param unit the unit
     * @return int
     */
    int editUnit(Unit unit);

    /**
     * 批量删除单位信息
     * @param units the units
     * @return int
     */
    void batchDelete(List<Unit> units);

    /**
     * 增加单位信息
     * @param unit unit
     * @return int
     */
    int insertUnit(Unit unit);
}
