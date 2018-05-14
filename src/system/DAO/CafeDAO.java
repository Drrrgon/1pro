package system.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vo.MenuVo;
import vo.OrdersVo;

public interface CafeDAO {
	public List getAllMenu();
	public int deleteMenu(MenuVo menu);
	public int insertMenu(MenuVo menu);
	public List getAllOrder();
	public int insertOrder(OrdersVo order);
	public int insertOrderMember(OrdersVo order);
	public int deleteOrder(OrdersVo order);
	public int getTotalPrice(OrdersVo order);
//	public ArrayList<HashMap<String,Object>> getAllOrder();
	
}
