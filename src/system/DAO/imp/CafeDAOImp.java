package system.DAO.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import system.DAO.CafeDAO;
import system.config.CafeConfig;
import vo.DailyVo;
import vo.MemberVo;
import vo.MenuVo;
import vo.OrdersVo;
import vo.SaleVo;

public class CafeDAOImp implements CafeDAO {
	private static CafeDAOImp cafeDAOImp = new CafeDAOImp();
	private static SqlSession sqlSession;
	private static SqlSessionFactory sqlSessionFactory;
	
	private CafeDAOImp() {
		sqlSessionFactory = CafeConfig.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
	}
	
	public static CafeDAOImp getInstance() {
		if(cafeDAOImp == null) {
			synchronized(CafeDAOImp.class) {
				if(cafeDAOImp == null) {
					sqlSessionFactory = CafeConfig.getSqlSessionFactory();
					sqlSession = sqlSessionFactory.openSession();
				}
			}
		}
		
		return cafeDAOImp;
	}
	
	/**
	 * @return List<MenuVo>
	 * 모든 메뉴를 리스트로 반환합니다.
	 */
	@Override
	public List<MenuVo> getAllMenu() {
		return sqlSession.selectList("Menu.getAllMenu");
	}
	
	/**
	 * @param MenuVo
	 * @return int
	 * MenuVo의 NO값으로매칭되는 튜플을 DB에서 삭제합니다.
	 */
	@Override
	public int deleteMenu(MenuVo menu) {
		 int temp = sqlSession.delete("Menu.deleteMenu",menu);
		 sqlSession.commit();
		 return temp;		
	}
	
	/**
	 * @return Integer
	 * 메뉴를 삽입하고 인티저 값으로 변환됩니다.
	 */
	@Override
	public int insertMenu(MenuVo menu) {
		int temp =sqlSession.insert("Menu.insertMenu", menu);	
		sqlSession.commit();
		return temp;
	}
	
	/**
	 * @return List<String>
	 * DB의 모든 테이블의 값을 String으로 변환, List로 리턴합니다. 
	 * 메뉴번호는 메뉴 이름으로 매칭되어 출력됩니다.
	 */
	@Override
	public List<String> getAllOrderByString() {	
		List<HashMap<String,Object>> temp = sqlSession.selectList("Orders.getAllOrderByString");
		String str = "";
		List<String> list = new ArrayList<String>();
		for(HashMap<String, Object> a : temp) {
			str = "주문 번호 : " + a.get("ORDERNO")+" 메뉴 : "+a.get("MNAME")+
					" 수량 : " + a.get("COUNT") +" 총 가격 : "+ a.get("TOTAL")+" 주문 시각 : "+ a.get("TIME");
			list.add(str);
		}
		return list;
	}
	
	/**
	 * @return List<HashMap<Integer, String>>
	 */
	@Override
	public List<HashMap<Integer, String>> getAllMenuByHashMap() {
		List<HashMap<String, Object>>  temp = sqlSession.selectList("Menu.getAllMenuByHashMap");
		HashMap<Integer, String> tempHash = new HashMap<>();
		List<HashMap<Integer, String>> list =new ArrayList<>(); 
		for(HashMap<String, Object> a : temp) {
			int s =  ((BigDecimal)a.get("MENUNO")).intValue();			
			tempHash.put(s, (String) a.get("MNAME"));
			list.add(tempHash);			
		}
		return list;
	}
	
	/**
	 * @return List<OrdersVo>
	 * DB의 모든 테이블의 값을 OrdersVo객체에 담아 List로 리턴합니다.
	 */
	public List<OrdersVo> getAllOrderByOrdersVo(){		
		return sqlSession.selectList("Orders.getAllOrderByOrdersVo");
	}

	@Override
	public int insertOrder(OrdersVo order) {
		int result = sqlSession.insert("Orders.insertOrder", order);
		sqlSession.commit();
		return result;
	}

