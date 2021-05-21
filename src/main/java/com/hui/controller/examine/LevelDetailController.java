package com.hui.controller.examine;

import com.hui.entity.Message;
import com.hui.service.examine.LevelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huang jiehui
 * @date 2021/5/20 23:26
 */
@Controller
public class LevelDetailController {

    @Autowired
    LevelDetailService service;

    @GetMapping(value = "level-detail")
    @ResponseBody
    public Message getLevelDetail(@RequestParam(value = "cadreId") Long cadreId) {
        return Message.success().add("detail",
                service.getLevelDetailByCadreId(cadreId));
    }

    @GetMapping(value = "level-points")
    @ResponseBody
    public Message getPoints(@RequestParam(value = "cadreId") Long cadreId) {
        return Message.success().add("points",
                service.getLevelPoints(cadreId));
    }
}
