package com.test.User.usermanagement.service;

import com.test.User.usermanagement.domain.User;
import com.test.User.usermanagement.exception.UserExistException;
import com.test.User.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by AshayRajimwale on 6/24/2017.
 */

/**
 * Dao Layer to perform all crud operation
 */
@Service
@Validated
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    EntityManager entityManager;
    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    @Transactional
    public User save(User user) {

        /**
         * Checks if the user already present
         */
        List<User> existingUser= userRepository.findByFirstNameAndLastNameAndAgeAndGenderAndPhoneNumber(user.getFirstName(),
                user.getLastName(),user.getAge(),user.getGender(),user.getPhoneNumber());
        if(existingUser!=null && existingUser.size()>=1)
        {
           throw new UserExistException("user.exist.error");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser= userRepository.findOne(user.getId());
        if(existingUser==null)
        {
            throw new UserExistException("user.notfound.error");
        }
        return userRepository.save(user);
    }


}
