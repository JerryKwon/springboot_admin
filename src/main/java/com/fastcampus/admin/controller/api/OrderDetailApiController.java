package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.OrderDetailApiRequest;
import com.fastcampus.admin.model.network.response.OrderDetailApiResponse;
import com.fastcampus.admin.service.OrderDetailApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController implements CrudInterface<OrderDetailApiRequest,OrderDetailApiResponse> {

    @Autowired
    OrderDetailApiLogicService orderDetailApiLogicService;

    @PostMapping("")
    @Override
    public Header<OrderDetailApiResponse> create(@RequestBody Header<OrderDetailApiRequest> request) {
        // TODO Auto-generated method stub
        return orderDetailApiLogicService.create(request);
    }
    @GetMapping("{id}")
    @Override
    public Header<OrderDetailApiResponse> read(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @GetMapping("")
    @Override
    public Header<OrderDetailApiResponse> update(@RequestBody Header<OrderDetailApiRequest> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @DeleteMapping("{id}")
    @Override
    public Header delete(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}