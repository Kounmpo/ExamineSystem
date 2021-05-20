package com.hui.service.examine;

import com.hui.entity.examine.FirstObsPoint;
import java.util.Set;

/**
 * @author 15837
 */
public interface FirstObsPointService {
    /**
     * 日常考核查询一级观测点
     * @param unitId 部门id
     * @return Set<FirstObsPoint>
     */
    Set<FirstObsPoint> selectAll(Long unitId);
}
