package net.zmcheng.action;

import java.io.File;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import net.zmcheng.model.User;
import net.zmcheng.service.userService;
import net.zmcheng.tool.UploadTool;

@SuppressWarnings("serial")
public class UploadPhotoAction extends ActionSupport implements Serializable,ServletRequestAware{

	/**
	 * @author zmcheng
	 */
	private File upload;
	private userService userServiceImpl;
	private String uploadFileName;
	private String uploadContentType;
	private String result;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	public String execute() throws Exception{
		HttpSession httpSession = request.getSession(false);
		User user = (User)httpSession.getAttribute("user");
		String  name = user.getName();
		String fileName;
		fileName = UploadTool.upload(request,upload, uploadFileName,name);
		user.setPhoto(fileName);
     	userServiceImpl.UserUpdate(user);
		//把头像上传到服务器 /Blog/images/用户名/图片名
     	result="文件上传成功";
		return  SUCCESS;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public userService getUserServiceImpl() {
		return userServiceImpl;
	}
	public void setUserServiceImpl(userService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
}