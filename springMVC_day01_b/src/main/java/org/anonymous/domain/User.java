package org.anonymous.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author child
 * 2019/4/19 20:54
 * 对象的简单数据: 必须要有 set 方法,页面的数据才能赋值成功
 * 对象的 list 集合属性: 必须要有 集合属性的 get 方法
 */
public class User {
    private String username;
    private String password;
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    private List<Account> accounts;

    private Map<String, Account> maps;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() { //没有 get 方法: accounts 值就赋值不了
        return accounts;
    }

    public Map<String, Account> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Account> maps) {
        this.maps = maps;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", accounts=" + accounts +
                ", maps=" + maps +
                '}';
    }
}
