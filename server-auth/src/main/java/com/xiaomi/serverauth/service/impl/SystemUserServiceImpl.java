package com.xiaomi.serverauth.service.impl;

import com.google.common.collect.Sets;
import com.xiaomi.serverauth.domain.SystemUser;
import com.xiaomi.serverauth.domain.UserRole;
import com.xiaomi.serverauth.mapper.SystemUserMapper;
import com.xiaomi.serverauth.mapper.UserRoleMapper;
import com.xiaomi.serverauth.service.SystemUserService;
import com.xiaomi.serverauth.utils.AuthoritiesConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * @ClassName: SystemUserServiceImpl
 * @User: xiaomi
 * @Description: //TODO
 * @Time: 2019/5/24 0024 上午 10:51
 * @email: a1205938863@gmail.com
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    private static final String ORIGINALPASSWORD = "111111";
    @Autowired
    private SystemUserMapper systemUserDao;
    @Autowired
    private UserRoleMapper userRoleDao;

    @Override
    public Optional<SystemUser> findOneWithAuthoritiesByLogin(String name) {
        SystemUser user = systemUserDao.findSystenUserByname(name);
        if (user != null) {
            UserRole authority = userRoleDao.getUserRoleById(user.getId());
            if (authority != null) {
                Set set = Sets.newHashSet();
                set.add(authority);
                if (authority.getRole().equals( AuthoritiesConstants.ADMIN.trim())) {
                    set.add(new UserRole(null, null, AuthoritiesConstants.USER));
                    set.add(new UserRole(null, null, AuthoritiesConstants.ANONYMOUS));
                } else if (authority.getRole().equals(AuthoritiesConstants.USER.trim())) {
                    set.add(new UserRole(null, null, AuthoritiesConstants.ANONYMOUS));
                }
                user.setAuthorities(set);
            }
        }
        return Optional.ofNullable(user);
    }
}
