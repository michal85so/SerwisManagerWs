package pl.policht.smws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.policht.smws.repository.AddressDaoImpl;

@Controller
public class HomeController {

    @Autowired
    AddressDaoImpl addressDao;

    @RequestMapping("/")
    public String welcome(Model model) {
        addressDao.findAllAddresses();
        model.addAttribute("greeting", "Hello world");
        model.addAttribute("tagline", "New configuration");
        return "welcome";
    }
}
