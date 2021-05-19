package com.hui.entity.examine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 一级观测点对应的实体类
 * @author huang jiehui
 * @date 2021/4/15 0:04
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirstObsPoint implements Serializable, Comparable<FirstObsPoint>{
    /**
     * 一级观测点编号
     */
    private Long firstId;

    /**
     * 一级观测点名称
     */
    private String name;

    private double weight;

    @Transient
    private List<SecondaryObsPoint> obsPointList;

    /**
     * 日常考核一级观测点的总得分
     */
    @Transient
    private Double points;


    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            //地址相等
            return true;
        }

        if(obj == null){
            //非空性：对于任意非空引用x，x.equals(null)应该返回false。
            return false;
        }

        if(obj instanceof FirstObsPoint){
            FirstObsPoint other = (FirstObsPoint) obj;
            //需要比较的字段相等，则这两个对象相等
            if(equalsStr(this.name, other.name) && this.firstId.equals(other.firstId)){
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (firstId == null ? 0 : firstId.hashCode());
        return result;
    }

    private boolean equalsStr(String str1, String str2){
        if(StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)){
            return true;
        }
        if(!StringUtils.isEmpty(str1) && str1.equals(str2)){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(FirstObsPoint o) {
        if(this.points < o.points){
            return 1 ;
        }else {
            return -1 ;
        }

    }
}
