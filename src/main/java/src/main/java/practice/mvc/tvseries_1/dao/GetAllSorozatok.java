package practice.mvc.tvseries_1.dao;

import practice.mvc.tvseries_1.model.Sorozatok;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetAllSorozatok {

    private static final String SOROZATOK_SQL = "SELECT * FROM Sorozatok;";

    public List<Sorozatok> getSorozatok(){
        List<Sorozatok> sorozatok = new ArrayList<>();

        try {
            Connection con = ConnectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SOROZATOK_SQL);

            while(rs.next()){
                int id = rs.getInt("id");
                String nev = rs.getString("nev");
                int hossz = rs.getInt("hossz");

                sorozatok.add(new Sorozatok(id,nev,hossz));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sorozatok;
    }
}
