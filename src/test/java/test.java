import cn.jy.pojo.App;
import cn.jy.service.AppService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class test {
    @Autowired
    private AppService appService;
    @Test
    public void test(){
        App app=new App();
        app.setName("admin");
        app.setPwd("admin");
        App app1 = appService.selectAppNP("admin", "admin");
        System.out.println(app1);

    }


}
