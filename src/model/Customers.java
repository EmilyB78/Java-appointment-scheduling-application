 package model;

public class Customers {

    public String divisionName;
    private int divisionID;
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerPostalCode;
    private String customerPhonenumber;
    private String customerState;
    private String customerCountry;

    public Customers(String divisionName, int divisionID, int customerID, String customerName, String customerAddress, String customerState, String customerCountry, String customerPostalCode, String customerPhonenumber){
        this.divisionName = divisionName;
        this.divisionID = divisionID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPostalCode = customerPostalCode;
        this.customerPhonenumber = customerPhonenumber;
        this.customerState = customerState;
        this.customerCountry = customerCountry;
    }
    public String getDivisionName(){
        return divisionName;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getCustomerAddress(){
        return customerAddress;
    }

    public String getCustomerPostalCode(){
        return customerPostalCode;
    }

    public String getCustomerPhonenumber(){
        return customerPhonenumber;
    }

    public String getCustomerState( ){return customerState;}

    public String getCustomerCountry() {
        return customerCountry;
    }
}



