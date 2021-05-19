package com.hui.service.examine;

import com.hui.entity.examine.SecondaryObsPoint;
import java.util.List;

/**
 * @author 15837
 */
public interface SecondaryObsPointService {
    /**
     * 更具unit_id查询所有的SecondaryObsPoint
     * @param unitId
     * @return List<SecondaryObsPoint>
     */
    List<SecondaryObsPoint> selectAll(Long unitId);
}
