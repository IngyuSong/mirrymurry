package com.codepresso3.mirrymurry.controller;


import com.codepresso3.mirrymurry.controller.dto.MenuDto;
import com.codepresso3.mirrymurry.service.StoreService;
import com.codepresso3.mirrymurry.vo.BookMng;
import com.codepresso3.mirrymurry.vo.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/stores")
public class StoreController {

    private StoreService storeService;

    public StoreController(StoreService storeService){this.storeService=storeService;}

    @GetMapping("/storePage")//사업자 페이지
    public String getStorePage(){
        return "storePage";
    }

    @GetMapping("/bookMng/{id}")//사업자 페이지/ 예약 관리
    public String getBookMng(@PathVariable Integer id, Model model){
        List<BookMng> bookMngList = storeService.bookMngList(id);
        model.addAttribute("bookMngList", bookMngList);
        return "store/bookMng";
    }

    @GetMapping("/bookOk")//사업자 페이지/ 예약 관리/ 예약 승인
    @ResponseBody
    public String okBook(@RequestParam("book_id") Integer book_id){
        System.out.println(book_id);
        storeService.bookOk(book_id);
        return "book ok";
    }

    @GetMapping("/bookCancel")//사업자 페이지/ 예약 관리/ 예약 취소
    @ResponseBody
    public String cancelBook(@RequestParam("book_id") Integer book_id){
        System.out.println(book_id);
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
        return "store/addMenu";
    }

    @PostMapping("/updateMenu")//사업자 페이지/ 메뉴 수정
    @ResponseBody
    public String updateMenu(@RequestBody MenuDto menuDto){
        Menu menu = menuDto.getMenu();
        storeService.updateMenu(menu);
        return "update menu";
    }

    @GetMapping("/menuMng/{id}")//사업자 페이지/ 메뉴 관리
    public String menuMng(@PathVariable Integer id, Model model){
        List<Menu> menuList = storeService.menuList(id);
        model.addAttribute("menus", menuList);
        return "menuMng";
    }

}