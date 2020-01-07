package com.fastcampus.admin.service;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.entity.OrderDetail;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.OrderDetailApiRequest;
import com.fastcampus.admin.model.network.response.OrderDetailApiResponse;
import com.fastcampus.admin.repository.ItemRepository;
import com.fastcampus.admin.repository.OrderDetailRepository;
import com.fastcampus.admin.repository.OrderGroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailApiLogicService implements CrudInterface<OrderDetailApiRequest, OrderDetailApiResponse> {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request) {
        // TODO Auto-generated method stub
        
        OrderDetailApiRequest body =  request.getData();

        if(body != null){
            OrderDetail orderDetail = OrderDetail.builder()
                                                    .item(itemRepository.getOne(body.getItemId()))
                                                    .orderGroup(orderGroupRepository.getOne(body.getOrderGroupId()))
                                                    .status(body.getStatus())
                                                    .arrivalDate(body.getArrivalDate())
                                                    .quantity(body.getQuantity())
                                                    .totalPrice(body.getTotalPrice())
                                                    .createdAt(body.getCreatedAt())
                                                    .createdBy(body.getCreatedBy())
                                                    .build();
            
            return response(orderDetailRepository.save(orderDetail));
        }
        else return Header.Error("삽입 요청 데이터 없음");

    }

    @Override
    public Header<OrderDetailApiResponse> read(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Header<OrderDetailApiResponse> response(OrderDetail orderDetail){

        OrderDetailApiResponse orderDetailApiResponse = OrderDetailApiResponse.builder()
                                                                                .itemId(orderDetail.getItem().getId())
                                                                                .orderGroupId(orderDetail.getOrderGroup().getId())
                                                                                .status(orderDetail.getStatus())
                                                                                .arrivalDate(orderDetail.getArrivalDate())
                                                                                .quantity(orderDetail.getQuantity())
                                                                                .totalPrice(orderDetail.getTotalPrice())
                                                                                .createdAt(orderDetail.getCreatedAt())
                                                                                .createdBy(orderDetail.getCreatedBy())
                                                                                .updatedAt(orderDetail.getUpdatedAt())
                                                                                .updatedBy(orderDetail.getUpdatedBy())
                                                                                .build();

        return Header.OK(orderDetailApiResponse);

    }

}