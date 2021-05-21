package com.hui.controller.examine;

import com.hui.entity.Message;
import com.hui.service.examine.FirstObsPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huang jiehui
 * @date 2021/5/19 19:39
 */
@Controller
public class FirstObsPointController {
    FirstObsPointService service;

    @Autowired
    public FirstObsPointController(FirstObsPointService service) {
        this.service = service;
    }

    @RequestMapping("/first")
    @ResponseBody
    public Message getAllFirstPoint(@RequestParam("unitId") Long unitId) {
        return Message.success().add("all",service.selectAll(unitId));
    }

    @RequestMapping(value = "/daily-points")
    @ResponseBody
    public Message getPoints(@RequestParam("unitId") Long unitId) {
        return Message.success().add("points",
                service.getUnitDailyPoints(unitId));
    }

    @RequestMapping("/first-cadre")
    @ResponseBody
    public Message getAllCadreFirstPoint(@RequestParam("cadreId") Long cadreId) {
        return Message.success().add("all",service.selectAllCadre(cadreId));
    }
}
