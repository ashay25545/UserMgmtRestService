package com.test.User.usermanagement;

import com.test.User.usermanagement.domain.User;

/**
 * Created by AshayRajimwale on 6/25/2017.
 */
public class UserUtil {

    public static User createUser()
    {
        return  new User("Ashay","Raj","Rajimwale",23,"M","9827180483","76013");
    }
}
