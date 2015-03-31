package onlineClass.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import onlineClass.domain.User;
import onlineClass.encryption.MD5;
import onlineClass.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profilePage() {
		User user = userService.myInfo();
		List<String> pswl = new ArrayList<String>();
		String psw = user.getPassword();
		return "profile";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(String user_name,String old_psw,String new_psw,PrintWriter printWriter) {
		Boolean isModify=false;
		User myinfo = userService.myInfo();
		String psw = myinfo.getPassword();
		MD5 md5 = new MD5();
		String encry_old_psw = md5.getMD5String(old_psw);
		String encry_new_psw = md5.getMD5String(new_psw);
		
		if(encry_old_psw.equals(psw)){
			User user=new User();
			user.setUser_id(myinfo.getUser_id());
			user.setPassword(encry_new_psw);
			user.setUser_name(user_name);
			isModify=userService.modify(user);
		}
		if(isModify){
			return "modifysucceed";
		}
		return "modifyfail";
	}

	@RequestMapping(value = "/registerpage", method = RequestMethod.GET)
	public String getRegisterpage() {
		return "registerpage";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(String user_id, String user_name, String password) {
		User user = new User();
		Boolean isSuccess;
		MD5 md5 = new MD5();
		String Encry_password = md5.getMD5String(password);
		user.setUser_id(user_id);
		user.setUser_name(user_name);
		user.setPassword(Encry_password);

		isSuccess = userService.addUser(user);
		if (isSuccess) {
			return "registersuccess";
		} else {
			return "registerfail";
		}
	}

}
