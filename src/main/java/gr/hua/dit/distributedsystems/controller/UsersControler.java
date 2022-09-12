package gr.hua.dit.distributedsystems.controller;

import gr.hua.dit.distributedsystems.Service.UserService;
import gr.hua.dit.distributedsystems.entity.Authorities;
import gr.hua.dit.distributedsystems.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@org.springframework.stereotype.Controller
public class UsersControler {

    @Autowired
    private UserService service;

    @GetMapping("/allUsers")
    public String listUsers(Model model) {
        List<User> listUsers = service.listAll1();
        model.addAttribute("listUsers", listUsers);

        return "/allUsers";
    }

    @GetMapping("/signup_form")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        List<Authorities> listRoles = service.listRoles();
        model.addAttribute("listRoles", listRoles);

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(@Valid User user, BindingResult result, Model model, HttpServletRequest request, RedirectAttributes ra) {

        ra.addFlashAttribute("message", "Ο ΛΟΓΑΡΙΣΑΜΟΣ ΔΗΜΙΟΥΡΓΙΘΗΚΕ ");

        String lang = request.getParameter("tt");
        service.registerUser(user, lang);

        return "redirect:/home";
    }

}