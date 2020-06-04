package motorhome.demo.controllers;
//Made by HM

import motorhome.demo.models.Customer;
import motorhome.demo.repositories.CustomerRepositoryImpl;
import motorhome.demo.repositories.interfaces.ICustomer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController
{

    private ICustomer customerRepository;

    public CustomerController()
    {
       customerRepository = new CustomerRepositoryImpl();
    }

    //Manage customer menu
    @GetMapping("/kunde")
    public String customerMenu()
    {
        return "/customer/customer_Menu";
    }


    //Create a customer
    @GetMapping("/opret-kunde")
    public String createCustomer(Model model)
    {
        Customer customer = new Customer();
        model.addAttribute("newCustomer", customer);
        return"customer/create_Customer";
    }

    //Allows input request about creating a customer and adds the created customer to the database
    @PostMapping("/opret-kunde")
    public String createdCustomer(@ModelAttribute Customer createdCustomer)
    {
        customerRepository.create(createdCustomer);
        return"customer/read_CustomerDetails";
    }

    //Reads the customer details
    @GetMapping("/kunde-detaljer")
    public String readCustomerId(Model model, int Id)
    {
        model.addAttribute("customer", customerRepository.read(Id));
        return"customer/read_CustomerDetails";
    }

    //Gives an overview of the customers
    @GetMapping("/kunde-oversigt")
    public String readAllCustomers(Model model)
    {
        model.addAttribute("customer",customerRepository.readAll());
        return "customer/customerOverview";
    }

    //Update a customer
    @GetMapping("/rediger-kunde")
    public String updateCustomer(Model model, int Id)
    {
        model.addAttribute("updatedCustomer", customerRepository.read(Id));
        return"customer/update_Customer";
    }

    //Allows input request about creating a customer and adds the updated customer to the database
    @PostMapping("/rediger-kunde")
    public String typeUpdateCustomer(@ModelAttribute Customer updatedCustomer)
    {
        customerRepository.update(updatedCustomer);
        return"customer/read_CustomerDetails";
    }

    //Delete a customer
    @GetMapping("/slet-kunde")
    public String deleteCustomerWarning(Model model, int Id)
    {
        //This block of code makes sure to read all data of a customer
        model.addAttribute("customer",customerRepository.read(Id));

        //In the .HTML-file the end-user chooses to confirm or go back
        return "/customer/delete_Customer";
    }

    //When confirmed, return confirmation
    @GetMapping("/slet-kunde-successfuldt")
    public String customerDeleted(Model model, int Id)
    {
        //This block of code makes sure to delete the customer
        model.addAttribute("customer",customerRepository.delete(Id));

        return "/customer/taskConfirmed";
    }
}
