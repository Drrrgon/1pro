package vo;

import java.sql.Timestamp;

import java.util.Date;

public class OrdersVo {
	private int orderNo;
	private int menuNo;
	private int count;
	private int total;
	private Timestamp time = new Timestamp(new Date().getTime());
	
	public OrdersVo() {
		super();
	}

	public OrdersVo(int orederNo, int menuNo, int count,int total, Timestamp time) {
		super();
		this.orderNo = orederNo;
		this.menuNo = menuNo;
		this.count = count;
		this.total = total;
		this.time = new Timestamp(new Date().getTime());
	}

	public int getOrederNo() {
		return orderNo;
	}

	public void setOrederNo(int orederNo) {
		this.orderNo = orederNo;
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

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "[ 주문 번호 : " + orderNo + ", 메뉴 : " + menuNo + ", 수량 : " + count +", 총 가격 : "+ total+", 주문 시각 : " + time + "]";
	}
	
	
}
