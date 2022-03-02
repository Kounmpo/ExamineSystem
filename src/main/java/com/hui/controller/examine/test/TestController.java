package com.hui.controller.examine.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jiehui.huang
 * @version 1.0
 * @date 2022/2/28 9:58
 */
@Controller
public class TestController {

    @GetMapping("/test/testHashMap")
    @ResponseBody
    public Map<String, Object> test1() {
        HashMap<String, Object> hash = new LinkedHashMap<>(4, 1);
        hash.put("code", 0);
        hash.put("msg", "成功");
        HashMap<String,Object> data = new LinkedHashMap<>(4, 1);
        data.put("count", 100);
        hash.put("data", data);
        return hash;
    }
}
