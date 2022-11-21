package com.codepresso3.mirrymurry.service;

import com.codepresso3.mirrymurry.constant.Role;
import com.codepresso3.mirrymurry.mapper.MemberMapper;
import com.codepresso3.mirrymurry.vo.Member;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements UserDetailsService {

    private MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberMapper.findByEmail(email);

        if(member == null){
            throw new UsernameNotFoundException(email);
        }

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }

    public boolean saveMember(Member member){
        validateDuplicateMember(member);
        member.setRole(Role.USER);
        Integer result = memberMapper.createMember(member);
        return result==1;
    }

    public boolean saveStore(Member member){
        validateDuplicateMember(member);
        member.setRole(Role.STORE);
        Integer result = memberMapper.createMember(member);
        return result==1;
    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberMapper.findByEmail(member.getEmail());
        Member findMember1 = memberMapper.findByPhoneNumber(member.getPhone_number());
        if(findMember != null){
            throw new IllegalStateException("해당 이메일은 이미 사용중입니다.");
        }
        if(findMember1 != null){
            throw new IllegalStateException("입력하신 전화번호는 이미 가입되어 있습니다.");
        }
    }

}
