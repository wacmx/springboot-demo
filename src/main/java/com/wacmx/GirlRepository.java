package com.wacmx;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Yangyang on 2017/5/5.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄查询
    List<Girl> findByAge(Integer age);
}
