package fr.p12.betonline.configuration;



import java.util.Arrays;

/**
 * Created by zaraki on 05/05/17.
 */
/*import org.springframework.boot.context.embedded.FilterRegistrationBean;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.core.annotation.Order;
        import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
        import org.springframework.session.MapSessionRepository;
        import org.springframework.session.SessionRepository;
        import org.springframework.session.data.redis.config.ConfigureRedisAction;
        import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
        import org.springframework.session.web.http.SessionRepositoryFilter;
        import org.springframework.web.filter.DelegatingFilterProxy;

        import java.util.Arrays;


@Configuration
@EnableRedisHttpSession
public class SessionRepositoryConfig {

    @Bean
    @Order(value = 0)
    public org.springframework.boot.web.servlet.FilterRegistrationBean sessionRepositoryFilterRegistration(SessionRepositoryFilter springSessionRepositoryFilter) {
        org.springframework.boot.web.servlet.FilterRegistrationBean filterRegistrationBean = new org.springframework.boot.web.servlet.FilterRegistrationBean();
        filterRegistrationBean.setFilter(new DelegatingFilterProxy(springSessionRepositoryFilter));
        filterRegistrationBean.setUrlPatterns(Arrays.asList(""));
        return filterRegistrationBean;
    }

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}
*/