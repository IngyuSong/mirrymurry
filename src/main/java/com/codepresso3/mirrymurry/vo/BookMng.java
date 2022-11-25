package com.codepresso3.mirrymurry.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class BookMng {
    Integer member_id;
    String email;
    String user_name;
    String phone_number;

    Integer book_id;

    String bookDate;

    public BookMng(Integer member_id, String email, String user_name, String phone_number, Integer book_id, String bookDate) {
        this.member_id = member_id;
        this.email = email;
        this.user_name = user_name;
        this.phone_number = phone_number;
        this.book_id = book_id;
        this.bookDate = bookDate;
    }




}
