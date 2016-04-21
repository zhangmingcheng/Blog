package net.zmcheng.service;

import java.util.List;

import net.zmcheng.model.Message;
import net.zmcheng.model.Messages;

public interface messageService {
    public void add(Message message) throws Exception;
    public void delete(int id) throws Exception;
    public void update(Message message) throws Exception;
    public List<Messages> select(final int start,final int  length) throws Exception;
    public int getAllMessageNum() throws Exception;
    public Message getMessageById(int messageId) throws Exception;
    public void updateStatus(int id) throws Exception;
}
