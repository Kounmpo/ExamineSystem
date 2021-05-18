package com.hui.mapper.examine;

import com.hui.entity.examine.SecondaryObsPoint;

/**
 * SecondaryObsPoint实体类对应的mapper文件
 * @author huang jiehui
 * @date 2021/4/14 13:38
 * @version 1.0
 */
public interface SecondaryObsPointMapper {
    int deleteByPrimaryKey(Long secondaryId);

    int insert(SecondaryObsPoint record);

    int insertSelective(SecondaryObsPoint record);

    SecondaryObsPoint selectByPrimaryKey(Long secondaryId);

    int updateByPrimaryKeySelective(SecondaryObsPoint record);

    int updateByPrimaryKey(SecondaryObsPoint record);
}
