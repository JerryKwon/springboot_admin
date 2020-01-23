package com.fastcampus.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.entity.OrderGroup;
import com.fastcampus.admin.model.entity.User;
import com.fastcampus.admin.model.enumclass.UserStatus;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.UserApiRequest;
import com.fastcampus.admin.model.network.response.ItemApiResponse;
import com.fastcampus.admin.model.network.response.OrderGroupApiResponse;
import com.fastcampus.admin.model.network.response.UserApiResponse;
import com.fastcampus.admin.model.network.response.UserOrderInfoApiResponse;
import com.fastcampus.admin.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    public Header<UserOrderInfoApiResponse> orderInfo(Long id){
        
        //user
        User user = userRepository.getOne(id);

        UserApiResponse userApiResponse = response(user);
    
        //orderGroup
        List<OrderGroup> orderGroupList = user.getOrderGroupList();

        List<OrderGroupApiResponse> orderGroupApiResponseList = orderGroupList.stream() // Stream<OrderGroup>
                .map(orderGroup -> {
                    OrderGroupApiResponse orderGroupApiResponse = orderGroupApiLogicService.response(orderGroup).getData();
                
                    //itemApiResponse 까지 생성해주는 단계가 필요 (using List<ItemApiResponse>)
                    List<ItemApiResponse> itemApiResponseList = orderGroup.getOrderDetailList().stream()
                            .map(orderDetail -> orderDetail.getItem())
                            .map(item -> itemApiLogicService.response(item).getData())
                            .collect(Collectors.toList());

                    orderGroupApiResponse.setItemApiResponseList(itemApiResponseList);

                    return orderGroupApiResponse;
 
                }) // Stream<Header<OrderGroupApiResponse>>
                .collect(Collectors.toList()); //List<OrderGroupApiResponse>
        
        
        userApiResponse.setOrderGroupApiResponseList(orderGroupApiResponseList);

        UserOrderInfoApiResponse userOrderInfoApiResponse = UserOrderInfoApiResponse.builder().userApiResponse(userApiResponse).build();

        return Header.OK(userOrderInfoApiResponse);

    }

    public Header<List<UserApiResponse>> search(Pageable pageable){
        
        log.info("before pagenation");
        Page<User> users = userRepository.findAll(pageable);

        log.info("after pagenation");
        // List<UserApiResponse> 형태로 데이터를 담음
        List<UserApiResponse> userApiResponseList = users.stream().map(user -> response(user)).collect(Collectors.toList());

        // 이를 Header<List<UserApiResopnse>> 로

        return Header.OK(userApiResponseList);
    }

    //1. request 호출
    //2. user 생성
    //3. 생성된 데이터 => UserApiResponse 반환

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        // TODO Auto-generated method stub
        
        UserApiRequest userApiRequest = request.getData();
        
        User user = User.builder()
                        .account(userApiRequest.getAccount())
                        .password(userApiRequest.getPassword())
                        .status(UserStatus.REGISTERED)
                        .phoneNumber(userApiRequest.getPhoneNumber())
                        .email(userApiRequest.getEmail())
                        .registeredAt(LocalDateTime.now())
                        .build();

        User newUser = userRepository.save(user);


        // Header<UserApiResponse> response = response(newUser);

        // return response;

        return Header.OK(response(newUser));

    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        // TODO Auto-generated method stub

        //getOne or getById
        Optional<User> optional = userRepository.findById(id);
        
        return optional.map(user -> Header.OK(response(user))).orElseGet(()->Header.Error("데이터 없음"));

        // return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        // TODO Auto-generated method stub
        
        //1. data 추출
        UserApiRequest userApiRequest = request.getData();
        
        //2. id -> User를 찾고
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        //3. Update
        //4. Return
        return optional.map(user->{
            user.setAccount(userApiRequest.getAccount())
                .setPassword(userApiRequest.getPassword())
                .setStatus(userApiRequest.getStatus())
                .setPhoneNumber(userApiRequest.getPhoneNumber())
                .setEmail(userApiRequest.getEmail())
                .setRegisteredAt(userApiRequest.getRegisteredAt())
                .setUnregisteredAt(userApiRequest.getUnregisteredAt());
        
                return user;

            }).map(user-> userRepository.save(user)) //update -> newUser
            .map(newUser -> Header.OK(response(newUser))) //userApiResponse생성
            .orElseGet(()->Header.Error("데이터 없음"));


        // return null;
    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub

        // id -> repository -> user
        Optional<User> optional = userRepository.findById(id);

        // repository -> delete
        return optional.map(user->{
            userRepository.delete(user);

            return Header.OK();
        }).orElseGet(()->Header.Error("데이터 없음"));

        // response return
    }
    //user 를 받아서 Header<UserApiResponse>로 반환
    private UserApiResponse response(User user){

        UserApiResponse userApiResponse = UserApiResponse.builder()
                                                            .id(user.getId())
                                                            .password(user.getPassword())
                                                            .email(user.getEmail())
                                                            .phoneNumber(user.getPhoneNumber())
                                                            .status(user.getStatus())
                                                            .registeredAt(user.getRegisteredAt())
                                                            .unregisteredAt(user.getUnregisteredAt())
                                                            .build();
        
        //Header + data 부분
        return userApiResponse;
    }

}