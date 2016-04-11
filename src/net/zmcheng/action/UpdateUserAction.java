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
public class UpdateUserAction extends ActionSupport implements ModelDriven<User>, Serializable, ServletRequestAware {
	/**
	 * @author zmcheng
	 */
	private User user = new User();
	private userService userServiceImpl;
	private HttpServletRequest request;
	private String passwordAgain;
	private String Againpassword;
    private String result;
    private int CityId;
    private int ProId;
	private Set<City> citys = new HashSet<City>();
	public User getModel() {
		return user;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public UpdateUserAction() {
  
	}
	public User getSessionUser() throws Exception{
		 HttpSession httpSession = request.getSession(false);
	     User user2 = (User)httpSession.getAttribute("user");
	     return user2;
	}
    //修改密码
	public String updatePsw() throws Exception{ 
		 if(!user.getPassword().equals(passwordAgain)||(user.getPassword()==null)||(passwordAgain==null)){
			this.setResult("您两次输入的密码不一致");
			return SUCCESS;
		 }
	     User user2 = this.getSessionUser();
	     user2.setPassword(passwordAgain);
	     userServiceImpl.UserUpdate(user2);
	 	this.setResult("修改密码成功");
		return SUCCESS;
	}
	//修改所在地
	public String updateHome() throws Exception{ 
	    User user2 = this.getSessionUser();    
	    City city = userServiceImpl.UserCity(CityId);
	    user2.setCity(city);
	    user2.setProvince(city.getProvince());
	    userServiceImpl.UserUpdate(user2);
	 	this.setResult("成功");
		return SUCCESS;
	}
	//得到某省的所有城市
	public String GetCitys() throws Exception{
		HttpSession httpSession = request.getSession(false);
		Set<Province> pros  = (HashSet<Province>)httpSession.getAttribute("province");
        for (Province province : pros) {
			if(province.getId()==ProId){
				citys = province.getCitys();
				break;
			}
		}
		return SUCCESS;
	}
	//修改邮箱
	public String updateEmail() throws Exception{ 
		User user2 = this.getSessionUser();
	     user2.setEmail(user.getEmail());
	     userServiceImpl.UserUpdate(user2);
	 	this.setResult("修改邮箱成功");
		return SUCCESS;
	}
	//修改手机号码
		public String updatePhone() throws Exception{ 
			User user2 = this.getSessionUser();
		     user2.setPhone(user.getPhone());
		     userServiceImpl.UserUpdate(user2);
		 	this.setResult("修改手机号码成功");
			return SUCCESS;
		}
	public String execute() throws Exception {
		return SUCCESS;
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

	public String getAgainpassword() {
		return Againpassword;
	}

	public void setAgainpassword(String againpassword) {
		Againpassword = againpassword;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
    public Set<City> getCitys() {
		return citys;
	}
	public void setCitys(Set<City> citys) {
		this.citys = citys;
	}

	public int getProId() {
		return ProId;
	}

	public void setProId(int proId) {
		ProId = proId;
	}

	public int getCityId() {
		return CityId;
	}

	public void setCityId(int cityId) {
		CityId = cityId;
	}

}
