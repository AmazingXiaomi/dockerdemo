package com.xiaomi.serverauth.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class SystemUser implements Serializable {
    private String id;

    private String username;

    private String password;

    private String email;

    /**
	* 账号是否激活
	*/
    private Boolean activated;

    private String createDate;
    /**
	* 账号重置/修改日期
	*/
    private String resetDate;

    private static final long serialVersionUID = 1L;

    private Set<UserRole> authorities = new HashSet<UserRole>();
    //dto
    private String oldPassword;

}