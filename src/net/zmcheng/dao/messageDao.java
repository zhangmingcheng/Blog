package net.zmcheng.dao;

import java.util.List;

import net.zmcheng.model.Message;

public interface messageDao {
	   public void add(Message message) throws Exception;
	    public void delete(Message message) throws Exception;
	    public void update(Message message) throws Exception;
	    public List<Message> select() throws Exception;
}
