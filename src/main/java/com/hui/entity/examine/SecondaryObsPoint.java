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
    private Long secondaryId;

    /**
     * 二级观测点名称
     */
    private String name;

    /**
     * 所属的一级观测点编号
     */
    private Integer firstId;

    private Double weight;

    private Long leadingId;

    private Integer groupExamine;
}
