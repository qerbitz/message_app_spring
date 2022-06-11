package com.example.backend.service;

import com.example.backend.entity.Message;
import com.example.backend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    public List<Message> getMessagesBySender(String recipient){
        return messageRepository.getAllByRecipientOrderByIdDesc(recipient);
    }

    public void saveMessage(Message message){
        messageRepository.save(message);
    }
}
