package com.fastcampus.admin.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.fastcampus.admin.model.entity.Item;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.ItemApiRequest;
import com.fastcampus.admin.model.network.response.ItemApiResponse;
import com.fastcampus.admin.repository.PartnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemApiLogicService extends BaseService<ItemApiRequest,ItemApiResponse,Item>  {

    // @Autowired
    // private ItemRepository itemRepository;

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
        
        Item newItem = baseRepository.save(item);

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

        return baseRepository.findById(id).map(item->{
            return response(item);
        }).orElseGet(()->{
            return Header.Error("데이터 없음");
        });

    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        // TODO Auto-generated method stub
        
        ItemApiRequest body = request.getData();

        // Optional<Item> optional = itemRepository.findById(body.getId());

        baseRepository.findById(body.getId()).map(item->{
            item
                .setStatus(body.getStatus())
                .setName(body.getName())
                .setTitle(body.getTitle())
                .setContent(body.getContent())
                .setPrice(body.getPrice())
                .setBrandName(body.getBrandName())
                .setRegisteredAt(body.getRegisteredAt())
                .setUnregisteredAt(body.getUnregisteredAt());

            return item;

        }).map(newItem ->{      // 맵 함수에 중괄호 없으면 return이 생략.
            baseRepository.save(newItem);
            return newItem;
        }).map(newItem->{
            return response(newItem);
        })
        .orElseGet(()->{
            return Header.Error("일치하는 데이터 없음");
        });

        return null;
    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub

        Optional<Item> optional = baseRepository.findById(id);

        return optional.map(item->{

            baseRepository.delete(item); // delete 는 void 형태를 return 하기 때문에 OKAY를 따로 구성함.

            return Header.OK();
        }).orElseGet(()->{
            return Header.Error("데이터 없음");
        });

    }

    // 동작한 내용에 대해 응답하여 Header를 부르는 함수
    private Header<ItemApiResponse> response(Item item){

        // item.getStatus().getTitle(); 로 api에 실제 값이 아닌 title을 넘겨줄 수 도 있음!

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