package net.zmcheng.dao;

import java.util.List;

import net.zmcheng.model.Message;
import net.zmcheng.model.Messages;

public interface messageDao {
	   public void add(Message message) throws Exception;
	    public void delete(Message message) throws Exception;
	    public void update(Message message) throws Exception;
	    public List<Messages>getAllMessage(final int start,final int  length) throws Exception;
	    public int getAllMessageNum() throws Exception;
	    public Message getMessageById(int messageId) throws Exception;
}
