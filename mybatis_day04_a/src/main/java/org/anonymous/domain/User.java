package org.anonymous.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author child
 * 2019/4/11 20:48
 * 用户-账户: 一对多
 * 用户-角色: 多对多
 * //实现序列化接口,以供实现二级缓存
 * 只开启二级缓存,而不实现序列化接口,就会报exception:org.apache.ibatis.cache.CacheException: Error serializing object.  Cause: java.io.NotSerializableException: org.anonymous.domain.User
 */
public class User implements Serializable {
//    private static final long serialVersionUID = -6787529017731088768L;
    private Integer id;
    private String username;
    private String sex;
    private String birthday;
    private String address;

    private List<Account> accounts; //账户集合: 在 一的一方(User) 有多的一方(Account)的 集合
//    private List<Role> roles; //角色集合

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
