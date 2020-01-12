package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.controller.CrudController;
import com.fastcampus.admin.model.entity.Partner;
import com.fastcampus.admin.model.network.request.PartnerApiRequest;
import com.fastcampus.admin.model.network.response.PartnerApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse,Partner> {

   
}