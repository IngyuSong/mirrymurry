package com.codepresso3.mirrymurry.vo;

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
}
