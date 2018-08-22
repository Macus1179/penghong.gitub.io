package cn.tedu.ssm.spring.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import cn.tedu.ssm.spring.entity.User;
import cn.tedu.ssm.spring.entity.userList;
import cn.tedu.ssm.spring.service.UserListService;
import cn.tedu.ssm.spring.service.UserService;
import cn.tedu.ssm.spring.service.excption.DataNotFoundException;
import cn.tedu.ssm.spring.service.excption.ServiceException;
import cn.tedu.ssm.spring.service.excption.UserExction;
import cn.tedu.ssm.spring.service.excption.UsernameTakenException;
import cn.tedu.ssm.spring.web.JsonResult;
import cn.tedu.ssm.spring.web.Paginator;
import cn.tedu.ssm.spring.web.ResponseResult;


@Controller("actionControl")
@RequestMapping("/ems")
public class ActionControl {
@Resource(name="userService")

private UserService userService;
@Resource(name="userListService")
private UserListService userListService;
	@RequestMapping("/regist.do")
	public String regist(){
	
		return "regist";

	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	 public String register(User use,ModelMap mp){		
			try{
		//调用userService实现注册将数据存到数据库		
			userService.regist(use);
			System.out.println(use);
			return "redirect:login.do";
		}catch(UsernameTakenException e){
			mp.addAttribute("errorMessage", e.getMessage());
			System.out.println(mp);
			return "error";
		}
	}
	@ExceptionHandler(UsernameTakenException.class)
	public String handleUsernameTakenException(
			UsernameTakenException e,
			HttpServletRequest req){
		e.printStackTrace();
		req.setAttribute("errorMessage", 
				e.getMessage());
		return "regist";
	}
	@ExceptionHandler  //handler 管xxx的人, 司
	public String handleException(
			Exception e, 
			HttpServletRequest req){
		System.out.println("Call handleException");
		e.printStackTrace();
		req.setAttribute("errorMessage", 
		e.getMessage());
		return "error";
	}
	
	@RequestMapping("/login.do")
	public String login(){
		return "login";
	}
	@RequestMapping("/check_username.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(@Param("username") String username){
		ResponseResult<Void> js;
		//执行检查
		try{
		userService.findByUsername(username);
		System.out.println(username.toString());
		//找到匹配数据用户名存在
		js=new ResponseResult<Void>(1,"用户名已存在");
		
		System.out.println(js);
		return js;
		}catch(DataNotFoundException e){
			js=new ResponseResult<Void>(0,"用户名可用");
			return js;
		}
	}
	@RequestMapping(value="/loginUser.do",method=RequestMethod.POST)
	public String loginUser(String username,String password,HttpSession session,ModelMap map){
		try{
		User u =userService.Login(username, password);
		session.setAttribute("uid", u.getId());
		session.setAttribute("username", u.getUsername());
		session.setAttribute("password", password);
		return "redirect:list_user.do";
		}catch(ServiceException e){
			map.addAttribute("errorMessage", e.getMessage());
			return "error";
		}
	}
	@RequestMapping("/a.do")
	public String list(){
	
		return "index";
	}
	@RequestMapping("/listUI.do")
	
	public String list2(){
	
		return "user_list";
	}
	@RequestMapping(value="/show.do",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> show(@RequestParam Map<String, Object> params,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows){
		Map<String, Object> result = new HashMap<String, Object>();
		/*if (page == null) {
			page = Paginator.DEFAULT_CURRENT_PAGE;
		}
		if (rows == null) {
			rows = Paginator.DEFAULT_PAGE_SIZE;
		}*/
		Paginator paginator = new Paginator(page, rows);
		List<userList> u =userListService.findAll();
		result.put("total", u.size());
		result.put("rows", u);
		result.put("page", page);
		result.put("totalPage", u.size() % rows == 0 ? u.size() / rows : u.size() / rows + 1);
		System.out.println(u.size()+page+ u.size() % rows == 0 ? u.size() / rows : u.size() / rows + 1);
		return result;
	}


}












