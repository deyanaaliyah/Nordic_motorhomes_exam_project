package motorhome.demo.models;

//OB

public class Employee {

    private int employeeId;
    private String department;
    private String firstName;
    private String lastName;
    private String adress;
    private String cprNr;
    private String password;

    public Employee(int employeeId, String department, String firstName, String lastName, String adress, String cprNr, String password) {
        this.employeeId = employeeId;
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.cprNr = cprNr;
        this.password = password;
    }

    public Employee() { }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAdress() { return adress; }
    public void setAdress(String adress) { this.adress = adress; }

    public String getCprNr() { return cprNr; }
    public void setCprNr(String cprNr) { this.cprNr = cprNr; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress='" + adress + '\'' +
                ", cprNr='" + cprNr + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}



