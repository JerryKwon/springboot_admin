package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.network.Header;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface{

    @Override
    @PostMapping("") //     /api/user
    public Header create() {
        // TODO Auto-generated method stub
        return null;
    }


    // @Override
    // @GetMapping("{ids}") // /api/user/{id}
    // public Header read(@PathVariable(name = "ids")  Long id) {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header read(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PutMapping("") // /api/user
    public Header update() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}