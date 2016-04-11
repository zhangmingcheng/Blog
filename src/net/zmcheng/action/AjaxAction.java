package net.zmcheng.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AjaxAction extends ActionSupport {
     private String num1;
    public String execute(){
    	System.out.println("wowowowo");
    	return SUCCESS;
    }
	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	
}
