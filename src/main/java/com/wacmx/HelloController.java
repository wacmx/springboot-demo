package com.wacmx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by Yangyang on 2017/5/2.
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value={"hello","hi"},method = RequestMethod.GET)
    public String hello(){
        return girlProperties.getCupSize() ;
    }

    /**
     * 访问格式:say/100  返回id:100
     * @param id
     * @return
     */
    @RequestMapping(value={"/say/{id}"},method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return "id:"+id ;
    }

    /**
     * 访问格式:say?id=100  对应id:100
     * @param id
     * @return
     */
    @RequestMapping(value="/may",method = RequestMethod.GET)
    public String may(@RequestParam("id") Integer id){
        return "id:"+id ;
    }

    /**
     * 访问格式:may?id=100  对应id:100   参数可添加默认值及其他属性
     * @GetMapping等价RequestMapping...Get
     * @param id
     * @return
     */
//    @RequestMapping(value={"/way"},method = RequestMethod.GET)
    @GetMapping(value = "way")
    public String way(@RequestParam(value="id",required = false,defaultValue = "1") Integer id){
        return "id:"+id ;
    }


}
