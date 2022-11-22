package com.codepresso3.mirrymurry.vo;

import com.codepresso3.mirrymurry.constant.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {
    private Integer member_id;
    private String email;
    private String password;
    private String user_name;
    private Role role;
    private String address;
    private String phone_number;

    public Member(Integer member_id, String email, String password, String user_name, Role role, String address, String phone_number) {
        this.member_id = member_id;
        this.email = email;
        this.password = password;
        this.user_name = user_name;
        this.role = role;
        this.address = address;
        this.phone_number = phone_number;
    }

}
