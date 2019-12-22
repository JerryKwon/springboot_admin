package com.fastcampus.admin.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.entity.User;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.UserApiRequest;
import com.fastcampus.admin.model.network.response.UserApiResponse;
import com.fastcampus.admin.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

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
                        .status("Registered")
                        .phoneNumber(userApiRequest.getPhoneNumber())
                        .email(userApiRequest.getEmail())
                        .registeredAt(LocalDateTime.now())
                        .build();

        User newUser = userRepository.save(user);


        Header<UserApiResponse> response = response(newUser);

        return response;
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        // TODO Auto-generated method stub

        //getOne or getById
        Optional<User> optional = userRepository.findById(id);
        
        return optional.map(user -> response(user)).orElseGet(()->Header.Error("데이터 없음"));

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
            .map(newUser -> response(newUser)) //userApiResponse생성
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
    private Header<UserApiResponse> response(User user){

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
        return Header.OK(userApiResponse);
    }

}