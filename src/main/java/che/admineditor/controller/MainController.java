package che.admineditor.controller;

import che.admineditor.domain.Message;
import che.admineditor.domain.Views;
import che.admineditor.repo.MessageRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("main")
public class MainController {

    private final MessageRepo messageRepo;

    @Autowired
    public MainController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list(){
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message getOne(@PathVariable("id") Message message){
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreationDate(LocalDateTime.now());
        return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message update (
            @PathVariable("id") Message messageFromDb,
            @RequestBody  Message message) {
        BeanUtils.copyProperties(message, messageFromDb,"id");
        return messageRepo.save(messageFromDb);
    }
    @DeleteMapping("{id}")
    public Message delete(@PathVariable("id") Message message) {
      return message;
    }
}
