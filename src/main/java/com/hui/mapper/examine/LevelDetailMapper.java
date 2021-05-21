package com.hui.mapper.examine;


import com.hui.entity.examine.LevelDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * LevelDetail实体类对应的mapper文件
 * @author huang jiehui
 * @date 2021/4/14 13:38
 * @version 1.0
 */
public interface LevelDetailMapper {

    int deleteByPrimaryKey(Long levelId);

    int insert(LevelDetail record);

    int insertSelective(LevelDetail record);

    /**
     * 同说过levelId查询所有的LevelDetail
     * @param levelId the levelId
     * @return LevelDetail
     */
    LevelDetail selectByPrimaryKey(Long levelId);

    List<LevelDetail> selectByCadreId(@Param("cadreId") Long cadreId);

    int updateByPrimaryKeySelective(LevelDetail record);

    int updateByPrimaryKey(LevelDetail record);
}
