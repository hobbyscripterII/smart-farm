package com.project.smartfarm.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.smartfarm.cmmn.Const;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyUserDetails implements UserDetails {
    private String id;
    private String pwd;
    private String authorization;
    private String name;
    private String regionCodes;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(Const.ROLE_PREFIX + authorization));
        return list;
    }

    @Override public String getUsername() {return id;}
    @Override public String getPassword() {return pwd;}
    @Override public boolean isAccountNonExpired() {return true;}
    @Override public boolean isAccountNonLocked() {return true;}
    @Override public boolean isCredentialsNonExpired() {return true;}
    @Override public boolean isEnabled() {return true;}
    public String getName() {return name;}
    public String getRegionCodes() {return regionCodes;}
}