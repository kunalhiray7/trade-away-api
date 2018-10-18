package com.tw.codeavengers.tradeawayapi.security;

import java.util.Objects;

public class Token {
    private String name;
    private String userName;
    private String roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Token{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(name, token.name) &&
                Objects.equals(userName, token.userName) &&
                Objects.equals(roles, token.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userName, roles);
    }
}
