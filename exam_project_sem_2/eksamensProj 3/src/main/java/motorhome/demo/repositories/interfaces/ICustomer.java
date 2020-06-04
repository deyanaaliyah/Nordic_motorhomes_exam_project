package motorhome.demo.repositories.interfaces;
//Made by HM

import motorhome.demo.models.Customer;

import java.util.List;

public interface ICustomer
{
    // CRUD operations

    public boolean create(Customer customer); //creates a customer

    public Customer read(int customer_id); //read a customer

    public List<Customer> readAll(); //Reads all customer

    public boolean update(Customer customer); //Updates customer

    public boolean delete(int customer_id); //Deletes a customer
}
