package com.share.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UsersStation {
    private Long id;

    private String userName;

    private String userPassword;

    private String userRole;

    private Date userLoginTime;

    private Date userRegistTime;

    private String userStatus;

    private Date userForbiddenTime;

    private BigDecimal userMoney;

    private Date userVipLostTime;

    private Date userVipInitTime;

    private Boolean userVipValid;

    private Integer userPhoneNumber;

    private String userEmail;

    private String userAddress;

    private Integer userPoints;

    private String userPasswordQuestion;

    private String userPasswordAnswer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public Date getUserLoginTime() {
        return userLoginTime;
    }

    public void setUserLoginTime(Date userLoginTime) {
        this.userLoginTime = userLoginTime;
    }

    public Date getUserRegistTime() {
        return userRegistTime;
    }

    public void setUserRegistTime(Date userRegistTime) {
        this.userRegistTime = userRegistTime;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public Date getUserForbiddenTime() {
        return userForbiddenTime;
    }

    public void setUserForbiddenTime(Date userForbiddenTime) {
        this.userForbiddenTime = userForbiddenTime;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public Date getUserVipLostTime() {
        return userVipLostTime;
    }

    public void setUserVipLostTime(Date userVipLostTime) {
        this.userVipLostTime = userVipLostTime;
    }

    public Date getUserVipInitTime() {
        return userVipInitTime;
    }

    public void setUserVipInitTime(Date userVipInitTime) {
        this.userVipInitTime = userVipInitTime;
    }

    public Boolean getUserVipValid() {
        return userVipValid;
    }

    public void setUserVipValid(Boolean userVipValid) {
        this.userVipValid = userVipValid;
    }

    public Integer getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(Integer userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public Integer getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(Integer userPoints) {
        this.userPoints = userPoints;
    }

    public String getUserPasswordQuestion() {
        return userPasswordQuestion;
    }

    public void setUserPasswordQuestion(String userPasswordQuestion) {
        this.userPasswordQuestion = userPasswordQuestion == null ? null : userPasswordQuestion.trim();
    }

    public String getUserPasswordAnswer() {
        return userPasswordAnswer;
    }

    public void setUserPasswordAnswer(String userPasswordAnswer) {
        this.userPasswordAnswer = userPasswordAnswer == null ? null : userPasswordAnswer.trim();
    }
}