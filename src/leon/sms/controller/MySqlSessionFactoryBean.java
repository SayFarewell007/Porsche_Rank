package leon.sms.controller;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.NestedIOException;

public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{
	
	@Override
	protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
	
		try {
			return super.buildSqlSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NestedIOException("cuo le !!! " + e);
			
		}
	}

}
