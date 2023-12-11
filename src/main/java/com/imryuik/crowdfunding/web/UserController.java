package com.imryuik.crowdfunding.web;
import com.imryuik.crowdfunding.data.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user", produces={"application/json", "text/xml"})
@CrossOrigin
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public String createUser() {
        return "success";
    }
}
