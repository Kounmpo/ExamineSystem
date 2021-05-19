package com.hui.mapper.examine;

import com.hui.entity.examine.FirstObsPoint;
import org.apache.ibatis.annotations.Param;

/**
 * FirstObsPoint实体类对应的mapper文件
 * @author huang jiehui
 * @date 2021/4/14 13:38
 * @version 1.0
 */
public interface FirstObsPointMapper {
    int deleteByPrimaryKey(Long firstId);

    int insert(FirstObsPoint record);

    int insertSelective(FirstObsPoint record);

    FirstObsPoint selectByPrimaryKey(Long firstId);

    int updateByPrimaryKeySelective(FirstObsPoint record);

    int updateByPrimaryKey(FirstObsPoint record);
}
