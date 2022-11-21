package com.codepresso3.mirrymurry.controller;

import com.codepresso3.mirrymurry.dto.*;
import com.codepresso3.mirrymurry.service.MemberService;
import com.codepresso3.mirrymurry.vo.Member;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/members")
@Controller
public class MemberController {

    private MemberService memberService;
    private PasswordEncoder passwordEncoder;

    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/new")
    public String memberForm(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/newMemberForm";
    }

    @PostMapping(value = "/new")
    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "member/newMemberForm";
        }

        try {
            Member member = new Member(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "member/newMemberForm";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/store/new")
    public String storeForm(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "store/newStoreForm";
    }

    @PostMapping(value = "/store/new")
    public String newStore(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "store/newStoreForm";
        }

        try {
            Member member = new Member(memberFormDto, passwordEncoder);
            memberService.saveStore(member);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "store/newStoreForm";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String loginMember(){
        return "member/loginForm";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "member/loginForm";
    }

}
