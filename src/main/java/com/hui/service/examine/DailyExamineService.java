package com.hui.service.examine;


import com.hui.entity.examine.DailyExamine;
import java.util.List;

/**
 * @author 15837
 */
public interface DailyExamineService {
    List<DailyExamine> selectByUnitId(Long unitId);
}
