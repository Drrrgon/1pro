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

	@Override
	public List getAllOrder() {		
		return sqlSession.selectList("Orders.getAllOrder");
	}

	@Override
	public int insertOrder(OrdersVo order) {
		int result = sqlSession.insert("Orders.insertOrder", order);
		sqlSession.commit();
		return result;
	}

	@Override
	public int insertOrderMember(OrdersVo order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(OrdersVo order) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * @return int 
	 * 오더의 총 가격을 반환합니다.
	 */
	@Override
	public int getTotalPrice(OrdersVo order) {
		return sqlSession.selectOne("getTotalPrice", order);		
	}

}
