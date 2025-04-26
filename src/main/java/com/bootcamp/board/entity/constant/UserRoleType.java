package com.bootcamp.board.entity.constant;

import lombok.Getter;

@Getter
public enum UserRoleType {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String roleType;

    UserRoleType(String roleType) {
        this.roleType = roleType;
    }

}
