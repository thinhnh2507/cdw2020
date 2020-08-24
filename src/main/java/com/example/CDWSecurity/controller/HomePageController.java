package com.example.CDWSecurity.controller;

import com.example.CDWSecurity.model.*;
import com.example.CDWSecurity.repository.*;
import com.example.CDWSecurity.service.DanhMucService;
import com.example.CDWSecurity.service.SanPhamService;
import com.example.CDWSecurity.service.ThuongHieuService;
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
import java.util.*;

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
    @Autowired
    ThuongHieuRepository thuongHieuRepository;
    @Autowired
    ThuongHieuService thuongHieuService;
    @GetMapping("/")
    public  String index(Model model, HttpSession session) {
        Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (pricipal instanceof UserDetails) {
            User user = userRepository.findByUsername(((UserDetails) pricipal).getUsername());
            session.setAttribute("user", user);
        }
        List<DanhMuc> test = danhMucRepository.findAll();
        session.setAttribute("listdanhmuc", thuongHieuService.findAllTh());
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
        session.setAttribute("listdanhmuc", thuongHieuService.findAllTh());
        return "index";
    }

    @GetMapping("/Home/spById/{id}")
    public String homeDetail(Model model , @PathVariable("id") long id,HttpSession session){
        session.setAttribute("spById",sanPhamService.findById(id));
        session.setAttribute("listdanhmuc",thuongHieuService.findAllTh());
        session.setAttribute("listSanPham",sanPhamService.findAll());
        return "Home/detail-product";
    }
    @GetMapping("/searchsp")
    public String searchHome(@RequestParam(value = "term") String key ,Model model , HttpSession session){
        session.setAttribute("listdanhmuc", thuongHieuService.findAllTh());
        session.setAttribute("searchSp",sanPhamService.searchSp(key));
        return "Home/search";
    }

    @GetMapping("/Home/spbydm/{id}")
    public String listSpByDmuc(@PathVariable("id") long id, HttpSession session) {
        ThuongHieu thuongHieu = thuongHieuService.findById(id);
        List<SanPham> sanPhams = thuongHieu.getSanPhamList();
        session.setAttribute("listspbydanhmuc",sanPhams);
        session.setAttribute("listdanhmuc", thuongHieuService.findAllTh());
        return "Home/product";
    }

}
