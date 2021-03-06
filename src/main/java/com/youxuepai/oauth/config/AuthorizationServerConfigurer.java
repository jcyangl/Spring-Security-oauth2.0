package com.youxuepai.oauth.config;


import com.youxuepai.oauth.service.UserService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * OAuth2 配置文件
 *
 * @author yangle
 * @date 2020-06-15 14:44
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

  @Autowired
  public PasswordEncoder passwordEncoder;

  @Autowired
  public UserService userService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private DataSource dataSource;

  @Autowired
  private TokenStore jwtTokenStore;

  @Autowired
  private JwtAccessTokenConverter jwtAccessTokenConverter;

  @Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
        //token存储方式
        .tokenStore(jwtTokenStore)
        //token转换方式使用jwt
        .accessTokenConverter(jwtAccessTokenConverter)
        //用户验证
        .userDetailsService(userService)
        //支持password模式
        .authenticationManager(authenticationManager);
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    //定义客户端约束条件，这里采用数据库方式配置
    JdbcClientDetailsServiceBuilder jdbc = clients.jdbc(dataSource);
    //指定加密方式
    jdbc.passwordEncoder(passwordEncoder);
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    //允许客户端访问 OAuth2.0 授权接口
    security.allowFormAuthenticationForClients();
    //允许已授权用户访问 checkToken 接口
    security.checkTokenAccess("isAuthenticated()");
    //允许已授权用户访问 获取 token 接口
    security.tokenKeyAccess("isAuthenticated()");
  }
}
