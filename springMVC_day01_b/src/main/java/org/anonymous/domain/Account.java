package org.anonymous.domain;

/**
 * @author child
 * 2019/4/19 21:38
 */
public class Account {
    private String name;
    private Double money;

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
