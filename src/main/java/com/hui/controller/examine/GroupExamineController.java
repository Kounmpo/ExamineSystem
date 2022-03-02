package com.hui.controller.examine;

import com.hui.entity.Message;
import com.hui.entity.examine.GroupExamine;
import com.hui.service.examine.GroupExamineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

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
    @GetMapping(value = "/examine-detail")
    @ResponseBody
     public Message examineDetail(@RequestParam("unitId") Long unitId) {
        return Message.success().add("detail", groupExamineService.selectByUnitId(unitId));
    }


    @GetMapping(value = "/pointsSum")
    @ResponseBody
     public Message pointsSum(@RequestParam("unitId") Long unitId) {
        return Message.success().add("pointsSum", groupExamineService.selectPointsByUnitId(unitId));
    }

   @PostMapping(value = "/delete-group")
   @ResponseBody
    public Message deleteGroup(@RequestParam("unitId") Long unitId) {
        int flag = groupExamineService.deleteByUnitId(unitId);
        if (flag != 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
   }

   @PostMapping(value = "/update-group")
   @ResponseBody
   public Message updateGroup(@RequestBody GroupExamine record) {
        int flag = groupExamineService.updateByPrimaryKey(record);
        if (flag != 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
   }

   @PostMapping(value = "/insert-group")
   @ResponseBody
    public Message insertGroup(@RequestBody List<GroupExamine> records) {
        groupExamineService.insert(records);
        return Message.success();
   }



}
