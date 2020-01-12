package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.controller.CrudController;
import com.fastcampus.admin.model.entity.OrderGroup;
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
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse,OrderGroup> {

}