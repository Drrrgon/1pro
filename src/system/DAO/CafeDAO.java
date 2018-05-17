package system.DAO;

import java.util.HashMap;
import java.util.List;

import vo.DailyVo;
import vo.MemberVo;
import vo.MenuVo;
import vo.OrdersVo;
import vo.SaleVo;

public interface CafeDAO {
	public List getAllMenu();
	public List<HashMap<Integer, String>> getAllMenuByHashMap();
	public int deleteMenu(MenuVo menu);
	public int insertMenu(MenuVo menu);
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
	public List<DailyVo> getDailyOrder(String string);
	public HashMap<String, Object>getOrderByString(OrdersVo order);
	public int dailyClosing(String string);
	public SaleVo getDailyByDate(String string);
	public int insertDailyClosed(SaleVo sale);
	public int insertMember(MemberVo member);
	public String getMemberByString(String string);
	public int deleteMemberByTelNo(String string);
	
}
