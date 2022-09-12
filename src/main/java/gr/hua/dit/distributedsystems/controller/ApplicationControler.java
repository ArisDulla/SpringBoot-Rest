package gr.hua.dit.distributedsystems.controller;

import gr.hua.dit.distributedsystems.entity.Application;
import gr.hua.dit.distributedsystems.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ApplicationControler {

    @Autowired private ApplicationService service;

    @GetMapping("/allApplications")
    public String showUserList(Model model){
        List<Application> listApplications = service.listAll();

        model.addAttribute("listApplications" , listApplications);

        return "allApplications";
    }

    @GetMapping("/newApplication")
    public String showNewForm(Model model){
        model.addAttribute("applications",new Application());

        model.addAttribute("pageTitle","ΑΙΤΗΣΗ Αναβολής στράτευσης");
        return "newApplication";
    }

    @PostMapping("/form-user/save")
    public String saveUser(Application application, RedirectAttributes ra , @CurrentSecurityContext(expression="authentication?.name")
    String username) {

        ra.addFlashAttribute("message","Η αιτηση σας καταχωρηθηκε με επιτυχια");
        service.save(application);

        service.setDDD(application.getId() , username);
        return "redirect:/home";
    }
    @GetMapping("/allApplications/epikirosi/{id}")
    public String epikirosi(@PathVariable("id") Integer id, Model model,  RedirectAttributes ra) {

         ra.addFlashAttribute("message","Επικυρωθηκε με επιτυχια");
         service.changeEn(id);

        return "redirect:/allApplications";
    }
    @GetMapping("/allApplications/egkrisi/{id}")
    public String egkrisi(@PathVariable("id") Integer id, Model model,  RedirectAttributes ra) {

        ra.addFlashAttribute("message","ΕΓΚΡΙΘΗΚΕ με επιτυχια");
        service.changeEn2(id);

        return "redirect:/allApplications";
    }

}




