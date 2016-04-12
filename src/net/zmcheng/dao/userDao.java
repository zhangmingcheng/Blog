package net.zmcheng.dao;

import java.util.Set;

import net.zmcheng.model.City;
import net.zmcheng.model.Province;
import net.zmcheng.model.User;

public interface userDao {
    public boolean addUser(User user) throws Exception;
	public boolean loginUser(User user) throws Exception;
	public boolean getUser(String name) throws Exception;
	//修改用户信息
	public void update(User user) throws Exception;
	//得到所有省份信息
	public Set<Province> getProvince() throws Exception;
	//得到用户居住地信息
	public City getHome(int CityId) throws Exception;
	//得到指定省的所有城市
	public Set<City> getCity(int ProId) throws Exception;
}
