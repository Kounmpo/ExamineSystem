package com.hui.controller.examine;

import com.hui.entity.Message;
import com.hui.service.examine.GroupExamineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huang jiehui
 * @date 2021/5/18 0:32
 */
@Controller
public class GroupExamineController {
    GroupExamineService groupExamineService;

    public GroupExamineController(GroupExamineService groupExamineService) {
        this.groupExamineService = groupExamineService;
    }

    /**
     * 部门考核得分详情
     * @param unitId the unitId
     * @return Message
     */
    @GetMapping(value = "examine-detail")
    @ResponseBody
    public Message examineDetail(@RequestParam("unitId") Long unitId) {
        return Message.success().add("detail", groupExamineService.selectByUnitId(unitId));
    }


    @GetMapping(value = "pointsSum")
    @ResponseBody
    public Message pointsSum(@RequestParam("unitId") Long unitId) {
        return Message.success().add("pointsSum", groupExamineService.selectPointsByUnitId(unitId));
    }
}
