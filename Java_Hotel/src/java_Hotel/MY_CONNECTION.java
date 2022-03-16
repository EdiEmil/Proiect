package java_Hotel;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MY_CONNECTION {
     public Connection createConnection() {
         Connection connection = null;

        MysqlDataSource mds = new MysqlDataSource();
        mds.setServerName("localhost");
        mds.setPortNumber(3306);
        mds.setUser("root");
        mds.setPassword("");
        mds.setDatabaseName("java_hotel_database");

        try {
            connection= mds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
