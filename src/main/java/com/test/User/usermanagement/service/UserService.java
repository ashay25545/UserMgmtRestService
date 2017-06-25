package com.test.User.usermanagement.service;

import com.test.User.usermanagement.domain.User;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by AshayRajimwale on 6/24/2017.
 */
public interface UserService {

    User save(User user);

    List<User> getAllUsers();

    User updateUser(User user);
}
