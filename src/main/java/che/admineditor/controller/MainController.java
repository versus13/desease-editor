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
@CrossOrigin("*")
@RequestMapping("/admin")
public class MainController {

    private final MessageRepo messageRepo;
    private Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    public MainController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/getAll")
    public List<Message> getAll(){
        return messageRepo.findAll();
    }
    @GetMapping("{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping("/create")
    public Message create(@RequestBody Message message) {
        return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public void update(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message) {
        logger.info("messageFromDb:::::::::::: " + messageFromDb.toString());
        logger.info("message:::::::::::: " + message.toString());
        BeanUtils.copyProperties(message, messageFromDb, "id");
        messageRepo.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public List<Message> delete(@PathVariable("id") Message message) {
        messageRepo.delete(message);
        return this.getAll();
    }
}
