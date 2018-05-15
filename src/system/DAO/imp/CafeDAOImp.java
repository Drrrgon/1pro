package system.DAO.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import system.DAO.CafeDAO;
import system.config.CafeConfig;
import vo.MemberVo;
import vo.MenuVo;
import vo.OrdersVo;

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
	 * @return int
	 * OrdersVo의 orderNo로 DB를 검색, 삭제합니다.
	 * 성공 여부가 int 형태로 반환됩니다.(1성공,0실패)
	 */
	@Override
	public int deleteOrder(OrdersVo order) {
		int result = sqlSession.delete("Orders.deleteOrder", order);
		sqlSession.commit();
		return result;
	}
	/**
	 * @return int 
	 * 오더의 총 가격을 반환합니다.
	 */
	@Override
	public int getTotalPrice(OrdersVo order) {
//		int r =sqlSession.selectOne("Orders.getMenuPrice",order);
		return sqlSession.selectOne("getTotalPrice", order);		
	}
	@Override
	public int getMenuPrice(int i) {
		int r = sqlSession.selectOne("Orders.getMenuPrice", i);
		return r;		
	}
	/**
	 * @param int
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

	
}
