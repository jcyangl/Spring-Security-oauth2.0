package com.youxuepai.oauth.mapper;

import com.youxuepai.oauth.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息
 *
 * @author yangle
 * @date 2020-06-15 14:17
 */
public interface UserInfoMapper {

  /**
   * 通过用户名查询用户信息
   *
   * @param username 用户名称
   * @return userInfo 用户信息
   */
  UserInfo getUserInfoByUsername(@Param("username") String username);
}
