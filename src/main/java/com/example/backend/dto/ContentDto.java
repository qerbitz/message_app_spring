package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {

    private String content;


    public static final class ContentDtoBuilder {
        private String content;

        private ContentDtoBuilder() {
        }

        public static ContentDtoBuilder aContentDto() {
            return new ContentDtoBuilder();
        }

        public ContentDtoBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        public ContentDto build() {
            ContentDto contentDto = new ContentDto();
            contentDto.setContent(content);
            return contentDto;
        }
    }
}
