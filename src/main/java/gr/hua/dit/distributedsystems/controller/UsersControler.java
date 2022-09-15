package gr.hua.dit.distributedsystems.controller;

import gr.hua.dit.distributedsystems.Exception.UserNotFoundException;
import gr.hua.dit.distributedsystems.Service.UserService;
import gr.hua.dit.distributedsystems.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        model.addAttribute("pageTitle", "User Registration - Sign Up");
        model.addAttribute("info", "SIGN UP");
        model.addAttribute("link", "process_register");

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(@Valid User user, BindingResult result, Model model, HttpServletRequest request, RedirectAttributes ra) {

        ra.addFlashAttribute("message", "Ο ΛΟΓΑΡΙΣΑΜΟΣ ΔΗΜΙΟΥΡΓΙΘΗΚΕ ");

        String lang = request.getParameter("tt");
        service.registerUser(user, lang);

        return "redirect:/home";
    }

    @GetMapping("/signup_form/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model, RedirectAttributes ra) {
        try {
            User user = service.get(id);


            model.addAttribute("user", user);


            model.addAttribute("pageTitle", "EDIT USER (ID " + id);
            model.addAttribute("info", "SAVE UPDATE");
            model.addAttribute("link", "signup_form/save");

            System.out.println();

            return "signup_form";

        } catch (UserNotFoundException e) {
            return "redirect:signup_form";
        }
    }
    @PostMapping("/signup_form/save")
    public String saveUser(User user , RedirectAttributes ra ,  HttpServletRequest request) throws UserNotFoundException {

        String lang = request.getParameter("tt");
        
        service.save(user, lang);

        ra.addFlashAttribute("message", "ενημερωθηκαν τα στοιχεια !!");

        return "redirect:/allUsers";

    }

    @GetMapping("/allUsers/delete/{id}")
    public String delete(@PathVariable("id") String id , RedirectAttributes ra) throws UserNotFoundException {

        service.delete(id);
        ra.addFlashAttribute("message", "διαγράφηκε με επιτυχία  !!");

        return "redirect:/allUsers";

    }
}