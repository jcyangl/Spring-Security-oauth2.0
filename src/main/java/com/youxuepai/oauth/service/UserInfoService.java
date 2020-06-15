package com.youxuepai.oauth.service;

import com.youxuepai.oauth.model.UserInfo;

/**
 * 用户信息
 *
 * @author yangle
 * @date 2020-06-15 14:36
 */
public interface UserInfoService {

  /**
   * 通过用户名查询用户信息
   *
   * @param username 用户名称
   * @return userInfo 用户信息
   */
  UserInfo getUserInfoByUsername(String username);
}
