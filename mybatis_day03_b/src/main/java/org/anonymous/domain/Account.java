package org.anonymous.domain;

/**
 * @author child
 * 2019/4/11 20:48
 */
public class Account {
    private Integer id;
    private Integer uid; //外键
    private Integer money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
