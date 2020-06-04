package motorhome.demo.controllers;

//DA

import motorhome.demo.models.Rental;
import motorhome.demo.repositories.RentalRepositoryImpl;
import motorhome.demo.repositories.interfaces.IRental;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class RentalController {
    private IRental rentalRepository;
    public RentalController(){ rentalRepository = new RentalRepositoryImpl(); }


    //Håndter udlejning menu
    @GetMapping("/udlejning")
    public String createUdlejning(){

        return "/rental/menu";
    }

    @GetMapping("/opret-udlejning")
    public String rentalToAdd(Model model){
        Rental newRental = new Rental();
        model.addAttribute("rentalToBeAdded",newRental);

        return "rental/create";
    }

    //opret udlejning
    @PostMapping("/opret-udlejning")
    public String rentalAdded(@ModelAttribute Rental newRental) throws SQLException {
        rentalRepository.create(newRental);

        return "rental/confirmed";
    }

    //Se udlejningsdetaljer
    @GetMapping("udlejning-detaljer")
    public String getRentalById(Model model, int id){
        model.addAttribute("rental",rentalRepository.read(id));

        return "rental/see_details";
    }

    //Se alle udlejninger
    @GetMapping("/udlejninger")
    public String getAllRentals(Model model){
        model.addAttribute("rentals",rentalRepository.readall());

        return "rental/read_all";
    }

    //opdater udlejning
    @GetMapping("/opdater-udlejning")
    public String updateRentalForm(Model model, int id){
        model.addAttribute("rentalToUpdate",rentalRepository.read(id));

        return "rental/update";
    }

    //Via @PostMapping gennemfører den ændringen.
    @PostMapping("/opdater-udlejning")
    public String rentalUpdated(@ModelAttribute Rental rental) throws SQLException {
        rentalRepository.update(rental);

        return "rental/confirmed";
    }

    //slet uldejning
    @GetMapping("/slet-udlejning")
    public String deleteRentalWarning(Model model, int id){
        model.addAttribute("rental",rentalRepository.read(id));

        return "/rental/delete";
    }

    @GetMapping("/succesfull")
    public String rentalDeleted(Model model, int id){
        model.addAttribute("rental",rentalRepository.delete(id));

        return "/rental/confirmed";
    }
}