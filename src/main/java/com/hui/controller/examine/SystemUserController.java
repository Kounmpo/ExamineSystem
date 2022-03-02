package com.hui.controller.examine;

import com.hui.entity.Message;
import com.hui.entity.examine.SystemUser;
import com.hui.service.examine.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/24 10:22
 */
@Controller
public class SystemUserController {

    @Autowired
    SystemUserService service;

    @PostMapping("/user-list")
    @ResponseBody
    public Message selectSelective(@RequestBody SystemUser record) {
        final List<SystemUser> systemUsers = service.selectSelective(record);
        if (systemUsers.isEmpty()) {
            return Message.fail();
        } else {
            return Message.success().add("list", systemUsers);
        }
    }

    @PostMapping("/edit-user")
    @ResponseBody
    public Message updateSelective(@RequestBody SystemUser record) {
        final int i = service.updateByPrimaryKeySelective(record);
        if (i != 0) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    @GetMapping(value = "/delete-user")
    @ResponseBody
    public Message deleteUser(@RequestParam(value = "userId") long userId) {
        service.deleteByPrimaryId(userId);
        return Message.success();
    }

    @PostMapping("/insert-user")
    @ResponseBody
    public Message insert(@RequestBody SystemUser user) {
        SystemUser systemUser = service.selectByRealName(user);
        if (systemUser != null) {
            return Message.fail().add("list","用户已存在");
        } else {
            service.insert(user);
            return Message.success();
        }
    }

    @PostMapping("/user-login")
    @ResponseBody
    public Message login(@RequestBody SystemUser user) {
        SystemUser systemUser = service.selectUser(user);
        if (systemUser != null) {
            return Message.success().add("list",systemUser);
        } else {
            return Message.fail().add("list","用户名或者密码错误");
        }
    }
}
