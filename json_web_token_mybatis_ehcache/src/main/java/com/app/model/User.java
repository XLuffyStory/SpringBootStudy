package com.app.model;

import java.util.concurrent.atomic.AtomicLong;

public class User {
    private static final AtomicLong ID_GEN = new AtomicLong();

    private long id;

    private String username;

    private String password;

    public User() {
    }

    public User(String name, String password) {
	this.id = ID_GEN.incrementAndGet();
	this.username = name;
	this.password = password;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
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

    @Override
    public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
