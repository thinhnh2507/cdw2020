package com.example.CDWSecurity.controller;

import com.example.CDWSecurity.model.ChiTietHoaDon;
import com.example.CDWSecurity.model.HoaDon;
import com.example.CDWSecurity.model.Cart;
import com.example.CDWSecurity.repository.DanhMucRepository;
import com.example.CDWSecurity.repository.SanPhamRepository;
import com.example.CDWSecurity.repository.UserRepository;
import com.example.CDWSecurity.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DanhMucRepository danhMucRepository;
    @Autowired
    DanhMucService danhMucService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    ImagesService imagesService;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    ChiTietHdService chiTietHdService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            com.example.CDWSecurity.model.User user = userRepository.findByUsername(((UserDetails) principal).getUsername());
            session.setAttribute("user",user);
        }
        model.addAttribute("listDanhMuc",danhMucService.findAllDanhMuc());
        return "Home/cart";
    }
    @RequestMapping(value = "addCart/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            List<Cart> cart = new ArrayList<Cart>();
            cart.add(new Cart(sanPhamService.findById(id), 1));
            session.setAttribute("total",totalPrice(cart));
            session.setAttribute("cart", cart);
        } else {
            List<Cart> cart = (List<Cart>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Cart(sanPhamService.findById(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("total",totalPrice(cart));
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart/index";
    }
////    add cart rest api
//    @RequestMapping(value = "addCartAjax/{id}",method = RequestMethod.GET)
//    public ResponseEntity<Cart> addCartAjax(@PathVariable("id") long id ,HttpSession session){
//        if (session.getAttribute("cart") == null) {
//            List<Cart> cart = new ArrayList<Cart>();
//            cart.add(new Cart(sanPhamService.findById(id), 1));
//            session.setAttribute("total",totalPrice(cart));
//            session.setAttribute("cart", cart);
//        } else {
//            List<Cart> cart = (List<Cart>) session.getAttribute("cart");
//            int index = this.exists(id, cart);
//            if (index == -1) {
//                cart.add(new Cart(sanPhamService.findById(id), 1));
//            } else {
//                int quantity = cart.get(index).getQuantity() + 1;
//                cart.get(index).setQuantity(quantity);
//            }
//        }
//        return new ResponseEntity<>();
//    }

    @RequestMapping(value = "removeCart/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") Long id, HttpSession session) {
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("total",totalPrice(cart));
        session.setAttribute("cart", cart);
        return "redirect:/cart/index";
    }

    private int exists(Long id, List<Cart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getSanPham().getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    private float totalPrice(List<Cart> carts){
        float total= 0;
        for(Cart cart :carts){
            total += cart.getQuantity() * cart.getSanPham().getGiasanpham();
        }
        return total;
    }
    @RequestMapping(value = "thanhtoan",method = RequestMethod.GET)
    public String thanhtoan(HttpSession session){
        User userSecurity = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        com.example.CDWSecurity.model.User user= userRepository.findByUsername(userSecurity.getUsername());
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId_user(user.getId());
        hoaDon.setDiachi(user.getDiachi());
        hoaDon.setSdt(user.getSdt());
        hoaDon.setUsername(user.getUsername());
        float tongtien =0 ;
        for(Cart item :cart){
            tongtien += ((item.getSanPham().getGiasanpham())*item.getQuantity());
        }
        hoaDon.setTongtien(tongtien);
        hoaDonService.create(hoaDon);
        long idhd = hoaDonService.maxId();

        for(Cart item : cart){
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.setId_hoadon(idhd);
            chiTietHoaDon.setId_sanpham(item.getSanPham().getId());
            chiTietHoaDon.setSoluong(item.getQuantity());
            chiTietHoaDon.setGiaban((item.getSanPham().getGiasanpham())*item.getQuantity());
            chiTietHdService.create(chiTietHoaDon);
        }
        session.removeAttribute("cart");
        session.removeAttribute("total");
        return "redirect:/";
    }
}
