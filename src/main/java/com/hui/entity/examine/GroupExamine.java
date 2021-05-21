package com.hui.entity.examine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 领导班子年度考核总结果对应的实体类
 * @author huang jiehui
 * @date 2021/4/15 0:29
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupExamine implements Serializable {

    /**
     * 处级领导班子年度考核结果id
     */
    private Long groupId;

    /**
     * 考核项目
     */
    private String examineName;

    /**
     * 考核所属的领导班子
     */
    private Long unitId;

    /**
     * 考核项目所占的权重
     */
    private Double weight;

    /**
     * 各项考核项目的分数
     */
    private Double points;
}
