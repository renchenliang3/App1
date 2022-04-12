package cn.jy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //类似于 filter中的doFilter（）  放行的意思  返回值是一个true 则请求就可以继续向下执行
        //在controller中的方法执行前执行
        /*System.out.println("preHandle方法执行了1");*/
/*        HttpSession session = request.getSession();
        String info = (String) session.getAttribute("info");
        if ("admin".equals(info)){
            //是管理员
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/log.jsp").forward(request,response);*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //postHandle()方法：该方法会在控制器方法调用之后，且解析视图之前执行。可以通过此方法对请
        //求域中的模型和视图做出进一步的修改。
        System.out.println("postHandle方法执行了2");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //afterCompletion()方法：该方法会在整个请求完成，即视图渲染结束之后执行。可以通过此方法实
        //现一些资源清理、记录日志信息等工作
        System.out.println("afterCompletion方法执行了3");
    }
}
