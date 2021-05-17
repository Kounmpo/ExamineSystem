package com.hui.entity.examine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 领导干部个人年终考核对应的考核单位的实体类
 * @author huang jiehui
 * @date 2021/4/15 0:17
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamineLevel implements Serializable {
    /**
     * 领导干部个人考核结果id
     */
    private Long id;

    /**
     * 个人考核明细表id
     */
    private Long detailId;

    /**
     * 考核单位名称
     */
    private String levelName;
}
