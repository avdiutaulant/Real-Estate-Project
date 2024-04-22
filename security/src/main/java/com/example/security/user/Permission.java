package com.example.security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_PATCH("admin:patch"),

    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_CREATE("user:create"),
    USER_DELETE("user:delete"),
    USER_PATCH("user:patch"),

    AGENT_READ("agent:read"),
    AGENT_UPDATE("agent:update"),
    AGENT_CREATE("agent:create"),
    AGENT_DELETE("agent:delete"),
    AGENT_PATCH("agent:patch"),
    ;
    private final String permission;
}
