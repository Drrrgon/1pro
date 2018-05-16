package vo;

import java.sql.Timestamp;
import java.util.Date;

public class SaleVo {
	private Timestamp date = new Timestamp(new Date().getTime());
	private String menuList;
	private int totalSale;
	private int originalSale;
	public SaleVo() {
		super();
	}
	public SaleVo(String menuList, int totalSale, int originalSale) {
		super();		
		this.menuList = menuList;
		this.totalSale = totalSale;
		this.originalSale = originalSale;
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
	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
	}
		
	public int getOriginalPrice() {
		return originalSale;
	}
	public void setOriginalPrice(int originalPrice) {
		this.originalSale = originalPrice;
	}
	@Override
	public String toString() {
		return  menuList + "\n 매출 합계 : " + totalSale + "원 원가 합계 : "
				+ originalSale + "원";
	}
	
	
	
}
