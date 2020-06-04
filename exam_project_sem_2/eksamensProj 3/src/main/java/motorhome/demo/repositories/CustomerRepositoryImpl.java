package motorhome.demo.repositories;

import motorhome.demo.models.Customer;
import motorhome.demo.repositories.interfaces.ICustomer;
import motorhome.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomer
{
    private Connection connectionToMySql;

    public CustomerRepositoryImpl()
    {
        connectionToMySql = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Customer customer)
    {
        //Create customer via parameter
            try
            {
                //Prepare a statement to execute to mySQL
                PreparedStatement customerToInsert = connectionToMySql.prepareStatement("INSERT INTO nordic_motorhome_rental.customer VALUES(?,?,?,?,?,?)");
                //Data placement in rows and columns
                customerToInsert.setInt(1,customer.getCustomerId());
                customerToInsert.setString(2,customer.getFirstName());
                customerToInsert.setString(3,customer.getLastName());
                customerToInsert.setString(4,customer.getAddress());
                customerToInsert.setString(5,customer.getDriverLicenseNo());
                customerToInsert.setString(6,customer.getCprNo());
                //Execute customerToInsert + update
                customerToInsert.executeUpdate();
            }
                catch (SQLException e)
                {
                    //Catch SQL exception
                    System.out.println(e);
                }
            return true;
    }

    @Override
    public Customer read(int customer_id)
    {
        //New instance of class "Customer"
        Customer customerToReturn = new Customer();
        try
        {
            //Prepare a statement to send to mySQL database
            PreparedStatement getSingleCustomer = connectionToMySql.prepareStatement("SELECT * FROM nordic_motorhome_rental.customer WHERE customer_id="+customer_id);
            //Execute the statement
            ResultSet rs = getSingleCustomer.executeQuery();
            while(rs.next())
            {
                //...as long as rs is not empty, get customer details (customer_id, customer_firts_name, etc.)
                customerToReturn = new Customer();
                customerToReturn.setCustomerId(rs.getInt("customer_id"));
                customerToReturn.setFirstName(rs.getString("customer_first_name"));
                customerToReturn.setLastName(rs.getString("customer_last_name"));
                customerToReturn.setAddress(rs.getString("customer_address"));
                customerToReturn.setDriverLicenseNo(rs.getString("customer_driver_license_no"));
                customerToReturn.setCprNo(rs.getString("customer_cpr_no"));
            }
        }
        catch(SQLException e)
        {
            //Catch SQL exception
            System.out.println(e);
        }
        //Return new version of the class "Customer"
        return customerToReturn;
    }

    @Override
    public List<Customer> readAll() {
        List<Customer> customerArrayList = new ArrayList<Customer>();
        try
        {
            //Prepare a statement to send to mySQL database
            PreparedStatement ps = connectionToMySql.prepareStatement("SELECT * FROM nordic_motorhome_rental.customer");
            //Execute the statement
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                //...as long as rs is not empty, get customer details (customer_id, customer_firts_name, etc.)
                Customer getCustomerDetails = new Customer();
                getCustomerDetails.setCustomerId(rs.getInt("customer_id"));
                getCustomerDetails.setFirstName(rs.getString("customer_first_name"));
                getCustomerDetails.setLastName(rs.getString("customer_last_name"));
                getCustomerDetails.setAddress(rs.getString("customer_address"));
                getCustomerDetails.setDriverLicenseNo(rs.getString("customer_driver_license_no"));
                getCustomerDetails.setCprNo(rs.getString("customer_cpr_no"));
                //Add getCustomerDetails into arraylist
                customerArrayList.add(getCustomerDetails);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        //Return new version of arraylist
        return customerArrayList;
    }

    @Override
    public boolean update(Customer customer)
    {
        try
        {
            //Prepare a statement to send to mySQL database
            PreparedStatement statement = connectionToMySql.prepareStatement(
                    "UPDATE customer SET customer_id=?, customer_first_name=?, customer_last_name=?, customer_address=?, " +
                            "customer_driver_license_no=?, customer_cpr_no=? WHERE customer_id=?");
            //Change values "?" from statement to .get methods from the class "Customer"
            statement.setInt(1,customer.getCustomerId());
            statement.setString(2,customer.getFirstName());
            statement.setString(3,customer.getLastName());
            statement.setString(4,customer.getAddress());
            statement.setString(5,customer.getDriverLicenseNo());
            statement.setString(6,customer.getCprNo());
            statement.setInt(7,customer.getCustomerId());
            //Execute statement + update
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return true;
    }

    @Override
    public boolean delete(int customer_id)
    {
        try{
            //Prepare a statement to send to mySQL database
            PreparedStatement st = connectionToMySql.prepareStatement("DELETE FROM customer WHERE customer_id = ?");
            //Delete value "?" from get methods from the class "Customer"
            st.setInt(1,customer_id);
            //Execute statement + update
            st.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return true;
    }
}
