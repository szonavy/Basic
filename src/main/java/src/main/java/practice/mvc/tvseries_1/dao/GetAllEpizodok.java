package practice.mvc.tvseries_1.dao;

import practice.mvc.tvseries_1.model.Epizod;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetAllEpizodok {
    private static final String EPIZODOK_SQL = "SELECT * FROM Epizodok;";

    public List<Epizod> getEpizodok() {
        List<Epizod> epizodok = new ArrayList<>();
        Connection con = null;

        try {
            con = ConnectionPool.getConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(EPIZODOK_SQL);


            while(rs.next()) {

                int id = rs.getInt("id");
                int sorozatId = rs.getInt("sorozat_id");

                LocalDate datum;
                if(rs.getTimestamp("megjelenes") == null) {
                    datum = null;
                } else {
                    datum = rs.getTimestamp("megjelenes").toLocalDateTime().toLocalDate();
                }

                String epizod = rs.getString("epizodszam");
                boolean megnezett = rs.getBoolean("megnezett");

                Epizod ep = new Epizod(id, sorozatId, datum, epizod, megnezett);
                epizodok.add(ep);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return epizodok;
    }
}
