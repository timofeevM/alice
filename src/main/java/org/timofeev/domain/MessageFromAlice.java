package org.timofeev.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageFromAlice {

    private Request request;

    @Data
    public static class Request{
        @JsonProperty("original_utterance")
        private String originalUtterance;
    }
}
