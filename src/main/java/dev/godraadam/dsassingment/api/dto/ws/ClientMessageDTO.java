package dev.godraadam.dsassingment.api.dto.ws;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientMessageDTO {
    private String event;
    private String content;
}
