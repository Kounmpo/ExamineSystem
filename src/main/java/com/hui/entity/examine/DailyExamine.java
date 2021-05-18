package com.hui.entity.examine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/** 领导班子和领导干部的日常考核对应的实体类
 * @author huang jiehui
 * @date 2021/5/18 14:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyExamine implements Serializable, Comparable<DailyExamine> {

    private Long dailyId;

    private Long secondaryId;

    private Long cadreId;

    private Long unitId;

    private Integer groupExamine;

    private Double obsLevel;

    @Override
    public int compareTo(DailyExamine o) {
        return 0;
    }
}
