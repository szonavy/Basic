package practice.mvc.tvseries_1.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    static {
        try {
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/viki_schema?enabledTLSProtocols=TLSv1.2&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=EST");
            cpds.setUser("root");
            cpds.setPassword("szotakzoltan15");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

}
