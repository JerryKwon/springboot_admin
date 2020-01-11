package com.fastcampus.admin.service;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.entity.OrderGroup;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.OrderGroupApiRequest;
import com.fastcampus.admin.model.network.response.OrderGroupApiResponse;
import com.fastcampus.admin.repository.OrderGroupRepository;
import com.fastcampus.admin.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderGroupApiLogicService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {
    
    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        // TODO Auto-generated method stub
        
        // 1. 헤더 내의 바디만 추출
        OrderGroupApiRequest orderGroupApiRequest = request.getData();

        // 2. 신규 엔터티 생성
        OrderGroup newOrderGroup = OrderGroup.builder()
                                                .user(userRepository.getOne(orderGroupApiRequest.getId()))
                                                .status(orderGroupApiRequest.getStatus())
                                                .orderType(orderGroupApiRequest.getOrderType())
                                                .revAddress(orderGroupApiRequest.getRevAddress())
                                                .revName(orderGroupApiRequest.getRevName())
                                                .paymentType(orderGroupApiRequest.getPaymentType())
                                                .totalPrice(orderGroupApiRequest.getTotalPrice())
                                                .totalQuantity(orderGroupApiRequest.getTotalQuantity())
                                                .orderAt(orderGroupApiRequest.getOrderAt())
                                                .arrivalDate(orderGroupApiRequest.getArrivalDate())
                                                .createdAt(orderGroupApiRequest.getCreatedAt())
                                                .createdBy(orderGroupApiRequest.getCreatedBy()).build();

        // 3. 응답을 api에서 명시한 형태를 body로 하여 Header 아래에 전달                                       
        return response(newOrderGroup);
        
        // return null;
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        // TODO Auto-generated method stub
        
        // 해당 엔터티를 읽어서 반응을 위한 함수에 엮어서 바로 return
        return orderGroupRepository.findById(id)
                                    .map(orderGroup -> response(orderGroup))
                                    .orElseGet(() -> Header.Error("일치하는 데이터 없음"));

    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        // TODO Auto-generated method stub
        
        OrderGroupApiRequest body = request.getData();


        return orderGroupRepository.findById(body.getId()).map(
            orderGroup -> {
             return orderGroup.setUser(userRepository.getOne(body.getUserId()))
                            .setStatus(body.getStatus())
                            .setOrderType(body.getOrderType())
                            .setRevAddress(body.getRevAddress())
                            .setRevName(body.getRevName())
                            .setPaymentType(body.getPaymentType())
                            .setTotalPrice(body.getTotalPrice())
                            .setTotalQuantity(body.getTotalQuantity())
                            .setOrderAt(body.getOrderAt())
                            .setArrivalDate(body.getArrivalDate())
                            .setCreatedAt(body.getCreatedAt())
                            .setCreatedBy(body.getCreatedBy())
                            .setUpdatedAt(body.getUpdatedAt())
                            .setUpdatedBy(body.getUpdatedBy());
            }
        ).map(orderGroup -> orderGroupRepository.save(orderGroup))
        .map(orderGroup -> response(orderGroup))
        .orElseGet(() -> Header.Error("해당데이터 없음."));
    
    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub
        
        orderGroupRepository.findById(id)
        .map(orderGroup -> {
            orderGroupRepository.delete(orderGroup);
            return Header.OK();
        })
        .orElseGet(() -> Header.Error("해당 데이터 없음"));
        
        return null;
    }

    // Request에 대한 응답으로 Header를 씌우기 위한 마무리 함수
    public Header<OrderGroupApiResponse> response( OrderGroup orderGroup ){

        OrderGroupApiResponse orderGroupApiResponse = OrderGroupApiResponse.builder()
                                                                            .userId(orderGroup.getUser().getId())
                                                                            .status(orderGroup.getStatus())
                                                                            .orderType(orderGroup.getOrderType())
                                                                            .revAddress(orderGroup.getRevAddress())
                                                                            .revName(orderGroup.getRevName())
                                                                            .paymentType(orderGroup.getPaymentType())
                                                                            .totalPrice(orderGroup.getTotalPrice())
                                                                            .totalQuantity(orderGroup.getTotalQuantity())
                                                                            .orderAt(orderGroup.getOrderAt())
                                                                            .arrivalDate(orderGroup.getArrivalDate())
                                                                            .createdAt(orderGroup.getCreatedAt())
                                                                            .createdBy(orderGroup.getCreatedBy())
                                                                            .updatedAt(orderGroup.getUpdatedAt())
                                                                            .updatedBy(orderGroup.getUpdatedBy()).build();

        return Header.OK(orderGroupApiResponse);
    }

}