package com.tyut.po;

public class Message_User {
    private Integer id;
    private String title;
    private String number;
    private String username;
    private String content;
    private String mid;

    public Message_User(Integer id, String title, String number, String username, String content, String mid) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.username = username;
        this.content = content;
        this.mid = mid;
    }

    public Message_User() {
    }

    public Message_User(Integer id, String title, String number, String username) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.username = username;
    }

    public Message_User(Integer id, String title, String number, String username, String content) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.username = username;
        this.content = content;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUsername(String username) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message_User{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", number='" + number + '\'' +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
