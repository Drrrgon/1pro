package system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import system.config.CafeConfig;
import vo.MemberVo;
import vo.MenuVo;
import vo.OrdersVo;

public class QuryTest {
	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		SqlSessionFactory sqlSessionFactory = CafeConfig.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
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
		OrdersVo order = new OrdersVo();
		order.setMenuNo(11);
		int r =sqlSession.selectOne("Orders.getMenuPrice",order);
		System.out.println(r);
	}

}

