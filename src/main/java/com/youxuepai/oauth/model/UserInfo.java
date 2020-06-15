package com.youxuepai.oauth.model;

import com.alibaba.fastjson.JSONObject;

/**
 * 用户信息
 *
 * @author yangle
 * @date 2020-06-15 14:13
 */
public class UserInfo {

  /**
   * id
   */
  private Integer id;

  /**
   * 用户名
   */
  private String username;

  /**
   * 密码
   */
  private String password;

  /**
   * 状态 0-正常 1-冻结
   */
  private Integer status;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return JSONObject.toJSONString(this);
  }
}
