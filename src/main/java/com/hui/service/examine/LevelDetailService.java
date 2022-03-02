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

    /**
     * 通过cadreId删除干部年度考核记录
     * @param cadreId the cadreId
     * @return int
     */
    int deleteByCadreId(long cadreId);

    /**
     * 通过 cadreId查询所有的记录
     * @param cadreId the cadreId
     * @return List<LevelDetail>
     */
    List<LevelDetail> selectByCadreId(long cadreId);

    /**
     * 根据id来更新记录
     * @param record the record
     * @return int
     */
    int updateByPrimaryId(LevelDetail record);

    /**
     * 批量插入
     * @param levelDetails
     */
    void batchInsert(List<LevelDetail> levelDetails);
}
