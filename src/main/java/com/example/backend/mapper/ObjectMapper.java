package com.example.backend.mapper;

import com.example.backend.dto.RecipientDto;
import com.example.backend.entity.Message;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapper {

    public static List<RecipientDto> mapMessageToRecipienReadDtoList(List<Message> messages) {
        return messages.stream()
                .map(message -> mapMessageToRecipientDto(message))
                .collect(Collectors.toList());
    }

    public static RecipientDto mapMessageToRecipientDto(Message message) {
        return RecipientDto.RecipientDtoBuilder.aRecipientDto()
                .withSender(message.getSender())
                .build();
    }
}
