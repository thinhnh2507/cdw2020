package com.example.CDWSecurity.controller;

import com.example.CDWSecurity.model.*;
import com.example.CDWSecurity.repository.DanhMucRepository;
import com.example.CDWSecurity.repository.HoaDonRepository;
import com.example.CDWSecurity.repository.SanPhamRepository;
import com.example.CDWSecurity.repository.ThuongHieuRepository;
import com.example.CDWSecurity.service.DanhMucService;
import com.example.CDWSecurity.service.ImagesService;
import com.example.CDWSecurity.service.SanPhamService;
import com.example.CDWSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class AjaxController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    UserService userService;
    @Autowired
    ThuongHieuRepository thuongHieuRepository;
    @Autowired
    DanhMucService danhMucService;
    @Autowired
    ImagesService imagesService;
    @Autowired
    HoaDonRepository hoaDonRepository;
    // api search Home
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    @ResponseBody
    public List<String> searchAjax(@RequestParam(value = "term") String key){
        return sanPhamService.searchKey(key);
    }

    // api list thuong hieu by danh muc
    @RequestMapping(value = "/listthbydanhmuc/{id_danhmuc}",method = RequestMethod.GET)
    public @ResponseBody List<ThuongHieu> listthbydanhmuc(@PathVariable("id_danhmuc") long iddanhmuc){
        return thuongHieuRepository.getthbydanhmuc(iddanhmuc);
    }

    @RequestMapping(value = "/chitietsanphamajax/update/{id}",method = RequestMethod.POST)
    public @ResponseBody SanPham updateSanPham(@PathVariable("id") long id,
                                               @RequestParam("tensanpham")String tensanpham,
                                               @RequestParam("giasanpham")float giasanpham,
                                               @RequestParam("giamgia")float giamgia,
                                               @RequestParam("motasanpham")String motasanpham,
                                               @RequestParam("soluong")float soluong,
                                               Model model){

        SanPham sanPham = sanPhamService.findById(id);
        sanPham.setTensanpham(tensanpham);
        sanPham.setGiasanpham(giasanpham);
        sanPham.setGiamgia(giamgia);
        sanPham.setMotasanpham(motasanpham);
        sanPham.setSoluong(soluong);
        sanPhamRepository.save(sanPham);
        model.addAttribute("chitietsp",sanPham);
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());
        return  sanPham;
    }
    @RequestMapping(value = "/chitietsanpham2/update/{id}",method = RequestMethod.POST)
    public  String updateSanPham2(@PathVariable("id") long id,
                                                @RequestParam("tensanpham")String tensanpham,
                                                @RequestParam("giasanpham")float giasanpham,
                                                @RequestParam("giamgia")float giamgia,
                                                @RequestParam("motasanpham")String motasanpham,
                                                @RequestParam("soluong")float soluong,
                                                Model model){

        SanPham sanPham = sanPhamService.findById(id);
        sanPham.setTensanpham(tensanpham);
        sanPham.setGiasanpham(giasanpham);
        sanPham.setGiamgia(giamgia);
        sanPham.setMotasanpham(motasanpham);
        sanPham.setSoluong(soluong);

        sanPhamRepository.save(sanPham);
        model.addAttribute("chitietsp",sanPham);
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());
        return  "Admin/admin-detail-product";
    }


}
