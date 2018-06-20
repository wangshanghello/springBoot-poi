
package com.itmayiedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmayiedu.entity.User;
import com.itmayiedu.mapper.UserMapper;
/**
 * 
 *  @author wangshang
 * 	@date 2018年6月20日/上午10:08:39  
 * 	@类作用:
 */
//如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面
@Controller
public class IndexController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/findUser")
	public String findUser(HttpServletRequest request) {
		 List<User> user = userMapper.findByName();
		request.setAttribute("user", user);
		return "findUser";
	}
	@RequestMapping("addUser")
	public String addUser(){
		
		return "addUser";
	}
	@RequestMapping("addUsers")
	public String addUsers(User u){
		
		userMapper.insert(u);
		return "redirect:/findUser";
	}
	
}
