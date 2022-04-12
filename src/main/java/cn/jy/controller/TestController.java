package cn.jy.controller;

import cn.jy.bean.Msg;
import cn.jy.pojo.AdminS;
import cn.jy.pojo.App;
import cn.jy.pojo.State;

import cn.jy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private AppService appService;


    @RequestMapping("/test")
    public String test(Model model){
/*        List<AdminS> administratorsgly = administratorsService.Administratorsgly();
        model.addAttribute("msg",administratorsgly);*/
        return "test";
    }


    @RequestMapping(value = "/selectApp" )
    public String selectApp(Model model){
//        List<App> apps = appService.selectApp();
//        System.out.println(apps);
        App apps = appService.selectAppNP("admin","admin");
        model.addAttribute("msg",apps);
        return "select";
    }
    //这是跳转到登录页面
    @RequestMapping("/log")
    public void log(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/log.jsp").forward(request,response);
    }
    @RequestMapping("/log2")
    public void log2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/log2.jsp").forward(request,response);
    }
    //跳转到管理员页面 gly=1
    @RequestMapping("/administrators")
    public void administrators(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/administrators.jsp").forward(request,response);
    }
    //跳转到开发者页面 gly=0
    @RequestMapping("/developer")
    public void developer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/developer.jsp").forward(request,response);
    }

    //点击登录
    @ResponseBody
    @PostMapping("/selectAppNP")
    public Msg log(Model model, App app,HttpServletRequest request,HttpServletResponse response){
        App apps = appService.selectAppNP(app.getName(),app.getPwd());
        model.addAttribute("msg",apps);
        if (apps.getName()!=null || apps.getName()!=""){
            HttpSession session = request.getSession();
            session.setAttribute("info",apps.getName());
        }
        return Msg.success().add("userInfo",apps);
    }

    //处理404
        @RequestMapping("*")
        public String notFoundPage() {
            return "404";
        }

}
