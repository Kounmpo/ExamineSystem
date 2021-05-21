package com.hui.controller.examine;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hui.entity.Message;
import com.hui.entity.examine.Cadre;
import com.hui.service.examine.CadreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author huang jiehui
 * @date 2021/5/17 0:33
 */
@Controller
public class CadreController {
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
                                       Cadre cadre) {
        PageHelper.startPage(pageNumber,10);
        PageInfo<Cadre> pageInfo = new PageInfo<>(cadreService.selectForIndex(cadre),
                3);
        return Message.success().add("pageInfo", pageInfo);
    }
}
