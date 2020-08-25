package com.example.CDWSecurity.controller;

import com.example.CDWSecurity.model.*;
import com.example.CDWSecurity.repository.*;
import com.example.CDWSecurity.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("Admin")
public class AdminController {
    SanPham sanPham;
    @Autowired
    DanhMucService danhMucService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    ImagesService imagesService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    ChiTietHDRepository chiTietHDRepository;
    @Autowired
    ThuongHieuService thuongHieuService;
    @Autowired
    ThuongHieuRepository thuongHieuRepository;
//        Controller Danh Muc
    @GetMapping("/quanlydm")
    public String showDanhMuc(Model model, HttpServletRequest request){
    request.getSession().setAttribute("listdm", null);
    return "redirect:/Admin/qldm/page/1";
    }

//        phan trang danh muc
    @GetMapping("/qldm/page/{pageNumber}")
    public String showEmployeePage(HttpServletRequest request,HttpSession session,
                                   @PathVariable int pageNumber, Model model) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("listdm");
        int pagesize = 4;
        List<DanhMuc> list =(List<DanhMuc>) danhMucService.findAllDanhMuc();
        System.out.println(list.size());
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pagesize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("listdm", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 4, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = "/Admin/qldm/page/";
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("categorys", pages);
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());
        return "Admin/admin-danhmuc";
    }

//     delete danh muc
    @GetMapping("/qldm/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        DanhMuc danhMuc = danhMucService.findById(id);
        danhMucService.deleteDanhMuc(danhMuc);
        return "redirect:/Admin/quanlydm";
    }

//    insert danh muc
    @PostMapping(value = "/InsertDanhMuc")
    public String insertDanhMuc(@ModelAttribute("insertDanhMuc") DanhMuc danhMuc) {
        danhMucService.insertDanhMuc(danhMuc);
        return "redirect:/Admin/quanlydm";
    }
    @RequestMapping(value = "/thbydmuc/{id}")
    public String thByDmuc(@PathVariable("id") long id ,HttpSession session , Model model){
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());
        session.setAttribute("thbydmuc",thuongHieuRepository.getthbydanhmuc(id));
        return "Admin/admin-thuonghieu";
    }

//    end controller danh muc

//    Controller San Pham
    @GetMapping("/quanlysp")
    public String quanlySP(Model model, HttpServletRequest request
        ,HttpSession session) {
    request.getSession().setAttribute("listsp", null);
    return "redirect:/Admin/qlsp/page/1";
    }

//        phan trang san pham
    @GetMapping("/Admin/quanlysp")
    public String quanlySP(Model model, HttpServletRequest request
            , RedirectAttributes redirect) {
        request.getSession().setAttribute("listsp", null);
        return "redirect:/Admin/qlsp/page/1";
    }

    //    phan trang
    @GetMapping("/qlsp/page/{pageNumber}")
    public String showEmployeePage(HttpServletRequest request,
                                   @PathVariable int pageNumber, Model model, HttpSession session) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("listsp");
        int pagesize = 5;
        List<SanPham> list =(List<SanPham>) sanPhamService.findAll();
        System.out.println(list.size());
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pagesize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("listsp", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = "/Admin/qlsp/page/";

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("product", pages);
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());

        return "Admin/admin-sanpham";
    }

    //    insert san pham
    @PostMapping(value = "/InsertSanPham")
    public String insertSanPham(@RequestParam("tensanpham")String tensanpham,
                                @RequestParam("giasanpham")String giasanpham,
                                @RequestParam("giamgia")String giamgia,
                                @RequestParam("motasanpham")String motasanpham,
                                @RequestParam("soluong")String soluong,
                                @RequestParam("id_danhmuc")Long id_danhmuc,
                                @RequestParam("id_thuonghieu") Long id_thuonghieu,
                                @RequestParam("hinhsanpham") MultipartFile[] files , Model model) {
        Calendar calendar = Calendar.getInstance();
        ThuongHieu thuongHieu = thuongHieuService.findById(id_thuonghieu);
        SanPham sp = new SanPham(tensanpham,Float.parseFloat(giasanpham),Float.parseFloat(giamgia),
            motasanpham,calendar.getTime(),Float.parseFloat(soluong),thuongHieu);
        sanPhamService.insertSp(sp);

        Long idSpMax = sanPhamService.maxId();
        try {
            for (MultipartFile file : files) {
                byte[] bytes = file.getBytes();
                String rootPath = "D:\\ChuyenDeWeb_2020\\CDWSecurity\\CDWSecurity\\src\\main\\resources\\static";
                File dir = new File(rootPath + File.separator + "images");
                String name = file.getOriginalFilename();
                if (!dir.exists())
                    dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                SanPham s = sanPhamService.findById(idSpMax);
                Images images = new Images(name,idSpMax);
                imagesService.insertImages(images);
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return "redirect:/Admin/quanlysp";
    }

//    delete san pham
    @GetMapping("/qlsp/{id}/delete")
    public String deleteSp(@PathVariable("id") long id) {
        SanPham emp = sanPhamService.findById(id);
        sanPhamService.delete(emp);

        return "redirect:/Admin/quanlysp";
    }

//    list san pham theo dnah muc
    @RequestMapping("/listSpByTH/{id}")
    public String listSpByDmuc(@PathVariable("id")long id,Model model){
        ThuongHieu thuongHieu = thuongHieuService.findById(id);
        List<SanPham> list = thuongHieu.getSanPhamList();
        model.addAttribute("listspbyth",list);
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());
        return "Admin/admin-sanphambythuonghieu";
    }
//    chi tiet san pham
    @RequestMapping("/chitietsanpham/{id}")
    public String chiTietSp(@PathVariable("id") long id , Model model){
        SanPham sanPham = sanPhamService.findById(id);
        model.addAttribute("chitietsp",sanPham);
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());
        return  "Admin/admin-detail-product";
    }
    // update sp
    @RequestMapping(value = "/chitietsanpham/update/{id}",method = RequestMethod.POST)
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
//    end controller san pham

