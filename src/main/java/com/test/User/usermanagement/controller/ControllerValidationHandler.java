package com.test.User.usermanagement.controller;

/**
 * Created by AshayRajimwale on 6/25/2017.
 */
import java.util.Locale;

import com.test.User.usermanagement.dto.MessageDTO;
import com.test.User.usermanagement.dto.MessageType;
import com.test.User.usermanagement.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Exception Handler-Handles all the exception
 *
 *
 */
@ControllerAdvice
public class ControllerValidationHandler {

    @Autowired
    private MessageSource msgSource;

    /**
     *
     * @param ex
     * @return
     * @desc Process invalid arguments Exception
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessageDTO processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        FieldError error = result.getFieldError();
        return processFieldError(error);
    }

    /**
     *
     * @param error
     * @return
     * @desc Process the error and send back the error statuc and error message
     */
    private MessageDTO processFieldError(FieldError error) {
        MessageDTO message = null;
        if (error != null) {
            Locale currentLocale = LocaleContextHolder.getLocale();
            String msg = msgSource.getMessage(error.getDefaultMessage(), null, currentLocale);
            message = new MessageDTO(MessageType.ERROR, msg);
        }
        return message;
    }

    /**
     *
     * @param userExistExp
     * @return
     * @desc Handle User exist Exception.Send error status and error message
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public MessageDTO handleUserExistException(UserExistException userExistExp)
    {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String msg = msgSource.getMessage(userExistExp.getMessage(), null, currentLocale);
        MessageDTO message  = new MessageDTO(MessageType.ERROR, msg);

        return message;
    }
}
