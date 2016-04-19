package net.zmcheng.service;

import java.util.List;

import net.zmcheng.model.Message;
import net.zmcheng.model.ReplyMessage;

public interface messageService {
    public void add(Message message) throws Exception;
    public void delete(Message message) throws Exception;
    public void update(Message message) throws Exception;
    public List<Message> select(final int start,final int  length) throws Exception;
    public int getAllMessageNum() throws Exception;
    public Message getMessageById(int messageId) throws Exception;
    public void addReply(ReplyMessage rm) throws Exception;
}
