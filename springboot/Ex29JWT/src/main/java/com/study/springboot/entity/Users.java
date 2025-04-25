package com.study.springboot.entity;

import com.study.springboot.enumeration.UserRole;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users_jwt")
@Getter
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(unique = true) // email 은 중복되지 않아야 하기 때문에 uniquer 하도록 설정
    private String email;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public Users() {
    }

    @Builder
    public Users(String email, String password, UserRole userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //계정의 권한 목록을 리턴함.
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(userRole.getValue()));
        return roles;
    }

    @Override
    public String getUsername() {
        return this.email; //계정의 고유한 아이디 리턴
    }

    @Override
    public String getPassword() {
        return this.password; //계정의 암호 리턴
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //계정의 만료 여부 리턴 - true는 사용가능하다는 의미
    }
    @Override
    public boolean isAccountNonLocked() {
        return true; //계정의 잠김 여부 리턴
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return  true; //비밀번호 만료 여부 리턴
    }
    @Override
    public boolean isEnabled() {
        return true; //계정의 활성화 여부 리턴
    }
}
