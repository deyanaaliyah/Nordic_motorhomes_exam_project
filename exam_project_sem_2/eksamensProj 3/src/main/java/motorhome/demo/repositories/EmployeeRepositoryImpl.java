package motorhome.demo.repositories;

import motorhome.demo.repositories.interfaces.IEmployee;
import motorhome.demo.util.DatabaseConnectionManager;
import motorhome.demo.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployee {

    private Connection conn;
    public EmployeeRepositoryImpl(){
        conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Employee employee) throws SQLException {
        PreparedStatement newEmployee = conn.prepareStatement("INSERT INTO nordic_motorhome_rental.employee VALUES (?,?,?,?,?,?,?)");

        try{
            newEmployee.setInt(1,employee.getEmployeeId());
            newEmployee.setString(2,employee.getDepartment());
            newEmployee.setString(3,employee.getFirstName());
            newEmployee.setString(4,employee.getLastName());
            newEmployee.setString(5,employee.getAdress());
            newEmployee.setString(6,employee.getCprNr());
            newEmployee.setString(7,employee.getPassword());

            newEmployee.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Employee read(int employee_id){
        Employee employeeId= new Employee();
        try{
            PreparedStatement readEmployee = conn.prepareStatement("SELECT * FROM employee WHERE employee_id = " + employee_id);
            ResultSet rs = readEmployee.executeQuery();
            while (rs.next()){
                employeeId = new Employee();
                employeeId.setEmployeeId(rs.getInt(1));
                employeeId.setDepartment(rs.getString(2));
                employeeId.setFirstName(rs.getString(3));
                employeeId.setLastName(rs.getString(4));
                employeeId.setAdress(rs.getString(5));
                employeeId.setCprNr(rs.getString(6));
                employeeId.setPassword(rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeId;
    }

    @Override
    public List<Employee> readall() {

        List<Employee> allEmployee = new ArrayList<>();

        try {
            PreparedStatement getAllEmployee = conn.prepareStatement("SELECT * FROM Employee ");
            ResultSet rs = getAllEmployee.executeQuery();

            while (rs.next()) {
                Employee readAllEmployee = new Employee();
                readAllEmployee.setEmployeeId(rs.getInt(1));
                readAllEmployee.setDepartment(rs.getString(2));
                readAllEmployee.setFirstName(rs.getString(3));
                readAllEmployee.setLastName(rs.getString(4));
                readAllEmployee.setAdress(rs.getString(5));
                readAllEmployee.setCprNr(rs.getString(6));
                readAllEmployee.setPassword(rs.getString(7));
                allEmployee.add(readAllEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployee;
    }

    @Override
    public boolean update(Employee Employee) throws SQLException {
        try{
            PreparedStatement updateEmployee = conn.prepareStatement("" +
                    "UPDATE nordic_motorhome_rental.employee " +
                    "SET employee_dept = ?,  employee_first_name = ?, employee_last_name = ?, employee_address = ?, employee_cpr = ?, employee_password = ? " +
                    "WHERE employee_id = ?");

            updateEmployee.setString(1, Employee.getDepartment());
            updateEmployee.setString(2, Employee.getFirstName());
            updateEmployee.setString(3, Employee.getLastName());
            updateEmployee.setString(4, Employee.getAdress());
            updateEmployee.setString(5, Employee.getCprNr());
            updateEmployee.setString(6, Employee.getPassword());
            updateEmployee.setInt(7, Employee.getEmployeeId());

            updateEmployee.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            //Prepare et statemet som sendes til MySQL workbench
            PreparedStatement employeeToDelete = conn.prepareStatement("DELETE FROM nordic_motorhome_rental.employee WHERE employee_id = ?");

            //"?" er lig med den udlejning der skal slettes
            employeeToDelete.setInt(1, id);

            //Execute statementet
            employeeToDelete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
