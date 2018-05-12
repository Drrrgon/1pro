package system.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CafeConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resources = "config/CafeConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resources);
			sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {		
			e.printStackTrace();
			System.out.println("Can'tReadSource");
		}
	}	
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
