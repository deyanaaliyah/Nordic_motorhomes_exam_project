package motorhome.demo.controllers;

//DA

import motorhome.demo.models.Employee;
import motorhome.demo.models.Rental;
import motorhome.demo.repositories.EmployeeRepositoryImpl;
import motorhome.demo.repositories.interfaces.IEmployee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class EmployeeController {
    //For at connecte vores data fra front end til vores backend samt database, så kalder vi på en privat instans af
    //interfacet IRental som vi derefter offentliggøre og indhenter RentalRepositoryImpl's metoder.
    private IEmployee employeeRepository;

    public EmployeeController(){ employeeRepository = new EmployeeRepositoryImpl(); }

    //Indholdet i parametret i @GetMapping reserverer en plads i domænenavnet. Så hver gang browseren kalder på "/udlejning"
    //så returnerer den i dette tilfælde vores menu.html i mappen rental.
    //Håndter udlejning menu
    @GetMapping("/medarbejder")
    public String menu(){

        return "/employee/employee_Menu";
    }

    @GetMapping("/opret-medarbejder")
    public String employeeToAdd(Model model){
        Employee newEmployee = new Employee();
        model.addAttribute("employeeToBeAdded",newEmployee);

        return "employee/create_Employee";
    }

    @PostMapping("/opret-medarbejder")
    public String employeeAdded(@ModelAttribute Employee newEmployee) throws SQLException {
        employeeRepository.create(newEmployee);

        return "employee/confirmed";
    }

    //Se udlejningsdetaljer
    @GetMapping("medarbejder-detaljer")
    //Under et andet domæne og dens metode har vi inddraget et int id i vores parameter for at finde detaljerne om den
    //specifikke udlejning. Vi bruger igen addAttribute() metoden og read() metoden fra reantalRepository().
    public String getEmployeeById(Model model, int id) throws SQLException {
        //Her bruger vi addAttribute() metoden. Den første værdi i parametret er en string som man nu kan udnytte i HTML
        //og i dette tilfælde bruger vi det til at læse udlejningsdetaljerne via dens rental_id
        model.addAttribute("employee",employeeRepository.read(id));

        return "employee/read_Employee";
    }

    //Se alle udlejninger
    @GetMapping("/medarbejder-oversigt")
    public String getAllEmployee(Model model){
        model.addAttribute("employee",employeeRepository.readall());

        return "employee/read_all_Employee";
    }

    //Opdater udlejning via @PostMapping. Men først skal der inputtes nye værdier ind via denne HTML formular
    @GetMapping("/opdater-medarbejder")
    public String updateEmployeeForm(Model model, int id) throws SQLException {
        model.addAttribute("employeeToUpdate",employeeRepository.read(id));

        return "employee/update_Employee";
    }

    //Via @PostMapping gennemfører den ændringen.
    @PostMapping("/opdater-medarbejder")
    public String employeeUpdated(@ModelAttribute Employee employee) throws SQLException {
        employeeRepository.update(employee);

        return "employee/confirmed";
    }

    @GetMapping("/slet-medarbejder")
    public String deleteEmployeeWarning(Model model, int id) throws SQLException {
        //This block of code makes sure to read all data of a employee
        model.addAttribute("employeeToDelete",employeeRepository.read(id));

        //In the .HTML-file the end-user chooses to confirm or go back
        return "/employee/delete_Employee";
    }

    //When confirmed, return confirmation
    @GetMapping("/gennemført")
    public String employeeDeleted(Model model, int id){
        //This block of code makes sure to delete the employee
        model.addAttribute("employeeToDelete",employeeRepository.delete(id));

        return "/employee/confirmed";
    }
}