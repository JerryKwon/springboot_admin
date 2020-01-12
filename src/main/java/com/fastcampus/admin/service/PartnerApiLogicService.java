package com.fastcampus.admin.service;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.entity.Partner;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.PartnerApiRequest;
import com.fastcampus.admin.model.network.response.PartnerApiResponse;
import com.fastcampus.admin.repository.CategoryRepository;
import com.fastcampus.admin.repository.PartnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest, PartnerApiResponse,Partner> {

    // @Autowired
    // private PartnerRepository partnerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {
        // TODO Auto-generated method stub
        
        PartnerApiRequest body = request.getData();

        Partner newPartner = Partner.builder()
                                    .name(body.getName())
                                    .status(body.getStatus())
                                    .address(body.getAddress())
                                    .callCenter(body.getCallCenter())
                                    .partnerNumber(body.getPartnerNumber())
                                    .businessNumber(body.getBusinessNumber())
                                    .ceoName(body.getCeoName())
                                    .registeredAt(body.getRegisteredAt())
                                    .unregisteredAt(body.getUnregisteredAt())
                                    .createdAt(body.getCreatedAt())
                                    .createdBy(body.getCreatedBy())
                                    .category(categoryRepository.getOne(body.getCategoryId()))
                                    .build();

        Partner partner = baseRepository.save(newPartner);

        return response(partner);
    }

    @Override
    public Header<PartnerApiResponse> read(Long id) {
        // TODO Auto-generated method stub
        
        return baseRepository.findById(id).map(partner -> response(partner)).orElseGet(() -> Header.Error("해당 데이터 없음."));

    }

    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
        // TODO Auto-generated method stub
        
        PartnerApiRequest body = request.getData();

        return baseRepository.findById(body.getId()).map(partner -> partner.setName(body.getName())
                                                                        .setStatus(body.getStatus())
                                                                        .setAddress(body.getAddress())
                                                                        .setCallCenter(body.getCallCenter())
                                                                        .setPartnerNumber(body.getPartnerNumber())
                                                                        .setBusinessNumber(body.getBusinessNumber())
                                                                        .setCeoName(body.getCeoName())
                                                                        .setRegisteredAt(body.getRegisteredAt())
                                                                        .setUnregisteredAt(body.getUnregisteredAt())
                                                                        .setCreatedAt(body.getCreatedAt())
                                                                        .setCreatedBy(body.getCreatedBy())
                                                                        .setUpdatedAt(body.getUpdatedAt())
                                                                        .setUpdatedBy(body.getUpdatedBy())
                                                                        .setCategory(categoryRepository.getOne(body.getCategoryId())))
                                                        .map(partner -> baseRepository.save(partner))
                                                        .map(partner -> response(partner))
                                                        .orElseGet(() -> Header.Error("해당 값 없음."));
        
    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub
 
        return baseRepository.findById(id).map(partner -> {
            baseRepository.delete(partner);
            return Header.OK();
        }).orElseGet(() -> Header.Error("해당 사항 없음."));


    }
    
    public Header<PartnerApiResponse> response(Partner partner){

        PartnerApiResponse partnerApiResponse = PartnerApiResponse.builder()
                                                                    .id(partner.getId())
                                                                    .name(partner.getName())
                                                                    .status(partner.getStatus())
                                                                    .address(partner.getAddress())
                                                                    .callCenter(partner.getCallCenter())
                                                                    .partnerNumber(partner.getPartnerNumber())
                                                                    .businessNumber(partner.getBusinessNumber())
                                                                    .ceoName(partner.getCeoName())
                                                                    .registeredAt(partner.getRegisteredAt())
                                                                    .unregisteredAt(partner.getUnregisteredAt())
                                                                    .createdAt(partner.getCreatedAt())
                                                                    .createdBy(partner.getCreatedBy())
                                                                    .updatedAt(partner.getUpdatedAt())
                                                                    .updatedBy(partner.getUpdatedBy())
                                                                    .categoryId(partner.getCategory().getId()).build();

        return Header.OK(partnerApiResponse);

    }

}