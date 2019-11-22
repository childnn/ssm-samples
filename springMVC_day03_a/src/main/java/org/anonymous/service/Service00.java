package org.anonymous.service;

import org.anonymous.exception.MyException;

/**
 * @author child
 * 2019/4/21 21:58
 */
public class Service00 {
    public void testS() throws MyException {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new MyException();
        }
    }
}
