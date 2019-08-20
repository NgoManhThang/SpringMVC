package thangnm.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import thangnm.interceptor.DataSourceIntercetor;
import thangnm.routing.MyRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan({"thangnm"})
@PropertySources({
        @PropertySource("/resources/jdbc.properties"),
        @PropertySource("/i18n/messages_en.properties"),
        @PropertySource("/i18n/messages_vi.properties")
})
public class SpringWebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private Environment environment;

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "messageSource")
    public MessageSource reloadableResourceBundleMessageSource(){
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("/i18n/messages");
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return reloadableResourceBundleMessageSource;
    }

    @Bean(name = "localeResolver")
    public LocaleResolver cookieLocaleResolver(){
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
//        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        cookieLocaleResolver.setCookieName("myAppLocaleCookie");
        cookieLocaleResolver.setCookieMaxAge(30000);
        return cookieLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        registry.addInterceptor(new DataSourceIntercetor()).addPathPatterns("/student/*", "/teacher/*");
        registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/*");
    }

//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//        driverManagerDataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//        driverManagerDataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
//        driverManagerDataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
//        return driverManagerDataSource;
//    }

    @Bean(name = "dataSource")
    public DataSource getDataSource( DataSource dataSourceStudent, DataSource dataSourceTeacher ){
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("STUDENT_DS", dataSourceStudent);
        dsMap.put("TEACHER_DS", dataSourceTeacher);
        myRoutingDataSource.setDefaultTargetDataSource(dsMap);
        return myRoutingDataSource;
    }

    @Bean(name = "dataSourceStudent")
    public DataSource getDataSourceStudent(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("student.driverClassName"));
        driverManagerDataSource.setUrl(environment.getRequiredProperty("student.url"));
        driverManagerDataSource.setUsername(environment.getRequiredProperty("student.username"));
        driverManagerDataSource.setPassword(environment.getRequiredProperty("student.password"));
        return driverManagerDataSource;
    }

    @Bean(name = "dataSourceTeacher")
    public DataSource getDataSourceTeacher(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("teacher.driverClassName"));
        driverManagerDataSource.setUrl(environment.getRequiredProperty("teacher.url"));
        driverManagerDataSource.setUsername(environment.getRequiredProperty("teacher.username"));
        driverManagerDataSource.setPassword(environment.getRequiredProperty("teacher.password"));
        return driverManagerDataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        return namedParameterJdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }

    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
