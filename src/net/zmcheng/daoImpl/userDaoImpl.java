package net.zmcheng.daoImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import net.zmcheng.dao.userDao;
import net.zmcheng.model.City;
import net.zmcheng.model.Province;
import net.zmcheng.model.User;
@Component
public class userDaoImpl implements userDao {
   
	private  SessionFactory sessionFactory;
	public boolean loginUser(User user) throws Exception{
	    Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User as c where c.name=:userName and c.password=:password");
		query.setString("userName", user.getName());
		query.setString("password", user.getPassword());
		List<User> result = query.list();
		for(User temp: result){
			user.setId(temp.getId());
			user.setPhone(temp.getPhone());
			user.setEmail(temp.getEmail());
			user.setPhoto(temp.getPhoto());
			user.setCreatetime(temp.getCreatetime());
			user.setCity(temp.getCity());
			user.setProvince(temp.getProvince());
			return true;
		}
	 return false;
}
	//得到用户居住地信息
	public City getHome(int CityId) throws Exception{
		City city = null;
	    Session session = sessionFactory.getCurrentSession();
	    city = (City)session.get(City.class, CityId);
		return city;
	}
	//修改用户信息
	public void update(User user) throws Exception{
	  Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}
	public boolean getUser(String  name) throws Exception{
		    Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from User as c where c.name=:userName");
			query.setString("userName", name);
			List<User> result = query.list();
		   if(!result.isEmpty()){
			  return true;
		   }
		 return false;
	}
	public boolean addUser(User user) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		if(this.getUser(user.getName())==false) {
		 session.save(user);
	     return true;
		}
		return false;
	}
	//得到所有省份
	public Set<Province> getProvince() throws Exception{
		 Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Province");
		List<Province> result = query.list();
		Set<Province> province = new HashSet<Province>();
		for(Province temp: result){
		     province.add(temp);
		}
		return province;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
