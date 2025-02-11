package com.example.MovieReviewPlatform2.dto;


import com.example.MovieReviewPlatform2.entity.Role;
import lombok.Builder;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Value
@Builder
public class UserDto implements UserDetails {
    Integer id;
    String name;
    String username;
    String image;
    Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
