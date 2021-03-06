package by.htp.carparking.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.db.dao.UserDao;
import by.htp.carparking.db.dao.aop.CarDaoAspectImpl;
import by.htp.carparking.domain.Car;
import by.htp.carparking.domain.User;
import by.htp.carparking.service.CarService;

@Controller
public class LoginController {
	@Autowired
	private CarDao carDao;
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		System.out.println("in login");
		return "loginPage";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
	}
	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public void exception() {
		throw new RuntimeException();
	}
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public void purchase() {
		carDao.purchase(carDao.read(15), userDao.read(1), null);
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		System.out.println("in admin");
		return "admin";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
		System.out.println("in user");
		return "user";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(req, resp, auth);
		}
		return "login";
	}

}