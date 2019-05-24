package com.xiaomi.serverauth.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @ClassName: DomainUserDetailsService
 * @User: xiaomi
 * @Description: //TODO
 * @Time: 2019/5/24 0024 上午 10:41
 * @email: a1205938863@gmail.com
 */
public class DomainUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
