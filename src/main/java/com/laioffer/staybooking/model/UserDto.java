package com.laioffer.staybooking.model;


public record UserDto(
        Long id,
        String username,
        UserRole role
) { //第二构造函数-调用第一个构造函数，直接用user entity初始化
    public UserDto(UserEntity entity) {
        this(
                entity.getId(),
                entity.getUsername(),
                entity.getRole()
        );
    }
}

