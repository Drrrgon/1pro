package vo;

public class MenuVo {
	private int menuNo;
	private String mName;
	private int mPrice;
	private int mOriginalPrice;
	
	public MenuVo() {
		super();
	}

	public MenuVo(int menuNo, String mName, int mPrice, int mOriginalPrice) {
		super();
		this.menuNo = menuNo;
		this.mName = mName;
		this.mPrice = mPrice;
		this.mOriginalPrice = mOriginalPrice;
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

	public int getmPrice() {
		return mPrice;
	}

	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}

	public int getmOriginalPrice() {
		return mOriginalPrice;
	}

	public void setmOriginalPrice(int mOriginalPrice) {
		this.mOriginalPrice = mOriginalPrice;
	}

	@Override
	public String toString() {
		return "MenuVo [menuNo=" + menuNo + ", mName=" + mName + ", mPrice=" + mPrice + ", mOriginalPrice="
				+ mOriginalPrice + "]";
	}
	
	
}
