package vo;

public class SaleVo {
	private String date;
	private String menuList;
	private long totalSale;
	
	public SaleVo() {
		super();
	}
	public SaleVo(String date, String menuList, long totalSale) {
		super();
		this.date = date;
		this.menuList = menuList;
		this.totalSale = totalSale;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMenuList() {
		return menuList;
	}
	public void setMenuList(String menuList) {
		this.menuList = menuList;
	}
	public long getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(long totalSale) {
		this.totalSale = totalSale;
	}
	@Override
	public String toString() {
		return "SaleVo [date=" + date + ", menuList=" + menuList + ", totalSale=" + totalSale + "]";
	}
	
	
}
