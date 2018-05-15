package system.DAO;

import java.util.List;

import vo.MemberVo;
import vo.MenuVo;
import vo.OrdersVo;

public interface CafeDAO {
	public List getAllMenu();
	public int deleteMenu(MenuVo menu);
	public int insertMenu(MenuVo menu);
//	public List getAllOrder();
	public int insertOrder(OrdersVo order);
	public int insertOrderMember(OrdersVo order);
	public int deleteOrder(OrdersVo order);
	public int getTotalPrice(OrdersVo order);
	public List<String> getAllOrderByString();
	public List<OrdersVo> getAllOrderByOrdersVo();
	public int getMenuPrice(int i);
	public MemberVo getMember(int i);
	public void addBonus(MemberVo member);
	public void minusBonus(MemberVo member);
	public int getBouns(MemberVo member);
}
