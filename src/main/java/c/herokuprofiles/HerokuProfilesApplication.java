package c.herokuprofiles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.net.URISyntaxException;

@Slf4j
@SpringBootApplication
public class HerokuProfilesApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HerokuProfilesApplication.class, args);
    }

  /*  @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;*/

   @Autowired
   BaseConfig configuration;

    @Override
    public void run(String... args) throws Exception {

        String config = configuration.getConfiguration();
        log.info("Current configuration: {} is enabled", config);
    }

    @Bean
    public DataSource dataSource(){
        try {
            return configuration.getDataSource();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
