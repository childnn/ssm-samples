package org.anonymous.serviceImpl;

import org.anonymous.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author child
 * 2019/4/17 10:07
 */
@Service("userServiceImpl") //让 ioc 管理 该类的对象
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
//        int i = 1 / 0;
        System.out.println("save..");
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void find() {

    }
}
