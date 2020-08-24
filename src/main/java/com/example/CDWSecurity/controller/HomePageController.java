package com.example.CDWSecurity.controller;

import com.example.CDWSecurity.model.DanhMuc;
import com.example.CDWSecurity.model.Role;
import com.example.CDWSecurity.model.SanPham;
import com.example.CDWSecurity.model.User;
import com.example.CDWSecurity.repository.DanhMucRepository;
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
import java.util.ArrayList;
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
    @Autowired
    DanhMucRepository danhMucRepository;
    @GetMapping("/")
    public  String index(Model model, HttpSession session) {
        Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (pricipal instanceof UserDetails) {
            User user = userRepository.findByUsername(((UserDetails) pricipal).getUsername());
            session.setAttribute("user", user);
        }
        List<DanhMuc> test = danhMucRepository.findAll();
        session.setAttribute("listdanhmuc", danhMucRepository.findAll());
        List<SanPham> sanPhamList = sanPhamService.findAll();
        List<SanPham> sps = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            sps.add(sanPhamList.get(i));
        }
        session.setAttribute("listSanPham", sps);
        session.setAttribute("showmore", 5);
        return "index";

    }


    @RequestMapping(value = "/showmore", method = RequestMethod.GET)
    public String showMore(HttpSession session) {
        int showmore = (int) session.getAttribute("showmore");
        List<SanPham> sanPhamList = sanPhamService.findAll();
        int temp = 0;
        if (sanPhamList.size() - 5 >= showmore) {
            showmore += 5;
        } else {
            temp = sanPhamList.size() - showmore;
            showmore += temp;
        }
        List<SanPham> sps = new ArrayList<>();
        for (int i = 0; i < showmore; i++) {
            sps.add(sanPhamList.get(i));
        }
        session.setAttribute("showmore", showmore);
        session.setAttribute("listSanPham", sps);
        session.setAttribute("listdanhmuc", danhMucService.findAllDanhMuc());
        return "index";
    }

    @GetMapping("/Home/spById/{id}")
    public String homeDetail(Model model , @PathVariable("id") long id,HttpSession session){
        session.setAttribute("spById",sanPhamService.findById(id));
        session.setAttribute("listDanhMuc",danhMucService.findAllDanhMuc());
        session.setAttribute("listSanPham",sanPhamService.findAll());
        return "Home/detail-product";
    }
    @GetMapping("/searchsp")
    public String searchHome(@RequestParam(value = "term") String key ,Model model , HttpSession session){
        session.setAttribute("searchSp",sanPhamService.searchSp(key));
        return "Home/search";
    }

    @GetMapping("/Home/spbydm/{id}")
    public String listSpByDmuc(@PathVariable("id") long id, HttpSession session) {
        DanhMuc dmuc = danhMucService.findById(id);
        List<SanPham> list = dmuc.getSanPhams();
        session.setAttribute("listspbydanhmuc", list);
        session.setAttribute("listdanhmuc", danhMucService.findAllDanhMuc());
        return "Home/product";
    }

}
