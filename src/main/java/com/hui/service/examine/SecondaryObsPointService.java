package com.hui.service.examine;

import com.hui.entity.examine.SecondaryObsPoint;
import java.util.List;

/**
 * @author 15837
 */
public interface SecondaryObsPointService {
    /**
     * 根据unit_id查询所有的SecondaryObsPoint
     * @param unitId
     * @return List<SecondaryObsPoint>
     */
    List<SecondaryObsPoint> selectAll(Long unitId);

    /**
     * 根据cadre_id查询所有的二级考核点
     * @param cadreId the cadreId
     * @return List<SecondaryObsPoint>
     */
    List<SecondaryObsPoint> selectAllCadre(Long cadreId);

    /**
     * 通过主键更新
     * @param record the record
     * @return int
     */
    int updateByPrimaryId(SecondaryObsPoint record);

    /**
     * 查询二级考核点的名称
     * @param groupExamine
     * @return List<SecondaryObsPoint>
     */
    List<SecondaryObsPoint> selectByGroupExamine(int groupExamine);
}
