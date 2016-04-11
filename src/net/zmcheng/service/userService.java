package net.zmcheng.service;

import java.util.Set;

import net.zmcheng.model.City;
import net.zmcheng.model.Province;
import net.zmcheng.model.User;

public interface userService {
     public boolean UserLogin(User user) throws Exception;
     public boolean UserRegister(User user) throws Exception;
     public boolean getUser(String name) throws Exception;
     //修改用户信息
     public void UserUpdate(User user) throws Exception;
     //得到所有省份信息
     public Set<Province> UserProvince() throws Exception;
     //得到用户的居住信息
     public City UserCity(int CityId) throws Exception;
}
