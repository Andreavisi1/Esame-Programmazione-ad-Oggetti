package it.univpm.traianubertinivisi.meteoapi;

import java.util.concurrent.Executor;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@ComponentScan({"it.univpm.traianubertinivisi"})
@EntityScan("it.univpm.traianubertinivisi")
@EnableJpaRepositories("it.univpm.traianubertinivisi")
@EnableAsync
public class MeteoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeteoapiApplication.class, args);
	}
	
	
	  @Bean
	  public Executor taskExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(2);
	    executor.setMaxPoolSize(2);
	    executor.setQueueCapacity(500);
	    executor.setThreadNamePrefix("OpenWeatherLookup-");
	    executor.initialize();
	    return executor;
	  }

	  @Bean
	  public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) {
	      ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
	      resourceDatabasePopulator.addScript(new ClassPathResource("/static/meteoapi/schema.sql"));
	      DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
	      dataSourceInitializer.setDataSource(dataSource);
	      dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
	      return dataSourceInitializer;
	  }
}
