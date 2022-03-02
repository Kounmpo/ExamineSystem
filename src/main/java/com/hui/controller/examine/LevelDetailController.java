package com.hui.controller.examine;

import com.hui.entity.Message;
import com.hui.entity.examine.LevelDetail;
import com.hui.service.examine.LevelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/20 23:26
 */
@Controller
public class LevelDetailController {

    @Autowired
    LevelDetailService service;

    @GetMapping(value = "/level-detail")
    @ResponseBody
    public Message getLevelDetail(@RequestParam(value = "cadreId") Long cadreId) {
        return Message.success().add("detail",
                service.getLevelDetailByCadreId(cadreId));
    }

    @GetMapping(value = "/level-points")
    @ResponseBody
    public Message getPoints(@RequestParam(value = "cadreId") Long cadreId) {
        return Message.success().add("points",
                service.getLevelPoints(cadreId));
    }

    @GetMapping(value = "/delete-level-detail")
    @ResponseBody
    public Message deleteLevelDetail(@RequestParam("cadreId") long carderId) {
        final int i = service.deleteByCadreId(carderId);
        if (i != 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    @GetMapping(value = "/select-detail")
    @ResponseBody
    public Message selectByCadreId(@RequestParam("cadreId") long carderId) {
        return Message.success().add("list", service.selectByCadreId(carderId));
    }

    @PostMapping(value = "/update-detail")
    @ResponseBody
    public Message updateDetail(@RequestBody LevelDetail record) {
        final int i = service.updateByPrimaryId(record);
        if (i != 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    @PostMapping(value = "/insert-detail")
    @ResponseBody
    public Message insertDetail(@RequestBody List<LevelDetail> levelDetails) {
        service.batchInsert(levelDetails);
        return Message.success();
    }
}
