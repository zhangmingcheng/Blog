package net.zmcheng.tool;

public class Paging {
    
    private int allRow;//总记录数
    private int currentPage = 1;//当前页
    private static int pageSize = 8;//每页记录数
	private int totalPage;//总页数
    /*
     * 计算总页数
     */
    public int countTotalPage(final int allRow){
    	int totalPage = allRow%Paging.pageSize==0?allRow/Paging.pageSize:allRow/Paging.pageSize+1;
    	return totalPage;
    }
    /*
     * 计算当前页开始的记录
     */
    public int countOffset(){
    	int offset = Paging.pageSize *( this.currentPage-1);
    	return offset;
    }
    /*
     * 根据记录数判断这个记录在哪一页
     */
    public int JudgePage(int num){
          if(num<=Paging.pageSize)
        	  this.setCurrentPage(1);
          else if(num%Paging.pageSize==0)
        	  this.setCurrentPage(num/Paging.pageSize);
          else  this.setCurrentPage(num/Paging.pageSize+1);
          return this.getCurrentPage();
	}
    public int getTotalPage() {
  		return totalPage;
  	}
  	public void setTotalPage(int totalPage) {
  		this.totalPage = totalPage;
  	}
	public Paging(){
    	super();
    }
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public static int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		   Paging.pageSize = pageSize;
	}

}