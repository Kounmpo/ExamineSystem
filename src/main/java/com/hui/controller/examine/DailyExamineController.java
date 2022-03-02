package com.hui.controller.examine;

import com.hui.entity.Message;
import com.hui.entity.examine.DailyExamine;
import com.hui.service.examine.DailyExamineService;
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
 * @date 2021/5/23 15:11
 */
@Controller
public class DailyExamineController {

    @Autowired
    DailyExamineService service;

    @GetMapping(value = "/edit-cadre-daily")
    @ResponseBody
    public Message editCadreDaily(@RequestParam(value = "cadreId") Long cadreId) {
        return Message.success().add("list", service.selectDailyByCadreId(cadreId));
    }

    @GetMapping(value = "/delete-cadre-daily")
    @ResponseBody
    public Message deleteCadreDaily(@RequestParam(value = "cadreId") Long cadreId) {
        int flag = service.deleteByCadreId(cadreId);
        if (flag != 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    @GetMapping(value = "/delete-unit-daily")
    @ResponseBody
    public Message deleteUnitDaily(@RequestParam(value = "unitId") Long unitId) {
        int flag = service.deleteByUnitId(unitId);
        if (flag != 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    @PostMapping(value = "/insert-cadre-daily")
    @ResponseBody
    public Message insertCadreDaily(@RequestBody List<DailyExamine> list) {
        service.insertSelective(list);
        return Message.success();
    }


    @GetMapping(value = "/edit-unit-daily")
    @ResponseBody
    public Message editUnitDaily(@RequestParam(value = "unitId") Long unitId) {
        return Message.success().add("list", service.selectDailyByUnitId(unitId));
    }


}
