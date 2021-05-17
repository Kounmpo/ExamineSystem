package com.hui.entity.examine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 二级观测点对应的实体类
 * @author huang jiehui
 * @date 2021/4/15 0:07
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondaryObsPoint implements Serializable {

    /**
     * 二级观测点编号
     */
    private Long id;

    /**
     * 二级观测点名称
     */
    private String name;

    /**
     * 所属的一级观测点编号
     */
    private Integer firstObsPointId;

    /**
     * 评分等级，0，1，2，3，4,分别表示优秀、良好、一般、较差、不了解
     */
    private Integer obsLevel;

    /**
     * 所属干部的id
     */
    private Long cadreId;

    /**
     * 0表示领导班子日常考核、1表示领导干部日常考核
     */
    private Boolean groupExamine;

    /**
     * 领导班子所属的部门id
     */
    private Long unitId;
}
