package com.tyut.po;

public class Message {
    private Integer mid;
    private String title;
    private String content;
    private Integer uid;
    private String url;

    public Message() {
    }

    public Message(Integer mid, String title, String content, Integer uid, String url) {
        this.mid = mid;
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.url = url;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", uid=" + uid +
                ", url='" + url + '\'' +
                '}';
    }
}
