package com.tyut.po;

public class Reply {
    private Integer rid;
    private String content;
    private Integer uid;
    private Integer mid;
    private String time;

    public Reply() {
    }

    public Reply(Integer rid, String content, Integer uid, Integer mid, String time) {
        this.rid = rid;
        this.content = content;
        this.uid = uid;
        this.mid = mid;
        this.time = time;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", content='" + content + '\'' +
                ", uid=" + uid +
                ", mid=" + mid +
                ", time='" + time + '\'' +
                '}';
    }
}
