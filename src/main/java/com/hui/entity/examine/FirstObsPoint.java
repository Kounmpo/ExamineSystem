package com.hui.entity.examine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 一级观测点对应的实体类
 * @author huang jiehui
 * @date 2021/4/15 0:04
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirstObsPoint implements Serializable {
    /**
     * 一级观测点编号
     */
    private Long id;

    /**
     * 一级观测点名称
     */
    private String name;

    /**
     * 牵头部门
     */
    private Long unitId;
}
