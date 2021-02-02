package com.lablogic.store.resource;

import com.lablogic.store.StoreApplication;
import com.lablogic.store.Token;
import com.lablogic.store.model.Product;
import com.lablogic.store.model.User;
import com.lablogic.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserResource
{
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public Map<String, String> getOne(@RequestBody User user)
    {
        Map<String, String> result = new HashMap<>();
        User newUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if(newUser != null)
        {
            user = newUser;
            result.put("name", user.getName());
            result.put("email", user.getEmail());
            result.put("id", String.valueOf(user.getId()));
            result.put("token", Token.createToken(user.getId()));
        }

        else
        {
            result.put("error", "User not found.");
        }

        return result;
    }

    @PostMapping("/register")
    public Map<String, String> insert(@RequestBody User user)
    {
        Map<String, String> result = new HashMap<>();

        try
        {
            userRepository.save(user);

            result.put("name", user.getName());
            result.put("email", user.getEmail());
            //result.put("date_time", user.getDateTime());
            result.put("id", String.valueOf(user.getId()));
            result.put("token", Token.createToken(user.getId()));
        }

        catch (Exception e)
        {
            result.put("error", "Email already in use.");
        }

        return result;
    }
}
