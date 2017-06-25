package com.test.User.usermanagement.repository;

import com.test.User.usermanagement.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by AshayRajimwale on 6/24/2017.
 */

/**
 * Checks if the user already present in DB
 */
public interface UserRepository extends JpaRepository<User,UUID>{

    public List<User> findByFirstNameAndLastNameAndAgeAndGenderAndPhoneNumber(String firstName,String lastName,Integer age,String gender,String phoneNumber);
}
