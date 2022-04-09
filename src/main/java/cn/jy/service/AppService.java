package cn.jy.service;

import cn.jy.pojo.App;

import java.util.List;

public interface AppService {
    List<App> selectApp();
    //登录
    App selectAppNP(String name,String pwd);

}