//    Controller User
    @GetMapping("/quanlyuser")
    public String quanlyUser(Model model, HttpServletRequest request
            , RedirectAttributes redirect) {
        request.getSession().setAttribute("listUser", null);
        return "redirect:/Admin/qluser/page/1";
    }

    //        phan trang user
    @GetMapping("/qluser/page/{pageNumber}")
    public String showUserPage(HttpServletRequest request,
                                   @PathVariable int pageNumber, Model model, HttpSession session) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("listUser");
        int pagesize = 5;
        List<User> list = userRepository.findAll();
        System.out.println(list.size());
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pagesize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("listuser", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = "/Admin/qluser/page/";

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("listuser", pages);
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());
        return "Admin/admin-user";
    }
    //    delete user
    @GetMapping("/qluser/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        User user= userService.findById(id);
        userService.delete(user);

        return "redirect:/Admin/quanlyuser";
    }
    // Set Role User
    @GetMapping("/qluser/{id}/setadmin")
    public String setAdmin(@PathVariable("id") long id){
        User user = userService.findById(id);
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_ADMIN"));
        user.setRoles(roles);
        userRepository.save(user);
        return "redirect:/Admin/quanlyuser";
    }
    @GetMapping("/qluser/{id}/setuser")
    public String setMember(@PathVariable("id") long id){
        User user = userService.findById(id);
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_MEMBER"));
        user.setRoles(roles);
        userRepository.save(user);
        return "redirect:/Admin/quanlyuser";
    }
    //        phan trang user
    @GetMapping("/qlhd/page/{pageNumber}")
    public String showHDPage(HttpServletRequest request,
                             @PathVariable int pageNumber, Model model, HttpSession session) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("listHD");
        int pagesize = 5;
        List<User> list = userRepository.findAll();
        System.out.println(list.size());
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pagesize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("listHD", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = "/Admin/qlhd/page/";

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("listHD", pages);
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());
        return "Admin/admin-hoadon";
    }

    //    end controller user

    //    controller hoa don
    @RequestMapping(value = "/quanlyhoadon")
    public String showHoaDon(Model model){
        List<HoaDon> hoaDonList = hoaDonService.getAll();
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());
        model.addAttribute("listHoadon",hoaDonList);
            return "Admin/admin-hoadon";
    }
    @RequestMapping(value = "/chitiethoadon/{id}")
    public String showChitetHD(@PathVariable("id")long id, Model model){
        HoaDon hoaDon = hoaDonService.findById(id);
        List<ChiTietHoaDon> chiTietHoaDons = hoaDon.getChiTietHoaDons();
        model.addAttribute("listdanhmuc",danhMucService.findAllDanhMuc());
        model.addAttribute("chitiethoadon",chiTietHoaDons);
        return "Admin/admin-detail-hoadon";
    }


}
