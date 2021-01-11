package com.tyut.po;

public class Message_User {
    private Integer id;
    private String title;
    private String number;
    private String username;

    public Message_User() {
    }

    public Message_User(Integer id, String title, String number, String username) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNumber() {
        return number;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Message_User{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", number='" + number + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
