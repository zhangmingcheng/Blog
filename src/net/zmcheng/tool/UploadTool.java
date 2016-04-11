package net.zmcheng.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

public class UploadTool {
    public static String upload (HttpServletRequest request,File upload,String  uploadFileName,String userName) throws Exception{
    	 FileOutputStream fos  = null;
    	 FileOutputStream fos2  = null;
	     InputStream is = null;
	     String newName="";
    	 try{
    		//考虑给每个用户创建自己的文件夹,根据用户名。
    		String filePath=request.getSession().getServletContext().getRealPath("/");
    		//filePath就是当前这个web应用是绝对路径 /opt/apache-tomcat-8.0.23/wtpwebapps/Blog/
    		String FullfilePath=filePath+"images/"+userName+"/";
            String prefix=uploadFileName.substring(uploadFileName.lastIndexOf("."));
            newName = "default"+prefix;
    		//判断 FullfilePath文件夹是否存在
    		File f=new File(FullfilePath);
    		if(!f.isDirectory()){//如果 Fullfilepath表示的不是一个目录则返回true
    			//不是文件夹,创建即可
    			f.mkdirs();
    		}
    		//把上传的头像名字修改成编号.后缀，因为我们头像只使用最新的，旧的头像不删除占服务器内存
    		
    		String FullfilePath2 ="/home/zmc/workspace/Blog/WebContent/images/"+userName+"/";
    		File f2=new File(FullfilePath2);
    		if(!f2.isDirectory()){
    			f2.mkdirs();
    		}
    		FullfilePath+=newName;
    		FullfilePath2+=newName;
            fos = new FileOutputStream(FullfilePath);
            fos2 = new FileOutputStream(FullfilePath2);
    	    is = new FileInputStream(upload);
    		byte[] buffer = new byte[8192];
    		int count = 0;
    		while((count=is.read(buffer))>0){
    			fos.write(buffer, 0, count);
    			fos2.write(buffer, 0, count);
    		}					  
    		}catch (Exception e){
    			throw e;
    		}finally{
    			if(fos!=null)
    		        fos.close();
    			if(fos2!=null)
    		        fos2.close();
    			if(is!=null)
    		         is.close();
    		}
    	 //当此系统写完后，我不会将文件部署到tomcat里面，而是服务器中固定的文件中，以上重复代码是为防止重新部署Tomcat造成的文件丢失而写的 
    	 return newName;
    }
}
