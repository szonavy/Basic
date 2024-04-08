package practice.mvc.tvseries_1.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPoolNoC3PO {
    public static Connection con = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/viki_schema?enabledTLSProtocols=TLSv1.2&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=EST";

            con = DriverManager.getConnection(url, "root", "szotakzoltan15");

            System.out.println("connection Established");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return con;
    }
}

