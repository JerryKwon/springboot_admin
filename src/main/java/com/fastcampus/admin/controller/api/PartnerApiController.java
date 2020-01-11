package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.PartnerApiRequest;
import com.fastcampus.admin.model.network.response.PartnerApiResponse;
import com.fastcampus.admin.service.PartnerApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {

    @Autowired
    private PartnerApiLogicService partnerApiLogicService;

    @Override
    public Header<PartnerApiResponse> create(@RequestBody Header<PartnerApiRequest> request) {
        // TODO Auto-generated method stub
        return partnerApiLogicService.create(request);
    }

    @Override
    public Header<PartnerApiResponse> read(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return partnerApiLogicService.read(id);
    }

    @Override
    public Header<PartnerApiResponse> update(@RequestBody Header<PartnerApiRequest> request) {
        // TODO Auto-generated method stub
        return partnerApiLogicService.update(request);
    }

    @Override
    public Header delete(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return partnerApiLogicService.delete(id);
    }

}