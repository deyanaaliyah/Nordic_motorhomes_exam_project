package motorhome.demo.models;
//Made by HM

public class Customer {

    private int customerId; //customer id
    private String firstName; //first name
    private String lastName; //last name
    private String address; //address
    private String driverLicenseNo; //driverlicensNo.
    private String cprNo; //civil registration number

    //Constructor
    public Customer(int customerId, String firstName, String lastName, String address, String driverLicenseNo, String cprNo)
    {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.driverLicenseNo = driverLicenseNo;
        this.cprNo = cprNo;
    }

    //Constructor
    public Customer() {
    }

    //Getter
    public int getCustomerId()
    {
        return customerId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public String getDriverLicenseNo()
    {
        return driverLicenseNo;
    }

    public String getCprNo()
    {
        return cprNo;
    }

    //setter
    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setDriverLicenseNo(String driverLicenseNo)
    {
        this.driverLicenseNo = driverLicenseNo;
    }

    public void setCprNo(String cprNo)
    {
        this.cprNo = cprNo;
    }

    //toString
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", driverLicenseNo='" + driverLicenseNo + '\'' +
                ", cprNo='" + cprNo + '\'' +
                '}';
    }
}

