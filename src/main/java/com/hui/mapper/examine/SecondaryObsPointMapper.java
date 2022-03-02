package com.hui.mapper.examine;

import com.hui.entity.examine.SecondaryObsPoint;
import org.apache.ibatis.annotations.Param;
import java.util.List;

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

    List<SecondaryObsPoint> selectByFirstId(@Param("firstId") Long firstId);

    int updateByPrimaryKeySelective(SecondaryObsPoint record);

    int updateByPrimaryKey(SecondaryObsPoint record);

    /**
     * 通过是否领导班子考核查询
     * @param groupExamine groupExamine
     * @return List<SecondaryObsPoint>
     */
    List<SecondaryObsPoint> selectByGroupExamine(@Param("groupExamine") int groupExamine);
}
