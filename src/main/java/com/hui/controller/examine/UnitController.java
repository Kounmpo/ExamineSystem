package com.hui.controller.examine;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hui.entity.Message;
import com.hui.entity.examine.Unit;
import com.hui.service.examine.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/18 0:03
 */
@Controller
public class UnitController {

    private static List<String> errorList = new ArrayList<>();
    UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    /**
     * 首页的部门考核得分
     * @param pageNumber the pageNumber
     * @return Message
     */
    @GetMapping(value = "/unit-examine")
    @ResponseBody
    public Message selectAllUnitExamine(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        PageHelper.startPage(pageNumber,5);
        List<Unit> units = unitService.selectAll();
        //将得到的结果返回到PageInfo中
        PageInfo<Unit> pageInfo = new PageInfo<>(units, 3);
        return Message.success().add("pageInfo",pageInfo);
    }

    @PostMapping(value = "/edit-unit")
    @ResponseBody
    public Message editUnit(@RequestBody Unit unit) {
        errorList.clear();
        if (unit.getName().isEmpty()) {
            errorList.add("单位名称不能为null");
        }
        if (unit.getUnitCode().isEmpty()) {
            errorList.add("单位编码不能为空!");
        }
        if (errorList.isEmpty()) {
            unitService.editUnit(unit);
            return  Message.success().add("errorList", errorList);
        } else {
            return Message.fail();
        }

    }

    @PostMapping(value = "/delete-unit")
    @ResponseBody
    public Message deleteUnit(@RequestBody List<Unit> units) {
        unitService.batchDelete(units);
        return Message.success();
    }

    @GetMapping(value = "/insert-unit")
    @ResponseBody
    public Message insertUnit(@RequestBody Unit unit) {
        int flag = unitService.insertUnit(unit);
        if (flag == 1) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }
}
