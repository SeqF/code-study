package config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
* spring的配置类，相当于bean.xml
* */
@Configuration
@ComponentScan("com.study")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("jdbcconfig.properties")
@EnableTransactionManagement
public class SpringConfiguratioin {
}
