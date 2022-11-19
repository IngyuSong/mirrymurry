package com.codepresso3.mirrymurry.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookMng {
    Integer member_id;
    String email;
    String username;
    String phone_number;
    Integer book_state;

    public BookMng(Integer member_id, String email, String username, String phone_number, Integer book_state) {
        this.member_id = member_id;
        this.email = email;
        this.username = username;
        this.phone_number = phone_number;
        this.book_state = book_state;
    }
}
