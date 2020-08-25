package com.example.CDWSecurity.controller;



import com.example.CDWSecurity.model.Role;
import com.example.CDWSecurity.model.User;
import com.example.CDWSecurity.repository.RoleRepository;
import com.example.CDWSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (pricipal instanceof UserDetails) {
            return "redirect:/";
        }
        return "login";
    }


    @GetMapping("/login/error")
    public String loginErr(Model model) {
        String message = "Tài khoản không hợp lệ";
        model.addAttribute("message", message);
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        long id = userRepository.findByUsername(user.getUsername()).getId();


        HashSet<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_MEMBER"));
        user.setRoles(roles);
        user.setId((id));
        userRepository.save(user);

        return "redirect:/login";

    }


    @GetMapping("/delete-user")
    public String deleteUser(@PathVariable("id") long id) {
        try {
            userRepository.deleteById(id);
            return "ok";
        } catch (Exception e) {
            return "err";
        }
    }

    @PostMapping("/update-user")
    public User updateUser(@ModelAttribute("userupdate") User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/about")
    public String about(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User userModel = userRepository.findByUsername(email);
            model.addAttribute("userAbout", userModel);
        }
        return "Home/about";
    }

    // thay doi thong tin tai khoan
    @RequestMapping(value = "/saveChange")
    public String saveChange(@RequestParam(value = "diachi") String diachi, @RequestParam(value = "ten")
            String ten, @RequestParam(value = "sdt") String sdt,
                             Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            User userModel = userRepository.findByUsername(username);
            userModel.setDiachi(diachi);
            userModel.setTen(ten);
            userModel.setSdt(sdt);
            userRepository.save(userModel);
            model.addAttribute("userAbout", userModel);
            return "Home/about";
        }
        return "Home/about";
    }

    // doi password
    @RequestMapping(value = "/passwordChange")
    public String passwordChange(@RequestParam(value = "newPassword") String newPassword, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String pass = passwordEncoder.encode(newPassword);
            String username = ((UserDetails) principal).getUsername();
            User userModel = userRepository.findByUsername(username);
            userModel.setPassword(pass);
            model.addAttribute("userAbout", userModel);
            return "Home/about";
        }
        return "Home/about";
    }

    //ajaxCompeletePassword
    @RequestMapping(value = "/changepass", method = RequestMethod.POST)
    public @ResponseBody
    String ajaxCompletePassword(@RequestParam(value = "oldPassword") String oldPassword) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            User userModel = userRepository.findByUsername(username);
            //kiem tra mat khau cu va mat khau moi
            if(passwordEncoder.encode(oldPassword).equalsIgnoreCase(userModel.getPassword())){
                return "success";
            }
        }
        return "error";
    }
    //ajaxRegister
    @RequestMapping(value = "/ajaxRegister", method = RequestMethod.POST)
    public @ResponseBody String ajaxRegister(@RequestParam(value = "username") String username){
        String err ="";
        User user = userRepository.findByUsername(username);
        if (user == null){
            err = "success";
        }
        return err;
    }
}
