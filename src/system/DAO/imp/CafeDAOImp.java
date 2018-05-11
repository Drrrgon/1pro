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
	public void deleteMenu(MenuVo menu) {
		sqlSession.delete("Menu.deleteMenu",menu);		
	}

	@Override
	public void insertMenu(MenuVo menu) {
		sqlSession.insert("Menu.insertMenu", menu);		
	}

}
