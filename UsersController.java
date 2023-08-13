package com.ayush.UserManagement.controller;


import com.ayush.UserManagement.model.UsersModel;
import com.ayush.UserManagement.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {


    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String getRegister(Model model){

        model.addAttribute("registerRequest",new UsersModel());

        return "register";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("loginRequest", new UsersModel());
        return "login";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel) {

        System.out.println("register request: " + usersModel);
        UsersModel registeredUser = usersService.registerUser(usersModel.getFullName(),usersModel.getEmail(), usersModel.getPassword(),
                usersModel.getDob(), usersModel.getAddress(),usersModel.getState(), usersModel.getContact(),
                usersModel.getGender());

        return registeredUser == null ?  "error" : "redirect:/login" ;

    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model) {

        System.out.println("login request: " + usersModel);
        UsersModel authenticated = usersService.authenticate(usersModel.getEmail(), usersModel.getPassword());

        if(authenticated !=null) {
            model.addAttribute("userLogin" , authenticated.getFullName() );

            return "personal";

        } else {
            return "error";
        }

    }
}


