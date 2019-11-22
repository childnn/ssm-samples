package org.anonymous.domain;

import java.util.List;

/**
 * @author child
 * 2019/4/11 20:48
 * 用户-账户: 一对多
 * 用户-角色: 多对多
 */
public class User {
    private Integer id;
    private String username;
    private String sex;
    private String birthday;
    private String address;

    private List<Account> accounts; //账户集合
    private List<Role> roles; //角色集合

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                ", roles=" + roles +
                '}';
    }
}
