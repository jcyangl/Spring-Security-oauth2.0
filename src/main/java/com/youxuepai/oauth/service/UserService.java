package com.youxuepai.oauth.service;

import com.youxuepai.oauth.model.UserInfo;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 实现 UserDetailsService
 *
 * @author yangle
 * @date 2020-06-15 14:06
 */
@Component
public class UserService implements UserDetailsService {

  private Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserInfoService userInfoService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("username is:" + username);

    UserInfo userInfo = userInfoService.getUserInfoByUsername(username);
    if (userInfo == null) {
      throw new UsernameNotFoundException("the user is not found");
    }
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    //此处可以根据自己的业务添加权限,这里就写死了
    authorities.add(new SimpleGrantedAuthority("admin"));
    return new org.springframework.security.core.userdetails.User(username, userInfo.getPassword(),
        authorities);
  }
}
