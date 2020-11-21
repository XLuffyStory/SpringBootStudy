package com.app.model;

import java.io.Serializable;

public class ReqUser implements Serializable {

    private static final long serialVersionUID = -7437439647984889553L;
    private String username;
    private String password;

    public ReqUser() {
    }

    public ReqUser(String username, String password) {
	this.username = username;
	this.password = password;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}
