package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRole;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityUser extends User{
    private static final String ROLE_PREFIX = "ROLE_";

    private Member member;

    public SecurityUser(Member member){
            super(member.getUid(), member.getUpw(), makeGrantedAuthority(member.getRoles()));
            this.member = member;
        }

    private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
        List<GrantedAuthority> list = new ArrayList<>();

        roles.forEach(
            role -> list.add(
                new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())
            )
        );
        return list;
    }
}