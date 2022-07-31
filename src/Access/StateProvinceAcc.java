package Access;

import SQLDatabase.SQLDBConn;
import javafx.collections.ObservableList;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import model.StateProvince;

import java.sql.*;

public class StateProvinceAcc {
    public static ObservableList<StateProvince> getAllFirstLevelDiv(){
        ObservableList<StateProvince> FirstLevelDivlist = FXCollections.observableArrayList();
        try {        String sql  = "SELECT * from first_level_divisions";
            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int divisionID = rs.getInt("Division_ID");
                String divisionName = rs.getString("Division");
                int countryId = rs.getInt("Country_ID");
                StateProvince firstleveldiv = new StateProvince(divisionID, divisionName, countryId);
                FirstLevelDivlist.add(firstleveldiv);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }    return FirstLevelDivlist;}

}
