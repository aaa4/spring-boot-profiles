package c.herokuprofiles;


import javax.sql.DataSource;
import java.net.URISyntaxException;

public interface BaseConfig {

      String getConfiguration();

      DataSource getDataSource() throws URISyntaxException;
}
