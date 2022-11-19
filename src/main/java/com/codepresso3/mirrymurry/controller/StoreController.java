package com.codepresso3.mirrymurry.controller;

import com.codepresso3.mirrymurry.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    private StoreService storeService;

    public StoreService StoreController(StoreService storeService){return this.storeService=storeService;}

    @GetMapping("/storePage")
    public String getStorePage(){
        return "storePage";
    }

    @GetMapping("/bookMng")
    public String getBookMng(){
        return "bookMng";
    }

}
