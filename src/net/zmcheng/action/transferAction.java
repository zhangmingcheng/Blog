package net.zmcheng.action;

import java.io.Serializable;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class transferAction extends ActionSupport implements Serializable{
	public String execute() throws Exception{
    	return SUCCESS;
    }
}
