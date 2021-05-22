package com.hui.controller.examine;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hui.entity.Message;
import com.hui.entity.examine.Cadre;
import com.hui.service.examine.CadreService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2021/5/17 0:33
 */
@Controller
public class CadreController {

    private static String PATTEN_REGEX_PHONE= "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|" +
            "([8][0-9])|([9][1,8,9]))[0-9]{8}$";
    private static String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    /**
     * 分页数据以json的形式返回
     */
    CadreService cadreService;

    @Autowired
    public CadreController(CadreService cadreService) {
        this.cadreService = cadreService;
    }

    @GetMapping(value = "/cadres")
    @ResponseBody
    public Message getAllCadre(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        PageHelper.startPage(pageNumber,10);
        List<Cadre> cadres = cadreService.selectSelective(new Cadre());
        //将得到的结果返回到PageInfo中
        PageInfo<Cadre> pageInfo = new PageInfo<>(cadres, 3);
        return Message.success().add("pageInfo",pageInfo);
    }

    @GetMapping(value = "/cadres-index")
    @ResponseBody
    public Message getAllCadreForIndex(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                       @RequestBody Cadre cadre) {
        PageHelper.startPage(pageNumber,10);
        PageInfo<Cadre> pageInfo = new PageInfo<>(cadreService.selectForIndex(cadre),
                3);
        return Message.success().add("pageInfo", pageInfo);
    }


    /**
     * 干部信息维护 增删改查
     */
    @PostMapping(value = "/update-cadre")
    @ResponseBody
    public Message updateSelective(Cadre cadre) {
        List<String> errorList = new ArrayList<>();
        if (cadre.getName().length() > 20 && cadre.getName().length() < 2) {
            errorList.add("姓名长度不得超过20个字符，不得低于2个字符");
        }
        if (!cadre.getPhone().matches(PATTEN_REGEX_PHONE)) {
            errorList.add("电话号码输入错误！");
        }
       if (cadre.getEmail().matches(pattern1)) {
           errorList.add("邮箱格式不正确！");
       }

        cadreService.updateBySelective(cadre);
        return Message.success().add("errorMessage", errorList);
    }

    /**
     * 批量删除干部和单个删除
     */
    @PostMapping(value = "/batch-delete")
    @ResponseBody
    public Message batchDelete(@RequestBody List<Cadre> cadres) {
        cadreService.batchDelete(cadres);
        return Message.success();
    }

    /**
     * 增加干部
     */
    @PostMapping(value = "/insert-cadre")
    @ResponseBody
    public Message insert(@RequestBody Cadre cadre) {
        List<String> errorList = new ArrayList<>();
        if (cadre.getName().length() > 20 && cadre.getName().length() < 2) {
            errorList.add("姓名长度不得超过20个字符，不得低于2个字符");
        }
        if (!cadre.getPhone().matches(PATTEN_REGEX_PHONE)) {
            errorList.add("电话号码输入错误！");
        }
        if (cadre.getEmail().matches(pattern1)) {
            errorList.add("邮箱格式不正确！");
        }
        if (cadre.getUnitId() == null) {
            errorList.add("部门Id不能为空!");
        }
        if (cadre.getCadreCode().isEmpty()) {
            errorList.add("干部编码不能为空!");
        }
        cadreService.insert(cadre);
        return Message.success().add("errorMessage", errorList);
    }
}
