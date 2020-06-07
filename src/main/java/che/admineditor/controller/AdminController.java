package che.admineditor.controller;

import che.admineditor.domain.Message;
import che.admineditor.repo.MessageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final MessageRepo messageRepo;
    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    public AdminController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/getAll")
    public List<Message> getAll(){
        return messageRepo.findAll();
    }

    @GetMapping("/get/{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping("/add")
    public Message add(@RequestBody Message message) {
        logger.info("create " + message.toString());
        return messageRepo.save(message);
    }

    @PutMapping("/update/{id}")
    public Message update(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDb, "id");
        return  messageRepo.save(messageFromDb);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Message message) {
        messageRepo.delete(message);
    }
}
