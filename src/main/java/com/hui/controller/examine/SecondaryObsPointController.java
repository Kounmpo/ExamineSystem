package com.hui.controller.examine;

import com.hui.entity.Message;
import com.hui.entity.examine.SecondaryObsPoint;
import com.hui.service.examine.SecondaryObsPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huang jiehui
 * @date 2021/5/19 16:15
 */
@Controller
public class SecondaryObsPointController {
    SecondaryObsPointService service;

    @Autowired
    public SecondaryObsPointController(SecondaryObsPointService service) {
        this.service = service;
    }

    @GetMapping(value = "/points")
    @ResponseBody
    public Message selectAll(@RequestParam("unitId") Long unitId){
        return Message.success().add("all",service.selectAll(unitId));
    }

    @PostMapping(value = "/edit-secondary")
    @ResponseBody
    public Message editSecondary(@RequestBody SecondaryObsPoint record) {
        int flag = service.updateByPrimaryId(record);
        if (flag != 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    @GetMapping(value = "/secondary-name")
    @ResponseBody
    public Message secondaryName(@RequestParam(value = "groupExamine") int groupExamine) {
        return Message.success().add("name",service.selectByGroupExamine(groupExamine));
    }
}
