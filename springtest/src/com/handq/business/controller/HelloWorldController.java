package com.handq.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.handq.business.service.UserService;

@Controller
@RequestMapping(value = "test")
public class HelloWorldController
{
    
    
    @Autowired 
    private UserService userService;
    
    @RequestMapping("/hello")
    public ModelAndView helloWorld(HttpServletRequest request)
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
        return view;
        
    }
    
}
