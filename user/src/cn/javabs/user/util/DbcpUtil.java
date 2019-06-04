package cn.javabs.user.util;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbcpUtil {
    public static DataSource dataSource;
    static{
        try{
            InputStream inputStream = DbcpUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            throw  new  RuntimeException(e);
        }


    }
    public static DataSource getDataSource(){
        return dataSource;

    }
    public static Connection getConnection() throws SQLException{

        return dataSource.getConnection();
    }
}

