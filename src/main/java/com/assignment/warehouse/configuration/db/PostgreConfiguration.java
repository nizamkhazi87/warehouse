/*
 * package com.assignment.warehouse.configuration.db;
 * 
 * import java.io.IOException; import java.util.HashMap; import java.util.Map;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.env.Environment; import
 * org.springframework.core.env.MapPropertySource; import
 * org.springframework.core.io.support.EncodedResource; import
 * org.springframework.core.io.support.PropertySourceFactory; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.jdbc.datasource.DriverManagerDataSource; import
 * org.springframework.orm.jpa.JpaTransactionManager; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; import
 * org.springframework.transaction.PlatformTransactionManager;
 * 
 * import com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * @Configuration
 * 
 * @EnableJpaRepositories(basePackages = "com.assignment.warehouse.repository",
 * entityManagerFactoryRef = "warehouseEntityManager", transactionManagerRef =
 * "warehouseTransactionManager") public class PostgreConfiguration {
 * 
 * @Value("${url}") private String url;
 * 
 * @Value("${username}") private String username;
 * 
 * @Value("${driverclass}") private String driverClass;
 * 
 * @Value("${dialect}") private String hibernateDialect;
 * 
 * @Autowired private Environment env;
 * 
 * @Bean public LocalContainerEntityManagerFactoryBean warehouseEntityManager()
 * { LocalContainerEntityManagerFactoryBean em = new
 * LocalContainerEntityManagerFactoryBean();
 * em.setDataSource(warehouseDataSource()); em.setPackagesToScan( new String[] {
 * "com.assignment.warehouse.entity" }); HibernateJpaVendorAdapter vendorAdapter
 * = new HibernateJpaVendorAdapter(); em.setJpaVendorAdapter(vendorAdapter);
 * HashMap<String, Object> properties = new HashMap<>();
 * properties.put("hibernate.dialect", hibernateDialect);
 * properties.put("hibernate.show_sql", true);
 * properties.put("hibernate.format_sql", true);
 * properties.put("spring.jpa.generate-ddl", true);
 * em.setJpaPropertyMap(properties);
 * 
 * 
 * return em; }
 * 
 * @Bean public DataSource warehouseDataSource() {
 * 
 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
 * dataSource.setDriverClassName(driverClass); dataSource.setUrl(url);
 * dataSource.setUsername(username);
 * dataSource.setPassword(env.getProperty("password")); return dataSource; }
 * 
 * @Bean public PlatformTransactionManager warehouseTransactionManager() {
 * JpaTransactionManager transactionManager = new JpaTransactionManager();
 * transactionManager.setEntityManagerFactory(
 * warehouseEntityManager().getObject()); return transactionManager; }
 * 
 * 
 * }
 */