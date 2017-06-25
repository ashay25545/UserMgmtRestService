package com.test.User.usermanagement.dto;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by AshayRajimwale on 6/25/2017.
 *
 * Message Dto to save error status and error message
 */
public class MessageDTO  {

    private String message;
    private MessageType type;


    public MessageDTO() {
        super();
    }

    public MessageDTO(MessageType type, String message) {
        super();
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }


}
