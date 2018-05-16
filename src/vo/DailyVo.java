package vo;

public class DailyVo {
	private int menuNo;
	private String mName;
	private int count;
	private int total;
	private int moriginalPrice;
	public DailyVo() {
		super();
	}
	public DailyVo(int menuNo, String mName, int count, int total, int moriginalPrice) {
		super();
		this.menuNo = menuNo;
		this.mName = mName;
		this.count = count;
		this.total = total;
		this.moriginalPrice = moriginalPrice;
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getMoriginalPrice() {
		return moriginalPrice;
	}
	public void setMoriginalPrice(int moriginalPrice) {
		this.moriginalPrice = moriginalPrice;
	}
	@Override
	public String toString() {
		return "DailyVo [menuNo=" + menuNo + ", mName=" + mName + ", count=" + count + ", total=" + total
				+ ", moriginalPrice=" + moriginalPrice + "]";
	}
	
	
}
