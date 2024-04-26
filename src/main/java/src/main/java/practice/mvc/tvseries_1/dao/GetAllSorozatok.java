package practice.mvc.tvseries_1.dao;

import practice.mvc.tvseries_1.model.Sorozatok;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllSorozatok {

    private static final String SOROZATOK_SQL = "SELECT * FROM Sorozatok;";

    public Map<Integer,Sorozatok> getSorozatok(){
        Map<Integer,Sorozatok> sorozatok = new HashMap<>();

        try {
            Connection con = ConnectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SOROZATOK_SQL);

            while(rs.next()){
                int id = rs.getInt("id");
                String nev = rs.getString("nev");
                int hossz = rs.getInt("hossz");

                sorozatok.put(id,new Sorozatok(id,nev,hossz));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sorozatok;
    }
}
