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

    /**
     * 获取部门日常考核的总分
     * @param unitId the unit_id
     * @return Double
     */
    Double getUnitDailyPoints(Long unitId);

    /**
     * 通过cadreId查询一级观测点
     * @param cadreId cadreId
     * @return Set<FirstObsPoint>
     */
    Set<FirstObsPoint> selectAllCadre(Long cadreId);


    /**
     * 获取干部日常考核的总分
     * @param cadreId the cadreId
     * @return Double
     */
    Double getCadreDailyPoints(Long cadreId);
}
