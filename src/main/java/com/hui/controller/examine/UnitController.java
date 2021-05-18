package com.hui.controller.examine;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hui.entity.Message;
import com.hui.entity.examine.Unit;
import com.hui.service.examine.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/18 0:03
 */
@Controller
@RequestMapping(value = "units")
public class UnitController {
    UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    /**
     * 首页的部门考核得分
     * @param pageNumber the pageNumber
     * @return Message
     */
    @GetMapping(value = "unit-examine")
    @ResponseBody
    public Message selectAllUnitExamine(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        PageHelper.startPage(pageNumber,5);
        List<Unit> units = unitService.selectAll();
        //将得到的结果返回到PageInfo中
        PageInfo<Unit> pageInfo = new PageInfo<>(units, 3);
        return Message.success().add("pageInfo",pageInfo);
    }
}
