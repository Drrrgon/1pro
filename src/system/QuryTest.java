package system;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import system.config.CafeConfig;
import vo.MemberVo;

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
		
		MemberVo member =  new MemberVo();
		member.setmName("신용하");
		member.setTelNo("01053713757");
		member.setmBonus(0);
		/*sqlSession.insert("Member.insertMember", member);
		System.out.println(member.getMemberNo());
		sqlSession.commit();*/
		
		int re = sqlSession.delete("Member.deleteMember", member);
		System.out.println(re + "딜리트 성공");
		sqlSession.commit();
	}

}

