package system;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import system.config.CafeConfig;
public class QuryTest {
	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		SqlSessionFactory sqlSessionFactory = CafeConfig.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		System.out.println("오픈");

	}

}
