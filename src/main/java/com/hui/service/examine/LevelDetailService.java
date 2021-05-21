package com.hui.service.examine;

import com.hui.entity.examine.LevelDetail;
import java.util.List;

/**
 * @author 15837
 */
public interface LevelDetailService {

    /**
     * 通过cadreId 查询LevelDetail
     * @param cadreId the cadreId
     * @return List<LevelDetail>
     */
    List<LevelDetail> getLevelDetailByCadreId(Long cadreId);

    /**
     * 通过cadreId查询考核总分
     * @param cadreId the cadreId
     * @return Double
     */
    Double getLevelPoints(Long cadreId);
}
