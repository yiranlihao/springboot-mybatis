package cn.lihao.controller;

import java.util.ArrayList;
import java.util.List;

import cn.lihao.common.ResponseResult;
import com.wordnik.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;

import cn.lihao.model.User;

@RestController
@RequestMapping(value="/users")
@Api(value = "SwaggerController", description="SwaggerController")
public class SwaggerController {


    /*
     *  http://localhost:8080/swagger/index.html
     */

    /**
     *
     * @return
     */
    @ApiOperation(value="getUsers",notes="getUsers")
    @RequestMapping(method=RequestMethod.GET)
    public ResponseResult<List<User>> getUsers(){
        List<User> list=new ArrayList<User>();

        User user=new User();
        user.setName("hello");
        list.add(user);

        User user2=new User();
        user.setName("world");
        list.add(user2);
        return ResponseResult.newSuccess(list);
    }

    @ApiOperation(value="getUserById",notes="getUserById")
    @RequestMapping(value="/{name}",method=RequestMethod.GET)
    public ResponseResult<User> getUserById(@PathVariable String name){
        User user=new User();
        user.setName(name);
        return ResponseResult.newSuccess(user);
    }
}