package net.zmcheng.dao;

import java.util.List;

import net.zmcheng.model.Type;

public interface typeDao {
	    public void add(Type type) throws Exception;
	    public void delete(Type type) throws Exception;
	    public List<Type> selectAllType(final int start,final int  length) throws Exception;
	    public void update(Type type) throws Exception;
	    public int getAllType() throws Exception;
	    public Type  getType(int id) throws Exception;
	    public int getTypeNum(int Id) throws Exception;
}
