package com.xiaomi.serverauth.service;

import com.xiaomi.serverauth.domain.SystemUser;
import java.util.Optional;

public interface SystemUserService {
    Optional<SystemUser> findOneWithAuthoritiesByLogin(String name);
}
