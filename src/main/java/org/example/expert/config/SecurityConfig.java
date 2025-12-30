package org.example.expert.config;

import lombok.Getter;
import org.example.expert.domain.user.enums.UserRole;

@Getter
public class SecurityConfig {

    private Long userId;
    private String email;
    private String nickname;
    private UserRole userRole;

    public SecurityConfig(Long userId, String email, String nickName, UserRole userRole) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickName;
        this.userRole = userRole;
    }
}

