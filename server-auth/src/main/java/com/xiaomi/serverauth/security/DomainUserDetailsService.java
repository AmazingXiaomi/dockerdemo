package com.xiaomi.serverauth.security;

import com.xiaomi.serverauth.domain.SystemUser;
import com.xiaomi.serverauth.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName: DomainUserDetailsService
 * @User: xiaomi
 * @Description: //TODO
 * @Time: 2019/5/24 0024 上午 10:41
 * @email: a1205938863@gmail.com
 */
@Service
public class DomainUserDetailsService implements UserDetailsService {
    @Autowired
    private SystemUserService systemUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SystemUser> userFromDatabase = systemUserService.findOneWithAuthoritiesByLogin(username);//通过账号查询
        return userFromDatabase.map(user -> {
            List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getRole()))//role化。。。把role交由Authorition
                    .collect( Collectors.toList());
            return new org.springframework.security.core.userdetails.User(username,
                    user.getPassword(),
                    grantedAuthorities);//返回一个 authorization封装的（账号，密码，角色） 对象
        }).orElseThrow(() -> new UsernameNotFoundException("User " + username + " was not found in the " +
                "database"));//数据库不存在此账号
    }
}
