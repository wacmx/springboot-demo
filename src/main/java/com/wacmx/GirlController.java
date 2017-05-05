package com.wacmx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Yangyang on 2017/5/4.
 */
@RestController
@RequestMapping(value="/girl")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 获取所有女生的列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }
    /**
     * 新增一个女生
     */
    @PostMapping(value = "/girls")
    public Girl  girlAdd(@PathParam("cupSize") String cupSize,@PathParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 查询一个女生
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer  id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生
     * @param id
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer  id,@PathParam("cupSize") String cupSize,@PathParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer  id){
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询
     */
    @GetMapping(value = "/girls/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }
}
