package com.example.CDWSecurity.controller;

import com.example.CDWSecurity.model.Role;
import com.example.CDWSecurity.model.User;
import com.example.CDWSecurity.repository.RoleRepository;
import com.example.CDWSecurity.repository.SanPhamRepository;
import com.example.CDWSecurity.repository.UserRepository;
import com.example.CDWSecurity.service.DanhMucService;
import com.example.CDWSecurity.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequestMapping("/")
@Controller
public class HomePageController {

    @Autowired
    DanhMucService danhMucService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SanPhamRepository sanPhamRepository;
    @GetMapping("/")
    public String homeIndex(Model model, HttpSession session){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            User user = userRepository.findByUsername(((UserDetails) principal).getUsername());
            session.setAttribute("user",user);
        }
//        User user = new User();
//        List<Role> roles = roleRepository.findAll();
//        user.setUsername("thinh");
//        user.setPassword(passwordEncoder.encode("1"));
//        Set<Role> roleSet = new HashSet<Role>();
//        roleSet.add(roles.get(1));
//        user.setRoles(roleSet);
//        userRepository.save(user);
        session.setAttribute("listDanhMuc",danhMucService.findAllDanhMuc());
        session.setAttribute("listSanPham",sanPhamRepository.findAll(PageRequest.of(0,5)));
        return "index";

    }
    @GetMapping("/Home/spById/{id}")
    public String homeDetail(Model model , @PathVariable("id") long id,HttpSession session){
        session.setAttribute("spById",sanPhamService.findById(id));
        session.setAttribute("listDanhMuc",danhMucService.findAllDanhMuc());
        session.setAttribute("listSanPham",sanPhamService.findAll());
        return "Home/detail-product";
    }



}
