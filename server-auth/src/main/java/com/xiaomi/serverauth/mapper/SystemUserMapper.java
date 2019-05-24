package com.xiaomi.serverauth.mapper;

import com.xiaomi.serverauth.domain.SystemUser;

public interface SystemUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

    SystemUser findSystenUserByname(String name);
}