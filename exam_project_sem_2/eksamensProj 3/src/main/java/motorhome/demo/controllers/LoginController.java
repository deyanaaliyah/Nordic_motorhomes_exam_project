package motorhome.demo.controllers;

import motorhome.demo.models.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/")
    public String getLogin(){
        return "index";
    }

    @PostMapping("/")
    public String adminLogin(@ModelAttribute(name= "loginInput") Login loginInput, Model model) {

        String username = loginInput.getUsername();
        String password = loginInput.getUserPassword();

        if("admin".equals(username) && "admin".equals(password)) {
            model.addAttribute("invalidSomething",false);
            return "mainMenu/mainMenu";
        }
        else{
            model.addAttribute("invalidSomething",true);
            return "index";
        }
    }
}
