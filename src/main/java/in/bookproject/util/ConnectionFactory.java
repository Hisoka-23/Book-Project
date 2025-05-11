package in.bookproject.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
	private static DataSource ds = null;

	public static Connection getConnection() throws Exception {
		
		if(ds == null) {
			
			FileInputStream fis = new FileInputStream(new File("D:\\Work space\\Development\\23-JFSD-Workspace\\01-ADV-JAVA\\BookProject\\dbconfig.properties"));
			
			Properties p = new Properties();
			p.load(fis);
			
			String url = p.getProperty("db.url");
			String uname = p.getProperty("db.uname");
			String pwd = p.getProperty("db.pwd");
			String driver = p.getProperty("db.driver");
			
			HikariConfig config = new HikariConfig();
			config.setUsername(uname);
			config.setPassword(pwd);
			config.setJdbcUrl(url);
			config.setDriverClassName(driver);
			
			ds = new HikariDataSource(config);
			
		}
		
		return ds.getConnection();
		
	}
	
}
