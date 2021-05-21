package com.hui.mapper.examine;

import com.hui.entity.examine.ExamineLevel;

/**
 * ExamineLevel实体类对应的mapper文件
 * @author huang jiehui
 * @date 2021/4/14 13:38
 * @version 1.0
 */
public interface ExamineLevelMapper {

    int deleteByPrimaryKey(Long examineId);

    int insert(ExamineLevel record);

    int insertSelective(ExamineLevel record);

    ExamineLevel selectByPrimaryKey(Long examineId);

    int updateByPrimaryKeySelective(ExamineLevel record);

    int updateByPrimaryKey(ExamineLevel record);
}
