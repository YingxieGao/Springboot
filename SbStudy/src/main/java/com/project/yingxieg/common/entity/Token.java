package com.project.yingxieg.common.entity;


public class Token {

  private long userId;
  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private String userToken;
  private long expireTime;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserToken() {
    return userToken;
  }

  public void setUserToken(String userToken) {
    this.userToken = userToken;
  }


  public long getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(long expireTime) {
    this.expireTime = expireTime;
  }

}
