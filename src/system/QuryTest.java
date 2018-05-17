package system;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import system.DAO.imp.CafeDAOImp;
import vo.OrdersVo;
import vo.SaleVo;

public class QuryTest {
	private static CafeDAOImp cafeDAOImp;
	public static void main(String[] args) {
//		SqlSession sqlSession = null;
//		SqlSessionFactory sqlSessionFactory = CafeConfig.getSqlSessionFactory();
//		sqlSession = sqlSessionFactory.openSession();
		cafeDAOImp = CafeDAOImp.getInstance();
		System.out.println("오픈");
		
//		List<MenuVo> list = sqlSession.selectList("Menu.getAllMenu");
//		for( MenuVo a : list) {
//			System.out.println(a);
//		}
//		
//		MenuVo menu = new MenuVo();
//		menu.setMenuNo(3);
//		int re = sqlSession.delete("Menu.deleteMenu", menu);
//		System.out.println(re + "딜리트 성공");
//		
//		menu.setmName("칭따오"); menu.setmPrice(15000); menu.setmOriginalPrice(10000);
//		re= sqlSession.insert("Menu.insertMenu", menu);
//		sqlSession.commit();
//		System.out.println(re+" 인서트 성공");
//		
//		list = sqlSession.selectList("Menu.getAllMenu");
//		for( MenuVo a : list) {
//			System.out.println(a);
//		}////여기까지 메뉴 쿼리 확인
		
//		MemberVo member =  new MemberVo();
//		member.setmName("신용하");
//		member.setTelNo("01053713757");
//		member.setmBonus(0);	
//		/*sqlSession.insert("Member.insertMember", member);
//		System.out.println(member.getMemberNo());
//		sqlSession.commit();*/
//		
//		int re = sqlSession.delete("Member.deleteMember", member);
//		System.out.println(re + "딜리트 성공");
//		sqlSession.commit();
		
//		int re = sqlSession.delete("Member.deleteMember", member);
//		System.out.println(re + "딜리트 성공");
//		sqlSession.commit();
		
//		OrdersVo order = new OrdersVo();
//		order.setMenuNo(10);
//		order.setCount(2);
//		int re = sqlSession.insert("Orders.insertOrder", order);
//		System.out.println(order.getOrederNo()); sqlSession.commit();
		
//		order.setOrederNo(10);
//		int re = sqlSession.delete("deleteOrder", order);
//		System.out.println(re);
//		order.setTotal(order.getTotal());
//		List<HashMap<String, Object>> list = sqlSession.selectList("Orders.getAllOrder");
//		ArrayList<HashMap<String,Object>> list3=sqlSession.selectList("Orders.getAllOrder");
//		for(HashMap<String, Object> a: list) {
//			System.out.println(a.get("ORDERNO"));
//			System.out.println(a.get("MNAME"));
//			
//		}
//		ArrayList<HashMap<String,Object>> mylist = sqlSession.selectOne("Orders.getAllOrder");
//		
//		for(HashMap<String, Object> a: mylist) {
//			System.out.println(a.get);
////		}
//		int a = sqlSession.selectOne("Orders.getTotalPrice", order);
//		System.out.println(a);
//		OrdersVo order = new OrdersVo();
//		order.setMenuNo(11);
//		int r =sqlSession.selectOne("Orders.getMenuPrice",order);
//		System.out.println(r);
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal.get(Calendar.YEAR));
//		System.out.println(cal.get(Calendar.MONTH)+1);
//		System.out.println(cal.get(Calendar.DATE));
		
//		cal.set(cal.get(Calendar.YEAR, cal.get(Calendar.MONTH)+1, date);
//	    SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
//	    String formatted = format1.format(cal.getTime());
//	    System.out.println(formatted);
//	    String a = "20180516";
//	    List<OrdersVo> temp =  sqlSession.selectList("Sale.getDailyOrder", formatted);
//	    for(OrdersVo v : temp) {
//	    	System.out.println(v);
	    
//	    }
//	    System.out.println(cafeDAOImp.getDailyOrder(formatted));
	    
//	    cafeDAOImp.getAllMenuByHashMap();
	    
//		List<HashMap<String, Object>> orderList = cafeDAOImp.getDailyOrder(formatted); // 포멧에 맞는 날짜의 오더를 모두 검색
//		for(HashMap<String , Object> av : orderList) {
//			System.out.println(av.get("MENUNO"));
//			av.get("MNAME");
//			av.get("COUNT");
//			av.get("TOTAL");
//			av.get("MORGINALPRICE");
//		}
//	    SaleVo sale = new SaleVo();
//	    sale.setMenuList("2");
//	    sale.setOriginalPrice(2);
//	    sale.setTotalSale(3);
//	    System.out.println(1);
//	    System.out.println(cafeDAOImp.insertDailyClosing(sale));
	    
//	    OrdersVo order = new OrdersVo();
//	    order.setOrederNo(1);
//	    HashMap<String, Object> map = cafeDAOImp.getOrderByString(order);
//	    System.out.println(map.get("ORDERNO"));
//	    System.out.println(map.get("MNAME"));
//	    System.out.println(map.get("COUNT")); 
//	    System.out.println(map.get("TOTAL"));
//	    System.out.println(map.get("TIME"));
		
		boolean a = cafeDAOImp.matching("cafemater", "coffee");
//		System.out.println((String)a.get("ID")+a.get("PASSWORD"));
		System.out.println(a);
	}

}

