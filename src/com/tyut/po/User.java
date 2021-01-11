package com.tyut.po;

public class User {
    private Integer uid;
    private String username;
    private String password;
    private String sex;
    private String hobby;
    private String address;
    private String introduce;
    private int userType; //0是普通用户 1是管理员
    private int  status; //0是正常 1是被禁言
    private String createTime;

    public User() {
    }

    public User(Integer uid, String username, String password, String sex, String hobby, String address, String introduce, int userType, int status, String createTime) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.hobby = hobby;
        this.address = address;
        this.introduce = introduce;
        this.userType = userType;
        this.status = status;
        this.createTime = createTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", address='" + address + '\'' +
                ", introduce='" + introduce + '\'' +
                ", userType=" + userType +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
