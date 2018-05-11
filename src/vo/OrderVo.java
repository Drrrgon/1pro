package vo;

import java.sql.Timestamp;
import java.util.Date;

public class OrderVo {
	private int orederNo;
	private int menuNo;
	private int count;
	private Timestamp date = new Timestamp(new Date().getTime());
	
	public OrderVo() {
		super();
	}

	public OrderVo(int orederNo, int menuNo, int count, Timestamp date) {
		super();
		this.orederNo = orederNo;
		this.menuNo = menuNo;
		this.count = count;
		this.date = date;
	}

	public int getOrederNo() {
		return orederNo;
	}

	public void setOrederNo(int orederNo) {
		this.orederNo = orederNo;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "OrderVo [orederNo=" + orederNo + ", menuNo=" + menuNo + ", count=" + count + ", date=" + date + "]";
	}
	
	
}
