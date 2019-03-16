package com.fengzhongguji.shrio.controller;
 
 
import com.fengzhongguji.shrio.domain.User;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

 
@Controller
public class UserController {
	@Autowired
	private com.fengzhongguji.shrio.service.UserService UserService;
	@RequestMapping("what")
	public String why(){
		return "sse";
	}
	@RequestMapping("one")
	public String getOne(){
		return "one";
	}
	@RequestMapping("two")
	public String getTwo(){
		return "two";
	}
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	@RequestMapping("permission")
	public String permission(){
		return "permission";
	}
	
	@RequestMapping("toLogin")
	public String toLogin(User user, Model model){
		
		//System.out.println(newUser.getName()+newUser.getPassword());
		//shiro用户认证
	    //获取subject
		Subject subject = SecurityUtils.getSubject();
		//封装用户数据
		UsernamePasswordToken userToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());
		//执行登录方法,用捕捉异常去判断是否登录成功
		try {
			subject.login(userToken);
			return "redirect:/what.do";
		} catch (UnknownAccountException e) {
			//用户名不存在
			model.addAttribute("msg","用户名不存在");
			return "login";
		}catch (IncorrectCredentialsException e) {
			//密码错误
			model.addAttribute("msg","密码错误");
			return "login";
		}
		
	}
 
}
