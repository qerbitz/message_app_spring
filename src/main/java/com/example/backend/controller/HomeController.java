package com.example.backend.controller;

import com.example.backend.dto.RecipientDto;
import com.example.backend.entity.Message;
import com.example.backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.backend.mapper.ObjectMapper.mapMessageToRecipienReadDtoList;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class HomeController {

    private MessageService messageService;

    @Autowired
    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/recipientsList")
    public ResponseEntity<List<String>> recipientsList(){
        List<RecipientDto> allSenders = mapMessageToRecipienReadDtoList(messageService.getAllMessages())
                .stream()
                .distinct()
                .collect(Collectors.toList());


        List<String> list = allSenders.stream().map(RecipientDto::getRecipient).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/senderMessages")
    public ResponseEntity<List<Message>> senderMessages(@RequestParam("sender") String sender){
        return new ResponseEntity<>(messageService.getMessagesBySender(sender), HttpStatus.OK);
    }

    @PostMapping("/saveMessage")
    public ResponseEntity<List<Message>> saveMessage(@RequestBody Message message){
        messageService.saveMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
