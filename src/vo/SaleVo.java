package vo;

import java.sql.Timestamp;
import java.util.Date;

public class SaleVo {
	private Timestamp date = new Timestamp(new Date().getTime());
	private String menuList;
	private long totalSale;
	
	public SaleVo() {
		super();
	}
	public SaleVo(Timestamp date, String menuList, long totalSale) {
		super();
		this.date = date;
		this.menuList = menuList;
		this.totalSale = totalSale;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
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