	@Override
	public int insertOrderMember(OrdersVo order) {
		int result = sqlSession.insert("Orders.insertOrderMember", order);
		return result;
	}
	/**
	 * @param OrdersVo
	 * @return Integer
	 * OrdersVo의 orderNo로 DB를 검색, 삭제합니다.
	 * 성공 여부가 Integer 형태로 반환됩니다.(1성공,0실패)
	 */
	@Override
	public int deleteOrder(OrdersVo order) {
		int result = sqlSession.delete("Orders.deleteOrder", order);
		sqlSession.commit();
		return result;
	}
	/**
	 * @return Integer 
	 * 오더의 총 가격을 반환합니다.
	 */
	@Override
	public int getTotalPrice(OrdersVo order) {
		return sqlSession.selectOne("getTotalPrice", order);		
	}
	
	
	@Override
	public int getMenuPrice(int i) {
		return sqlSession.selectOne("Orders.getMenuPrice", i);
	}
	/**
	 * @param Integer
	 * @return MemberVo
	 * 전화번호로 검색을 한 다음 검색 결과를 MemberVo로 반환합니다.
	 */
	@Override
	public MemberVo getMember(int i) {		
		return sqlSession.selectOne("Member.getMember", i);
	}

	@Override
	public void addBonus(MemberVo member) {
		sqlSession.update("Member.addBonus", member);
		sqlSession.commit();
	}

	@Override
	public void minusBonus(MemberVo member) {
		sqlSession.update("Member.minusBonus", member);
		sqlSession.commit();
	}

	@Override
	public int getBouns(MemberVo member) {
		return sqlSession.selectOne("Member.getBouns",member);		 
	}

	@Override
	public List<DailyVo> getDailyOrder(String string) {
		List<DailyVo> list = new ArrayList<DailyVo>();
		List<HashMap<String , Object>> temp = sqlSession.selectList("Sale.getDailyOrder", string);
		
		for(HashMap<String , Object> av : temp) {
			DailyVo day = new DailyVo(((BigDecimal) av.get("MENUNO")).intValue(), (String) av.get("MNAME"),
					((BigDecimal) av.get("COUNT")).intValue(),((BigDecimal) av.get("TOTAL")).intValue(),
					((BigDecimal) av.get("MORIGINALPRICE")).intValue());
			list.add(day);		
		}		
//		sqlSession.close();
		return list;
	}

	/*@Override
	public int insertDailyClosing(SaleVo sale) {
		int result = sqlSession.insert("Sale.insertDailyClosing",sale);
		sqlSession.commit();
		return result;
	}*/
	
	/**
	 * 오늘 날짜 이전의 오더를 모두 지우고 시퀀스를 초기화 합니다.
	 */
	@Override
	public int dailyClosing(String date) {
		int del = sqlSession.delete("Sale.dailyClosing", date);
		if(del > 0 ) {
			sqlSession.update("Sale.dropSequence");
			sqlSession.update("Sale.createSequence");
		}
		sqlSession.commit();
		return del;
	}

	@Override
	public SaleVo getDailyByDate(String string) {
		SaleVo sale = sqlSession.selectOne("Sale.getDailyByDate",string);
		return sale;
	}

	@Override
	public int insertDailyClosed(SaleVo sale) {
		int vs = sqlSession.insert("Sale.insertDailyClosed", sale);
		sqlSession.commit();
		return vs;
	}

	@Override
	public int insertMember(MemberVo member) {
		int result = sqlSession.insert("Member.insertMember", member);
		sqlSession.commit();
		return result;
	}

	@Override
	public String getMemberByString(String string) {
		String result = sqlSession.selectOne("Member.getMemberByString", string);
		return result;
	}

	@Override
	public int deleteMemberByTelNo(String string) {
		int result = sqlSession.delete("Member.deleteMemberByTelNo", string);
		sqlSession.commit();
		return result;
	}

	@Override
	public HashMap<String, Object> getOrderByString(OrdersVo order) {
		HashMap<String, Object> map = sqlSession.selectOne("Orders.getOrderByString", order);
		return map;
	}

	@Override
	public boolean matching(String id, String password) {
		boolean result = false;
		HashMap<String, Object> map = new HashMap<String, Object>();		
		map.put("id", id);
		map.put("password", password);
		map = sqlSession.selectOne("Login.matching", map);
		if(map !=null) {
			result = true;
		}
		return result;
	}

	@Override
	public List<MemberVo> getAllMember() {
		List<MemberVo> list = sqlSession.selectList("Member.getAllMember");
		return list;
	}
	
	

	
}
