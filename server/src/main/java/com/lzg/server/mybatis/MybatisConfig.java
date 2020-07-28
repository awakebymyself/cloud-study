package com.lzg.server.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.lzg.server.dao")
public class MybatisConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource() {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/study");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    @Bean(name = "mySqlSessionFactory")
    public SqlSessionFactory mySqlSessionFactory() throws Exception {

        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();

        // 获取properties中的对应配置信息
        String mapperLocation = "classpath*:sqlmap/*.xml";
//        String configLocation = "classpath:mybatis-settings.xml";
//
//        Properties properties = new Properties();
//
        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setConfigurationProperties(properties);
//
//        // 设置MapperLocations configLocation路径
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resourcePatternResolver.getResources(mapperLocation));
//        sessionFactory.setConfigLocation(resourcePatternResolver.getResource(configLocation));

        Interceptor[] plugins = {paginationInterceptor()};
        sessionFactory.setPlugins(plugins);

        return sessionFactory.getObject();
    }

    @Bean(name = "mySqlSessionTemplate")
    public SqlSessionTemplate mySqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(mySqlSessionFactory());
    }

    @Bean(name = "mySqlTransactionManager")
    public PlatformTransactionManager mySqlTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "mySqlTransactionTemplate")
    public TransactionTemplate mySqlTransactionTemplate() {
        return new TransactionTemplate(mySqlTransactionManager());
    }

}
