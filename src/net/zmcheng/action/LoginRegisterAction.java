package net.zmcheng.action;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.City;
import net.zmcheng.model.Province;
import net.zmcheng.model.User;
import net.zmcheng.service.userService;

@SuppressWarnings("serial")
public class LoginRegisterAction extends ActionSupport implements ModelDriven<User> ,Serializable,ServletRequestAware {
	/**
	 * @author zmcheng
	 */
	private User user = new User();
	private userService userServiceImpl;
	private HttpServletRequest request;
	private String passwordAgain;
	public User getModel(){
		return user;
	}
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
    
	public LoginRegisterAction(){
		
	}
	//getUser
	public String execute() throws Exception{
		if( userServiceImpl.getUser(user.getName())==true){
		 	request.setAttribute("usererror", "此用户名已经存在");
		}
		else 	request.setAttribute("usererror", "合法");
		return SUCCESS;
	}
	public String quit() throws Exception{
	      HttpSession httpSession = request.getSession();
		  httpSession.removeAttribute("user");  //注销session中的user对象
		return SUCCESS;
	}
	public String login() throws Exception{
	  boolean flag=false;
	   flag=userServiceImpl.UserLogin(user);
	   Set<Province> province = userServiceImpl.UserProvince();
        if(flag==true){
        	     HttpSession httpSession = request.getSession();
            	 httpSession.setAttribute("user", user);
            	 httpSession.setAttribute("province", province);
            	 httpSession.setMaxInactiveInterval(2000);
        }else {
        	request.setAttribute("usererror", "密码或者用户名输入有误");
        	return LOGIN;
        }
		return SUCCESS;
	}
 public String register() throws Exception{
	 if(!user.getPassword().equals(passwordAgain)||(user.getPassword()==null)||(passwordAgain==null)){
		 request.setAttribute("usererror", "注册失败，请重新注册");
		 return INPUT;
	 }
	  Set<Province> province = userServiceImpl.UserProvince();
     boolean flag = false;
	 flag = userServiceImpl.UserRegister(user);
	  if(flag==true){
		  HttpSession httpSession = request.getSession();
 		 httpSession = request.getSession();
     	 httpSession.setAttribute("user", user);
    	 httpSession.setAttribute("province", province);
     	 httpSession.setMaxInactiveInterval(2000);
			return SUCCESS;
		}
	   else request.setAttribute("usererror", "注册失败，请重新注册");
		return INPUT;
	}
  
public userService getUserServiceImpl() {
	return userServiceImpl;
}
public void setUserServiceImpl(userService userServiceImpl) {
	this.userServiceImpl = userServiceImpl;
}
public String getPasswordAgain() {
	return passwordAgain;
}
public void setPasswordAgain(String passwordAgain) {
	this.passwordAgain = passwordAgain;
}
}
