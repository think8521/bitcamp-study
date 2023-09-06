package bitcamp.myapp.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

// Application을 실행하는데 필요한 객체를 설정하는 일을 한다.

@MapperScan("bitcamp.myapp.dao") // Mybatis가 자동으로 생성할 DAO 객체의 인터페이스 패키지 지정
public class MybatisConfig {

  {
    System.out.println("MybatisConfig() 호출됨!");
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext appCtx) throws Exception {
    System.out.println("MybatisConfig.sqlSessionFactory() 호출됨!");

    // Mybatis에서 Log4j 2.x 버전을 사용하도록 활성화시킨다.
    org.apache.ibatis.logging.LogFactory.useLog4J2Logging();

    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setTypeAliasesPackage("bitcamp.myapp.vo");

//    Resource r1 = appCtx.getResource("classpath:bitcamp/myapp/dao/mysql/BoardDao.xml");
//    Resource r2 = appCtx.getResource("classpath:bitcamp/myapp/dao/mysql/MemberDao.xml");
    factoryBean.setMapperLocations(appCtx.getResources("classpath:bitcamp/myapp/dao/mysql/*Dao.xml"));

    return factoryBean.getObject();
  }
}

//

