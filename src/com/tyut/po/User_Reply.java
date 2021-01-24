package com.tyut.po;

public class User_Reply {
    private Integer id;
    private String content;
    private String username;
    private String time;


    public User_Reply() {
    }

    public User_Reply(Integer id, String content, String username, String time) {
        this.id = id;
        this.content = content;
        this.username = username;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "User_Reply{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
