package net.zmcheng.serviceImpl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.zmcheng.dao.userDao;
import net.zmcheng.model.City;
import net.zmcheng.model.Province;
import net.zmcheng.model.User;
import net.zmcheng.service.userService;
@Component
public class userServiceImpl implements userService {
  
	private userDao userDaoImpl;
	public boolean UserLogin(User user) throws Exception {
		return userDaoImpl.loginUser(user);
	}
    //得到所有省份信息
	  public Set<Province> UserProvince() throws Exception{
		  return userDaoImpl.getProvince() ;
	  }
	//得到用户的居住信息
	 public City UserCity(int CityId) throws Exception{
		 return userDaoImpl.getHome(CityId);
	 }
	 //得到指定省的所有城市
	 public Set<City> getCitys(int ProId) throws Exception{
		 return  userDaoImpl.getCity(ProId);
	 }
	public boolean UserRegister(User user) throws Exception {
		return userDaoImpl.addUser(user);
	}
	public void UserUpdate(User user) throws Exception{
		 userDaoImpl.update(user);
	}
	public boolean getUser(String name) throws Exception{
		return  userDaoImpl.getUser(name);
	}
	 public userDao getUserDaoImpl() {
			return userDaoImpl;
		}
       @Resource
		public void setUserDaoImpl(userDao userDaoImpl) {
			this.userDaoImpl = userDaoImpl;
		}

}
