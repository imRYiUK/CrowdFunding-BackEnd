package com.imryuik.crowdfunding.web;

import com.imryuik.crowdfunding.JsonRes.resUser;
import com.imryuik.crowdfunding.data.UserRepository;
import com.imryuik.crowdfunding.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user", produces={"application/json", "text/xml"})
@CrossOrigin
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public resUser createUser(@RequestBody User user) {
//        userRepository.save(user);
        return null;
    }
}
