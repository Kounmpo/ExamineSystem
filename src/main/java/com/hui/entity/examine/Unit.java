package com.hui.entity.examine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.access.method.P;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 部门单位表对应的实体类
 * @author huang jiehui
 * @date 2021/4/14 23:59
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unit implements Serializable, Comparable<Unit> {
    /**
     * 单位标识
     */
    private Long unitId;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 单位编码
     */
    private String unitCode;

    /**
     * 单位等级
     */
    private Integer level;

    /**
     * 年度考核总分
     */
    @Transient
    private Double yearCountPoints;

    /**
     * 考核等级
     */
    @Transient
    private String yearExamineLevel;

    /**
     * 领导班子日常考核得分
     */
    @Transient
    private Double dailyCountPoints;

    @Override
    public int compareTo(Unit unit) {
        if (yearCountPoints > unit.getYearCountPoints()) {
            return -1;
        } else {
            return 1;
        }
    }
}
