package com.example.ChallengeDisney.controller;

import com.example.ChallengeDisney.entity.UserName;
import com.example.ChallengeDisney.service.UserNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Enzo sosa
 */
@RestController
@RequestMapping("/auth")
public class UserNameController {

    @Autowired
    private UserNameService us;

    @GetMapping("/login")
    public String login(Model model,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String error, RedirectAttributes redirectAttributes) {

        try {
            model.addAttribute("userName", userName);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/";
        }

        return "redirect:/";
    }

    @PostMapping("/register")
    public UserName register(@RequestBody UserName userName, MultipartFile image) {
        return us.createUser(userName, image);

    }

}
