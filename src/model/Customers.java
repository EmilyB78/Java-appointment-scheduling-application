 package model;

public class Customers {


    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerPostalCode;
    private String customerPhonenumber;
    private int divisionID;
    private String divisionName;
    private int  countryID;
    private String customerCountry;

    public Customers(int customerID, String customerName, String customerAddress, String customerPostalCode, String customerPhonenumber, int divisionID, String divisionName, int countryID, String customerCountry) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPostalCode = customerPostalCode;
        this.customerPhonenumber = customerPhonenumber;
        this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.countryID = countryID;
        this.customerCountry = customerCountry;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    public String getCustomerPhonenumber() {
        return customerPhonenumber;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public int getCountryID() {
        return countryID;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }
}




