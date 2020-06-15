package com.youxuepai.oauth.service.impl;

import com.youxuepai.oauth.mapper.UserInfoMapper;
import com.youxuepai.oauth.model.UserInfo;
import com.youxuepai.oauth.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息
 *
 * @author yangle
 * @date 2020-06-15 14:37
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  UserInfoMapper userInfoMapper;

  @Override
  public UserInfo getUserInfoByUsername(String username) {
    return userInfoMapper.getUserInfoByUsername(username);
  }
}
