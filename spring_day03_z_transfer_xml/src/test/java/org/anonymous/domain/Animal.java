package org.anonymous.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author child
 * 2019/4/24 18:46
 * 设置单例对象: 依赖与多例对象: user
 */
public class Animal {

    @Autowired
    @Qualifier("user")
    private User user;
    private static int i = 1;

    public void setUser(User user) {
        System.out.println("animal -- setter-based di");
        this.user = user;
    }

    public Animal() {
        System.out.println("animal-singleton:set:" + i++);
    }

    private Animal(User user) {
        System.out.println("aninmiinininimal--constructor-based di:" + i++);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "user=" + user +
                '}';
    }

    private void destroy() {
        System.out.println("animal: destroy..");
    }
}
