package fr.lernejo.chat;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatMessageController {

    @GetMapping(value="/message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getMessages(){
        return new ResponseEntity<>(ChatMessageRepository.getLastTenMessages(), HttpStatus.OK);
    }
}
