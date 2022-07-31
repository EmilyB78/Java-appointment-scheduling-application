package Access;

import SQLDatabase.SQLDBConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Countries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryAcc {

    /**
     * ObservableList that queries Country_ID and Country from the countries database table.
     * @throws SQLException
     * @return countriesObservableList
     */
    public static ObservableList<Countries> getCountries() throws SQLException {
        ObservableList<Countries> countriesObservableList = FXCollections.observableArrayList();
        String sql = "SELECT Country_ID, Country from countries";
        PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int countryID = rs.getInt("Country_ID");
            String countryName = rs.getString("Country");
            Countries country = new Countries(countryID, countryName);
            countriesObservableList.add(country);
        }
        return countriesObservableList;
    }
}
