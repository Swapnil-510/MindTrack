package com.MindTrack.controller;

import com.MindTrack.model.User;
import com.MindTrack.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // SIGNUP
    @PostMapping("/signup")
    public String signup(User user, RedirectAttributes redirectAttributes){

        Optional<User> existingUser =
                userRepository.findByEmail(user.getEmail());

        if(existingUser.isPresent()){
            redirectAttributes.addFlashAttribute("message","User already exists. Please login.");
            return "redirect:/login";
        }

        userRepository.save(user);

        redirectAttributes.addFlashAttribute("message","Account created successfully. Please login.");

        return "redirect:/login";
    }


    // LOGIN
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes){

        Optional<User> existingUser = userRepository.findByEmail(email);

        if(existingUser.isPresent()){

            User user = existingUser.get();

            if(user.getPassword().equals(password)){

                session.setAttribute("userEmail", email);

                return "redirect:/dashboard";
            }
        }

        redirectAttributes.addFlashAttribute("message","Invalid email or password.");

        return "redirect:/login";
    }


    // LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes){

        session.invalidate();

        redirectAttributes.addFlashAttribute("message","You have been logged out successfully.");

        return "redirect:/login";
    }


    // TEST
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "API working";
    }
}