package system;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import system.config.CafeConfig;
import vo.MenuVo;

public class QuryTest {
	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		SqlSessionFactory sqlSessionFactory = CafeConfig.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		System.out.println("오픈");
		
		List<MenuVo> list = sqlSession.selectList("Menu.getAllMenu");
		for( MenuVo a : list) {
			System.out.println(a);
		}
		
		MenuVo menu = new MenuVo();
		menu.setMenuNo(3);
		int re = sqlSession.delete("Menu.deleteMenu", menu);
		System.out.println(re + "딜리트 성공");
		
		menu.setmName("칭따오"); menu.setmPrice(15000); menu.setmOriginalPrice(10000);
		re= sqlSession.insert("Menu.insertMenu", menu);
		sqlSession.commit();
		System.out.println(re+" 인서트 성공");
		
		list = sqlSession.selectList("Menu.getAllMenu");
		for( MenuVo a : list) {
			System.out.println(a);
		}
		
	}

}

