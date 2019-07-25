package c.herokuprofiles;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class DevDBConfig implements BaseConfig{

 /* @Value("${my.local.user}")
   private String message ;*/

    @Value("${dev.spring.datasource.url}")
    private String message = "dev profile";

    @Value("${dev.spring.datasource.username}")
    private String username;

    @Value("${dev.spring.datasource.password}")
    private String password;

    @Value("${dev.spring.datasource.url}")
    private String url;

   // private String message = System.getenv("POSTGRESQL_USER");
   // private String message = System.getenv("JAVA_HOME");




    public DataSource getDataSource(){
        return DataSourceBuilder.create()
                .username("p2user") // your postgres login
                .password("p2password")// your postgres pass
                .url("jdbc:postgresql://localhost:5432/postgres")
                .build();
    }

    @Override
    public String getConfiguration() {
        return this.message;
    }
}
