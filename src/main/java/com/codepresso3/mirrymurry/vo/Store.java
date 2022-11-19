package com.codepresso3.mirrymurry.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Store {
    Integer id;
    String info;
    Integer member_id;

    public Store(Integer id, String info, Integer member_id) {
        this.id = id;
        this.info = info;
        this.member_id = member_id;
    }
}
