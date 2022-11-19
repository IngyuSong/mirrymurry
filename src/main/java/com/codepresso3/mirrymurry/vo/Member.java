package com.codepresso3.mirrymurry.vo;

import com.codepresso3.mirrymurry.constant.Role;

public class Member {
    private Integer id;
    private String email;
    private String password;
    private String user_name;
    private Role role;
    private String address;
    private String phone_number;

    public Member(Integer id, String email, String password, String user_name, Role role, String address, String phone_number) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.user_name = user_name;
        this.role = role;
        this.address = address;
        this.phone_number = phone_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
