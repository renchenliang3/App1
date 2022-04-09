package cn.jy.service.Impl;

import cn.jy.mapper.AppMapper;
import cn.jy.pojo.App;
import cn.jy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppMapper appMapper;


    @Override
    public List<App> selectApp() {
        return appMapper.selectApp();
    }

    @Override
    public App selectAppNP(String name, String pwd) {
        return appMapper.selectAppNP(name, pwd);
    }

}
