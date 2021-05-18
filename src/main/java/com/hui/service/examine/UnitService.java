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
}
