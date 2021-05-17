package com.hui.entity.examine;

import static com.hui.constant.Constants.DATE_FORMAT;
import static com.hui.constant.Constants.TIME_ZONE;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 干部表对应的实体类
 * @author huang jiehui
 * @date 2021/4/14 23:38
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cadre implements Serializable {
    /**
     * 干部标识
     */
    private Long id;

    /**
     * 干部名称
     */
    private String name;

    /**
     * 所属单位标识
     */
    private Long unitId;

    /**
     * 干部编码
     */
    private String code;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = DATE_FORMAT, timezone = TIME_ZONE)
    @DateTimeFormat(pattern = DATE_FORMAT, iso = DateTimeFormat.ISO.DATE)
    private Date birthday;

    /**
     * 职位
     */
    private String position;

    /**
     * 直属领导id
     */
    private Long leaderId;

}
