package net.zmcheng.action;

import java.io.Serializable;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.zmcheng.model.Type;
import net.zmcheng.service.typeService;
import net.zmcheng.tool.Paging;

@SuppressWarnings("serial")
public class TypeAction extends  ActionSupport implements Serializable , ModelDriven<Paging>{
	
	private List<Type> list;//要返回的某一页的记录
	private int id;
	private String name;
	private Paging paging = new Paging();
	private typeService typeServiceImpl;
	private String result;
	public Paging getModel(){
		return paging;
	}
	//得到指定页数的数据
	 public String execute() throws Exception{
		   this.getLists();
		   return SUCCESS;
	   }
	 public void getLists() throws Exception{
		  int len = typeServiceImpl.getAllType();
		   int totalpage = paging.countTotalPage(len);
		   paging.setTotalPage(totalpage);
		   int start =paging.countOffset();
		   list =  typeServiceImpl.selectAllType(start, Paging.getPageSize());
	 }
	 public String add() throws Exception{
		 Type type  = new Type();
		 type.setName(this.name);
		 typeServiceImpl.add(type);
		 this.getLists();
		 return SUCCESS;
	 }
	 public String update() throws Exception{
		  Type type =  typeServiceImpl.getType(this.getId());
		  this.setName(type.getName());
		 return SUCCESS;
	 }
	 public String update2() throws Exception{
		 Type type = typeServiceImpl.getType(this.getId());
		 type.setName(this.getName());
		 typeServiceImpl.update(type);
		 this.result = "修改友链成功";
		 return SUCCESS;
	 }
	//删除指定文章类别
	 public String delete() throws Exception{
		 Type type = new Type();
		 type.setId(this.id);
		 typeServiceImpl.delete(type);
		 //判断删除友链后应拿到哪一页的数据
		  int flag = paging.JudgePage(typeServiceImpl.getTypeNum(id));
		  paging.setCurrentPage(flag);
		   int len =  typeServiceImpl.getAllType();
		   int totalpage = paging.countTotalPage(len);
		   paging.setAllRow(len);
		   paging.setTotalPage(totalpage);
		   int start =paging.countOffset();
		   list = typeServiceImpl.selectAllType(start, Paging.getPageSize());
		 return SUCCESS;
	 }
	  public List<Type> getList() {
			return list;
		}
		public void setList(List<Type> list) {
			this.list = list;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public typeService getTypeServiceImpl() {
			return typeServiceImpl;
		}
		public void setTypeServiceImpl(typeService typeServiceImpl) {
			this.typeServiceImpl = typeServiceImpl;
		}
}