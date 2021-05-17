package com.hui.entity.examine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class Unit implements Serializable {
    /**
     * 单位标识
     */
    private Long id;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 单位编码
     */
    private String code;

    /**
     * 单位等级
     */
    private Integer level;
}
