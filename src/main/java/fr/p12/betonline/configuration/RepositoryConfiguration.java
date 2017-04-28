package fr.p12.betonline.configuration;

/**
 * Created by audre on 27/04/2017.
 */

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"fr.p12.betonline.Model"})
@EnableJpaRepositories(basePackages = {"fr.p12.betonline.Repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
