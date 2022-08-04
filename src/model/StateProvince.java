package model;

public class StateProvince {
    private int divisionID;
    private String divisionName;
    public int country_ID;
    public StateProvince(int divisionID, String divisionName, int country_ID){    this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.country_ID = country_ID;}

    public int getDivisionID() {
        int divisionID = this.divisionID;
        return divisionID;
    }

    public String getDivisionName(){
        return divisionName;
    }

    public int getCountry_ID() {
        return country_ID;
    }


}
