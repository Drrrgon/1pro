package system.DAO.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import system.DAO.CafeDAO;
import system.config.CafeConfig;
import vo.MemberVo;
import vo.MenuVo;

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
	
	@Override
	public List<MenuVo> getAllMenu() {
		return sqlSession.selectList("Menu.getAllMenu");
	}

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

}
