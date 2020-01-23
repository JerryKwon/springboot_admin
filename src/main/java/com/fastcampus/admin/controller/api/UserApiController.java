package com.fastcampus.admin.controller.api;

import java.util.List;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.UserApiRequest;
import com.fastcampus.admin.model.network.response.UserApiResponse;
import com.fastcampus.admin.model.network.response.UserOrderInfoApiResponse;
import com.fastcampus.admin.service.UserApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j // debugging 을 위한 logfile 생성 annotation
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest,UserApiResponse>{

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id){
        return userApiLogicService.orderInfo(id);

    }

    //pagenation setting 
    @GetMapping("")
    public Header<List<UserApiResponse>> search(@PageableDefault(sort = "id",direction = Sort.Direction.ASC,size = 15) Pageable pageable){
        log.info("{}",pageable);
        
        return userApiLogicService.search(pageable);
    }

    @Override
    @PostMapping("") //     /api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        // TODO Auto-generated method stub

        log.info("{}",request); // request.toString()
        return userApiLogicService.create(request);
    }


    // @Override
    // @GetMapping("{ids}") // /api/user/{id}
    // public Header read(@PathVariable(name = "ids")  Long id) {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable Long id) {
        // TODO Auto-generated method stub
        log.info("{}",id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("") // /api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        // TODO Auto-generated method stub
        log.info("{}",request);
        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        // TODO Auto-generated method stub
        log.info("{}",id);
        return userApiLogicService.delete(id);
    }

}