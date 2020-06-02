package che.admineditor.controller;

import che.admineditor.domain.User;
import che.admineditor.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationController {
    private static final Logger l = LoggerFactory.getLogger(RegistrationController.class);

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String addUser(@RequestBody User userForm) {
        l.info("addUser " + userForm.toString());
        if (!userService.saveUser(userForm)) {
            return "Пользователь уже существует";
        }
        return "Вы зарегистрированы!";
    }
}