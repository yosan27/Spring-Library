package com.Faraday.Library.dto;

import java.util.Set;

public class JwtResponse {
    private String token;
    private String userCode;
    private String username;
    private String email;
    private Set<String> roles;
    private String type = "Bearer";

    public JwtResponse() {
    }

    public JwtResponse(String token, String userCode, String username, String email, Set<String> roles) {
        this.token = token;
        this.userCode = userCode;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
