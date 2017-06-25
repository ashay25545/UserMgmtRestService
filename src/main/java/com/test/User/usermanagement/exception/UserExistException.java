package com.test.User.usermanagement.exception;

/**
 * Created by AshayRajimwale on 6/24/2017.
 */
public class UserExistException extends RuntimeException {

    public UserExistException(final String message)
    {
        super(message);
    }
}
