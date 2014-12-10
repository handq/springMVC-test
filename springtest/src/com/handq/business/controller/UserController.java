package com.handq.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.handq.business.service.UserService;
//控制层配置
@Controller 
@RequestMapping(value = "user")
public class UserController
{
    
    /**
     * @Description: {ͨ��ע��ķ�ʽע��userService}
     */
    @Resource(name = "userService")
    private UserService userService;
    
    // @Resource(name="userService")
    // public void setUserService(UserService userService)
    // {
    // this.userService = userService;
    // }
    public void test(){
    	System.out.println("000000000000000000");
    }
    
    
    @RequestMapping("/list")
    public String helloWorld(HttpServletRequest request)
    {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        ModelAndView view = new ModelAndView();
        
        if (userService.updatePerson())
        { // ��֤�û��ķ���д��service��
            session.setAttribute("username", username);
            
            // ���ص���ͼ���,/WEB-INF/view/welcome.jsp
            view.setViewName("welcome");
            view.addObject("username", username);// ������ģ��
        }
        return "user";
        
    }
    
}
