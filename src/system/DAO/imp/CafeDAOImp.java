package system.DAO.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import system.DAO.CafeDAO;
import system.config.CafeConfig;
import vo.MemberVo;
import vo.MenuVo;

public class CafeDAOImp implements CafeDAO {
	private SqlSession sqlSession;
	private SqlSessionFactory sqlSessionFactory;
	
	public CafeDAOImp() {
		sqlSessionFactory = CafeConfig.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
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
