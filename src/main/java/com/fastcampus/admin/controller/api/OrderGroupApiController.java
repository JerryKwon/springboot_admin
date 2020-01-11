package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.OrderGroupApiRequest;
import com.fastcampus.admin.model.network.response.OrderGroupApiResponse;
import com.fastcampus.admin.service.OrderGroupApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    OrderGroupApiLogicService orderGroupApiLogicService;

    @Override
    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
        // TODO Auto-generated method stub
        return orderGroupApiLogicService.create(request);
    }

    @Override
    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return orderGroupApiLogicService.read(id);
    }

    @Override
    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
        // TODO Auto-generated method stub
        return orderGroupApiLogicService.update(request);
    }

    @Override
    public Header delete(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}