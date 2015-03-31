package onlineClass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import onlineClass.dao.DbUserDao;
import onlineClass.service.CustomUserDetailsService;

@Controller
@RequestMapping("auth")
public class LoginLogoutController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(
			@RequestParam(value = "error", required = false) boolean error,
			ModelMap model) {

		if (error == true) {
			if (CustomUserDetailsService.userNotFound == true)
				model.put("error", "用户名错误!");
			else {
				model.put("error", "密码错误!");
			}
		}
		return "login";

	}

	/**
	 * no authority
	 * 
	 *
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {

		return "deniedpage";

	}

}
