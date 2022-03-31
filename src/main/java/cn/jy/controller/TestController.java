package cn.jy.controller;

import cn.jy.mapper.AppMapper;
import cn.jy.pojo.App;
import cn.jy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private AppService appService;
    @RequestMapping("/test")
    public String test(Model model){

        model.addAttribute("msg","SSSSS");
        return "test";
    }


    @RequestMapping("/selectApp")
    public String selectApp(Model model){
        List<App> apps = appService.selectApp();
        System.out.println(apps);
        model.addAttribute("msg",apps);
        return "select";
    }
}
