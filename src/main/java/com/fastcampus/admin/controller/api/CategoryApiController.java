package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.CategoryApiRequest;
import com.fastcampus.admin.model.network.response.CategoryApiResponse;
import com.fastcampus.admin.service.CategoryApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController implements CrudInterface<CategoryApiRequest, CategoryApiResponse> {

    @Autowired
    private CategoryApiLogicService categoryApiLogicService;

    @Override
    public Header<CategoryApiResponse> create(@RequestBody Header<CategoryApiRequest> request) {
        // TODO Auto-generated method stub
        return categoryApiLogicService.create(request);
    }

    @Override
    public Header<CategoryApiResponse> read(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return categoryApiLogicService.read(id);
    }

    @Override
    public Header<CategoryApiResponse> update(@RequestBody Header<CategoryApiRequest> request) {
        // TODO Auto-generated method stub
        return categoryApiLogicService.update(request);
    }

    @Override
    public Header delete(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return categoryApiLogicService.delete(id);
    }

}