package com.hui.mapper.examine;

import com.hui.entity.examine.Cadre;
import com.hui.entity.examine.GroupExamine;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Cadre实体类对应的mapper文件
 * @author huang jiehui
 * @date 2021/4/14 23:38
 * @version 1.0
 */
public interface CadreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cadre record);

    int insertSelective(Cadre record);

    List<Cadre> selectSelective(Cadre record);

    List<Cadre> CadreExamine(Cadre record);

    List<Cadre> GroupExamine(GroupExamine record);

    Cadre selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cadre record);

    int updateByPrimaryKey(Cadre record);
}
