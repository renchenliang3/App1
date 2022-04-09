package cn.jy.mapper;

import cn.jy.pojo.App;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppMapper {

    List<App> selectApp();
    //登录
    App selectAppNP(@Param("name") String name,@Param("pwd") String pwd);
}


