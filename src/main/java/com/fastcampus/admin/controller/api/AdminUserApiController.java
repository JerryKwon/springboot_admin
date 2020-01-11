package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.AdminUserApiRequest;
import com.fastcampus.admin.model.network.response.AdminUserApiResponse;
import com.fastcampus.admin.service.AdminUserApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse> {

    @Autowired
    private AdminUserApiLogicService adminUserApiLogicService;

    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
        // TODO Auto-generated method stub
        return adminUserApiLogicService.create(request);
    }

    @Override
    public Header<AdminUserApiResponse> read(Long id) {
        // TODO Auto-generated method stub
        return adminUserApiLogicService.read(id);
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
        // TODO Auto-generated method stub
        return adminUserApiLogicService.update(request);
    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub
        return adminUserApiLogicService.delete(id);
    }


}