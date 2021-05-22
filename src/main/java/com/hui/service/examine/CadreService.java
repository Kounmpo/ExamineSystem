package com.hui.service.examine;

import com.hui.entity.examine.Cadre;
import java.util.List;

/**
 * @author jiehui.huang
 */
public interface CadreService {
    /**
     * 干部信息的条件查询
     * @param cadre the cadre
     * @return List<Cadre>
     */
    List<Cadre> selectSelective(Cadre cadre);

    /**
     * 干部的日常考核分数
     * @param cadre the cadre
     * @return List<Cadre>
     */
    List<Cadre> selectForIndex(Cadre cadre);

    /**
     * 选择性的更新
     * @param cadre the cadre
     * @return int
     */
    int updateBySelective(Cadre cadre);

    /**
     * 批量删除与单个删除
     * @param cadres the cadres
     */
    void batchDelete(List<Cadre> cadres);

    /**
     * 增加干部
     * @param cadre  the cadre
     * @return int
     */
    int insert(Cadre cadre);
}
