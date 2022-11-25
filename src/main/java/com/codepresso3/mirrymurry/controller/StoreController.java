package com.codepresso3.mirrymurry.controller;


import com.codepresso3.mirrymurry.controller.dto.MenuDto;
import com.codepresso3.mirrymurry.service.StoreService;
import com.codepresso3.mirrymurry.vo.BookMng;
import com.codepresso3.mirrymurry.vo.Menu;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/stores")
public class StoreController {

    private StoreService storeService;

    public StoreController(StoreService storeService){this.storeService=storeService;}

    @GetMapping("/storePage")//사업자 페이지
    public String getStorePage(){
        return "store/storePage";
    }

    @GetMapping("/bookMng/{id}")//사업자 페이지/ 예약 관리
    public String getBookMng(@PathVariable Integer id){
        return "store/bookMng";
    }

    @GetMapping("/bookDate/{id}")//사업자 페이지/ 예약 관리/ 예약 승인
    @ResponseBody
    public List<BookMng> bookList(@PathVariable Integer id, @RequestParam("bookDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String bookDate = formatDate.format(date);
        List<BookMng> bookMngList = storeService.bookMngList(id, bookDate);
        return bookMngList;
    }

    @GetMapping("/bookCancel")//사업자 페이지/ 예약 관리/ 예약 취소
    @ResponseBody
    public String cancelBook(@RequestParam("book_id") Integer book_id){
        storeService.bookCancel(book_id);
        return "book cancel";
    }

    @GetMapping("/addMenu/{id}")
    public String addMenuPage(@PathVariable Integer id, Model model){
        model.addAttribute("storeId", id);
        model.addAttribute("menuDto", new MenuDto());
        return "store/addMenu";
    }

    @PostMapping("/addMenu/{id}")//사업자 페이지/ 메뉴 추가
    public String addMenu(@PathVariable Integer id, @Valid MenuDto menuDto){
        Menu menu = new Menu(menuDto);
        menu.setMenu_store_id(id);
        storeService.addMenu(menu);
        return "store/addMenuAlert";
    }
    @GetMapping("/updateMenu/{menu_id}")
    public String updateMenuPage(@PathVariable Integer menu_id, Model model){
        System.out.println(menu_id);
        Menu menu = storeService.getMenu(menu_id);
        model.addAttribute("menuDto", menu);
        return "store/addMenu";
    }

    @PostMapping("/updateMenu/{menu_id}")//사업자 페이지/ 메뉴 수정
    public String updateMenu(@PathVariable Integer menu_id, @Valid MenuDto menuDto){
        Menu menu = new Menu(menuDto);
        menu.setMenu_id(menu_id);
        storeService.updateMenu(menu);
        return "store/updateMenuAlert";
    }

    @GetMapping("/menuMng/{id}")//사업자 페이지/ 메뉴 관리
    public String menuMng(@PathVariable Integer id, Model model){
        List<Menu> menuList = storeService.menuList(id);
        model.addAttribute("menuList", menuList);
        return "store/menuMng";
    }

}