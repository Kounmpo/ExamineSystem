package com.hui.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huang jiehui
 * @date 2020/12/8 11:01
 */
public class Message {
    /**
     * 状态码 1--表示成功 0--表示失败
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回给浏览器的数据
     */
    private Map<String,Object> map = new HashMap<>(16);

    public static Message success() {
        Message msg = new Message();
        msg.setCode(1);
        msg.setMsg("操作成功...");
        return msg;
    }

    public static Message fail() {
        Message msg = new Message();
        msg.setCode(0);
        msg.setMsg("操作失败...");
        return msg;
    }

    public Message add(String key,Object value) {
        this.getMap().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
