package org.anonymous.serviceImpl;

import org.anonymous.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author child
 * 2019/4/17 14:30
 */
@Service("user") //ioc
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("save...///");
    }
}
