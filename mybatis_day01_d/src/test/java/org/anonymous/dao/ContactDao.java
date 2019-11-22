package org.anonymous.dao;

import java.util.List;

/**
 * @author child
 * 2019/4/10 14:21
 */
public interface ContactDao {
    <E> List<E> findAll();
}
