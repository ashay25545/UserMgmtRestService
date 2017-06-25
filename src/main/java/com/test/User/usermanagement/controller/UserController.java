package com.test.User.usermanagement.controller;
import com.sun.deploy.net.HttpResponse;
import com.test.User.usermanagement.domain.User;
import com.test.User.usermanagement.dto.MessageDTO;
import com.test.User.usermanagement.dto.MessageType;
import com.test.User.usermanagement.exception.UserExistException;
import com.test.User.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AshayRajimwale on 6/24/2017.
 * Expose CRUD services for user management
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    private MessageSource msgSource;

    @Inject
    public UserController(final UserService userService) {
        this.userService=userService;
    }

    /**
     *
     * @param user
     * @return
     * @desc Created the new User
     */
    @RequestMapping(value="/createUser",method= RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid final User user)
    {
        logger.info("Creating Service");
        return userService.save(user);

    }

    /**
     *
     * @return
     * @desc Returns all the users list
     */
    @RequestMapping(value="/getAllUsers",method= RequestMethod.GET)
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();

    }

    /**
     *
     * @param user
     * @param response
     * @return
     * @desc Update the user details .if there is no user returns Nofound Error
     */
    @RequestMapping(value="/updateUser",method= RequestMethod.PATCH)
    @ResponseBody
    public MessageDTO updateUser(@RequestBody @Valid final User user,HttpServletResponse response)
    {
        MessageDTO message=null;
        try{
            User updatedUser =  userService.updateUser(user);
            Locale currentLocale = LocaleContextHolder.getLocale();
            String msg = msgSource.getMessage("record.updated.message", null, currentLocale);
            message  = new MessageDTO(MessageType.SUCCESS, msg);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
        catch(UserExistException exp)
        {
            Locale currentLocale = LocaleContextHolder.getLocale();
            String msg = msgSource.getMessage("user.notfound.error", null, currentLocale);
            message  = new MessageDTO(MessageType.ERROR, msg);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

        return message;

    }



}
