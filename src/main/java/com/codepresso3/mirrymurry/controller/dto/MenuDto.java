package com.codepresso3.mirrymurry.controller.dto;

import com.codepresso3.mirrymurry.vo.Menu;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuDto {
    Integer id;
    Integer price;
    String menu_name;
    String menu_info;
    Integer menu_store_id;

    public Menu getMenu(){
        return new Menu(this.id, this.price, this.menu_name, this.menu_info, this.menu_store_id);
    }
}
