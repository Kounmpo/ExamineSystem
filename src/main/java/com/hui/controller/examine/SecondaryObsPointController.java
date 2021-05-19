package com.hui.controller.examine;

import com.hui.entity.Message;
import com.hui.service.examine.SecondaryObsPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
