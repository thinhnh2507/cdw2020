package com.example.CDWSecurity.controller;

import com.example.CDWSecurity.model.User;
import com.example.CDWSecurity.service.SanPhamService;
import com.example.CDWSecurity.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AjaxController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    UserService userService;
    // ajax search Home
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    @ResponseBody
    public List<String> searchAjax(@RequestParam(value = "term") String term){
        return sanPhamService.searchKey(term);
    }

    @RequestMapping("/searchUserData")
    @ResponseBody
    public List<User> searchUserByKey(@RequestParam(value = "key") String key){
        return userService.searchUserByKey(key);
    }
}
