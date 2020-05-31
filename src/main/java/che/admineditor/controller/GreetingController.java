package che.admineditor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class GreetingController {
    private Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping
    public String main(Model model){

        HashMap<Object, Object> data = new HashMap<>();
        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));
        return "index";
    }
}
