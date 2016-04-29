package net.zmcheng.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.zmcheng.dao.typeDao;
import net.zmcheng.model.Type;
import net.zmcheng.service.typeService;
@Component
public class typeServiceImpl implements typeService {
     private typeDao typeDaoImpl;
	public void add(Type type) throws Exception {
		 typeDaoImpl.add(type);
	}
	public int getTypeNum(int Id) throws Exception{
		return typeDaoImpl.getTypeNum(Id);
	}
	public void delete(Type type) throws Exception {
          typeDaoImpl.delete(type);
	}

	public List<Type> selectAllType(int start, int length) throws Exception {
		return typeDaoImpl.selectAllType(start, length);
	}

	public void update(Type type) throws Exception {
         typeDaoImpl.update(type);
	}

	public int getAllType() throws Exception {
		return typeDaoImpl.getAllType();
	}

	public Type getType(int id) throws Exception {
		return typeDaoImpl.getType(id);
	}

	public typeDao getTypeDaoImpl() {
		return typeDaoImpl;
	}
   @Resource
	public void setTypeDaoImpl(typeDao typeDaoImpl) {
		this.typeDaoImpl = typeDaoImpl;
	}

}
