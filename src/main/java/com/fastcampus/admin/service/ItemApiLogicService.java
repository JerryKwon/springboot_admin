package com.fastcampus.admin.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.entity.Item;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.ItemApiRequest;
import com.fastcampus.admin.model.network.response.ItemApiResponse;
import com.fastcampus.admin.repository.ItemRepository;
import com.fastcampus.admin.repository.PartnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
        // TODO Auto-generated method stub
        
        ItemApiRequest body = request.getData();

        Item item = Item.builder()
                        .status(body.getStatus())
                        .name(body.getName())
                        .title(body.getTitle())
                        .content(body.getContent())
                        .price(body.getPrice())
                        .brandName(body.getBrandName())
                        .registeredAt(LocalDateTime.now())
                        .partner(partnerRepository.getOne(body.getPartnerId())).build();
        
        Item newItem = itemRepository.save(item);

        return response(newItem);
    
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        // TODO Auto-generated method stub
        // return itemRepository.findById(id).map(item->{
        //     response(item)
        // }).orElseGet(()->{
        //     Header.Error("데이터 없음");
        // });

        return itemRepository.findById(id).map(item->{
            return response(item);
        }).orElseGet(()->{
            return Header.Error("데이터 없음");
        });

    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub

        Optional<Item> optional = itemRepository.findById(id);

        return optional.map(item->{

            itemRepository.delete(item); // delete 는 void 형태를 return 하기 때문에 OKAY를 따로 구성함.

            return Header.OK();
        }).orElseGet(()->{
            return Header.Error("데이터 없음");
        });

    }

    // 동작한 내용에 대해 응답하여 Header를 부르는 함수
    private Header<ItemApiResponse> response(Item item){


        ItemApiResponse body = ItemApiResponse.builder()
                                                .id(item.getId())
                                                .status(item.getStatus())
                                                .name(item.getName())
                                                .title(item.getTitle())
                                                .content(item.getContent())
                                                .price(item.getPrice())
                                                .brandName(item.getBrandName())
                                                .registeredAt(item.getRegisteredAt())
                                                .unregisteredAt(item.getUnregisteredAt())
                                                .partnerId(item.getPartner().getId())
                                                .build();
        
        return Header.OK(body);

    }

}