package c.herokuprofiles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@Profile("prod")
@Slf4j
public class DB2Config implements BaseConfig {

    private String message = "prod profile";

    @Value("${prod.spring.datasource.url}")
    private String url;
    @Value("${prod.spring.datasource.username}")
    private String username;
    @Value("${prod.spring.datasource.password}")
    private String password;


    @Override
    public String getConfiguration() {
        return message;
    }

    @Override
    public DataSource getDataSource() throws URISyntaxException {

        log.info(" url : {}", url);
        log.info(" username : {}", username);
        log.info(" password : {}", password);
        return DataSourceBuilder.create()
                .username(username)
                .password(password)
                .url(url)
                .build();
    }
}
