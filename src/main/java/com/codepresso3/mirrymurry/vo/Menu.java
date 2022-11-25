package com.codepresso3.mirrymurry.vo;

import com.codepresso3.mirrymurry.controller.dto.MenuDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Menu {
    Integer menu_id;
    Integer price;
    String menu_name;
    String menu_info;
    Integer menu_store_id;

    public Menu(Integer menu_id, Integer price, String menu_name, String menu_info, Integer menu_store_id) {
        this.menu_id = menu_id;
        this.price = price;
        this.menu_name = menu_name;
        this.menu_info = menu_info;
        this.menu_store_id = menu_store_id;
    }

    public Menu(MenuDto menuDto){
        this.menu_id = menuDto.getId();
        this.price = menuDto.getPrice();
        this.menu_name = menuDto.getMenu_name();
        this.menu_info = menuDto.getMenu_info();
        this.menu_store_id = menuDto.getMenu_store_id();
    }
}
