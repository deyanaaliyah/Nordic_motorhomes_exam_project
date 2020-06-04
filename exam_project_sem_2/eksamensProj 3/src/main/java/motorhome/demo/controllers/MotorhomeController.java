package motorhome.demo.controllers;

import motorhome.demo.models.Motorhome;
import motorhome.demo.repositories.MotorhomeRepositoryImpl;
import motorhome.demo.repositories.interfaces.IMotorhome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller // fortæller editoren at det er en controller klassen
// (MVC) Model(logikken-backend) view(UI) controller(Styresystemt på bagrund af M og V) og
// den har flere mønstre såsom (get/post/request mapping)

//model klassen


public class MotorhomeController {

    private IMotorhome motorhomeRepository;

    public MotorhomeController(){
        motorhomeRepository =new MotorhomeRepositoryImpl();
    }

    //Manage Motorhome menu
    @GetMapping("/motorhome")
        public String motorHomeMenu(){
        return "/motorhome/motorhomeMenu";

    }

    //Create a Motorhome
    @GetMapping("/motorhome-create")
        public String createMotorHome(Model model){
    motorhome.demo.models.Motorhome newMotorhome =new Motorhome();
    model.addAttribute("motorhomeToAdd",newMotorhome);
        return "motorhome/create_motorhome";

}
    //Allows input request about creating a Motorhome and adds the created Motorhome to the database
    @PostMapping("/motorhome-create")
    public String createdMotorhome(@ModelAttribute motorhome.demo.models.Motorhome newMotorhome) throws SQLException {
        motorhomeRepository.create(newMotorhome);

        return "/motorhome/confirmation";
    }


    //Gives an overview of Motorhomes
    @GetMapping("/motorhome-overview")
        public String motorHomeOverview(Model model){
        model.addAttribute("motorhomeOverview", motorhomeRepository.readAll());
        return "/motorhome/motorhomeOverview";

    }
    //Reads the Motorhome details
    @GetMapping("motorhome-detaljer")

    public String getMotorhomeById(Model model, int id){
    model.addAttribute("motorhome",motorhomeRepository.read(id));
    return "/motorhome/see_details";
    }

    //update Motorhome
    @GetMapping("/opdater-motorhome")
    public String updateMotorhome(Model model, int id){
        model.addAttribute("motorhomeToUpdate",motorhomeRepository.read(id));

        return "/motorhome/update";
    }

    //Allows input request about updating a Motorhome and adds the updated Motorhome to the database
    @PostMapping("/opdater-motorhome")
    public String motorhomeUpdated(@ModelAttribute motorhome.demo.models.Motorhome motorhome) throws SQLException {
        motorhomeRepository.update(motorhome);

        return "/motorhome/confirmation";
    }

    // Delete Motorhome
    @GetMapping("/slet-motorhome")
    public String deleteMotorhomeWarning(Model model, int id){
        //This block of code makes sure to read all data of Motorhome
        model.addAttribute("motorhome",motorhomeRepository.read(id));

        //In the .HTML-file the end-user chooses to confirm or go back
        return "/motorhome/deleteMotorhome";
    }

    //When confirmed, return confirmation
    @GetMapping("/slet-motorhome-successfuldt")
    public String motorhomeDeleted(Model model, int id){
        //This block of code makes sure to delete the motorhome info
        model.addAttribute("motorhome",motorhomeRepository.delete(id));

        return "/motorhome/confirmation";
    }
}
