package com.example.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipientDto {

    private String recipient;


    public static final class RecipientDtoBuilder {
        private String sender;

        private RecipientDtoBuilder() {
        }

        public static RecipientDtoBuilder aRecipientDto() {
            return new RecipientDtoBuilder();
        }

        public RecipientDtoBuilder withSender(String sender) {
            this.sender = sender;
            return this;
        }

        public RecipientDto build() {
            RecipientDto recipientDto = new RecipientDto();
            recipientDto.setRecipient(sender);
            return recipientDto;
        }
    }
}
