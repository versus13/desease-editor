package che.admineditor.controller;

import che.admineditor.domain.User;
import che.admineditor.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    private UserRepo userRepo;

    @Autowired
    public RegistrationController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/registration")
    public String registration(){
        return "register";
    }

    @PostMapping("/registration")
    public String addUser(User user){
        logger.info("in register 1 ");
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if(userFromDb!=null){
            logger.info("user exists!");
        }
        return "redirect:/login";
    }
}
