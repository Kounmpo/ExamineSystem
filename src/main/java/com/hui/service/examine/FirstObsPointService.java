package com.hui.service.examine;

import com.hui.entity.examine.FirstObsPoint;
import java.util.Set;

/**
 * @author 15837
 */
public interface FirstObsPointService {
    /**
     * 日常考核查询一级观测点
     * @param sid 二级观测点的id
     * @return Set<FirstObsPoint>
     */
    Set<FirstObsPoint> selectAll(Long sid);
}
