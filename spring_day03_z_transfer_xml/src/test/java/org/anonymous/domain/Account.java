package org.anonymous.domain;


/**
 * @author child
 * 2019/4/25 11:37
 * depends-on 的测试
 */
public class Account {
    private static Animal animal;
    static {
        animal = new Animal();
    }
    public Account() {
        System.out.println("account:" + animal);
    }

    public void destroy() {
        System.out.println("account: destroy...");
    }

    public static void setAnimal(Animal animal) {
        Account.animal = animal;
    }
}
