package com.itmayiedu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmayiedu.entity.User;
import com.itmayiedu.mapper.UserMapper;

/**
 * 
 * @author wangshang
 * @date 2018年6月21日/下午8:22:27
 * @类作用: controller
 */
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
	public String addUser() {

		return "addUser";
	}

	@RequestMapping("addUsers")
	public String addUsers(User u) {

		userMapper.insert(u);
		return "redirect:/findUser";
	}

	// 导出
	@RequestMapping("expor")
	public String expor() throws Exception {
		String title = "人员表";
		String[] rowsName = new String[] { "序号", "名字", "年龄" };
		List<User> user = userMapper.findByName();

		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		for (int i = 0; i < user.size(); i++) {
			User u = user.get(i);
			objs = new Object[rowsName.length];
			objs[0] = u.getId();
			objs[1] = u.getName();
			objs[2] = u.getAge();
			dataList.add(objs);
		}

		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		ex.export();
		return "redirect:/findUser";

	}
}
