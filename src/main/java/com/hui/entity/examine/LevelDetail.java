package com.hui.entity.examine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 处级干部领导个人年度考核详情对应的实体类，包括学院层面、机关层面、直属单位层面
 * @author huang jiehui
 * @date 2021/4/15 0:20
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelDetail implements Serializable {

    /**
     *学院层面干部个人年度测评结果id
     */
    private Long levelId;

    /**
     * 干部id
     */
    private Long cadreId;

    /**
     * 所属部门id
     */
    private Long unitId;

    /**
     * 校领导测评
     */
    private Double schoolLeader;

    /**
     * 本单位测评
     */
    private Double thisUnit;

    /**
     * 服务对象测评
     */
    private Double serviceObject;

    /**
     * 领导班子考核结果
     */
    private Double unitExamine;

    /**
     * 个人日常考核结果
     */
    private Double cadreExamine;

    /**
     * 学习成果
     */
    private Double studyAchievement;
}
