package com.fastcampus.admin.service;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.entity.AdminUser;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.AdminUserApiRequest;
import com.fastcampus.admin.model.network.response.AdminUserApiResponse;
import com.fastcampus.admin.repository.AdminUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserApiLogicService implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse> {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
        // TODO Auto-generated method stub
        
        AdminUserApiRequest body = request.getData();

        AdminUser newAdminUser = AdminUser.builder()
                                            .account(body.getAccount())
                                            .password(body.getPassword())
                                            .status(body.getStatus())
                                            .role(body.getRole())
                                            .lastLoginAt(body.getLastLoginAt())
                                            .passwordUpdatedAt(body.getPasswordUpdatedAt())
                                            .loginFailCount(body.getLoginFailCount())
                                            .registeredAt(body.getRegisteredAt())
                                            .unregisteredAt(body.getUnregisteredAt())
                                            .createdAt(body.getCreatedAt())
                                            .createdBy(body.getCreatedBy()).build();

        return response(adminUserRepository.save(newAdminUser));
    }

    @Override
    public Header<AdminUserApiResponse> read(Long id) {
        // TODO Auto-generated method stub
        return adminUserRepository.findById(id).map(adminUser -> response(adminUser)).orElseGet(() -> Header.Error("해당 데이터 없음"));
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
        // TODO Auto-generated method stub
        
        AdminUserApiRequest body = request.getData();

        return adminUserRepository.findById(body.getId()).map(adminUser -> adminUser.setAccount(adminUser.getAccount())
                                                                                .setPassword(adminUser.getPassword())
                                                                                .setStatus(adminUser.getStatus())
                                                                                .setRole(adminUser.getRole())
                                                                                .setLastLoginAt(adminUser.getLastLoginAt()
                                                                                .setPassword(adminUser.getPassword())
                                                                                .UpdatedAt(adminUser.getUpdatedAt())
                                                                                .setLoginFailCount(adminUser.getLoginFailCount())
                                                                                .setRegisteredAt(adminUser.getRegisteredAt())
                                                                                .setUnregisteredAt(adminUser.getUnregisteredAt())
                                                                                .setCreatedAt(adminUser.getCreatedAt())
                                                                                .setCreatedBy(adminUser.getCreatedBy())
                                                                                .setUpdatedAt(adminUser.getUpdatedAt())
                                                                                .setUpdatedBy(adminUser.getUpdatedBy()))
                                                    .map(adminUser -> adminUserRepository.save(adminUser))
                                                    .map(adminUser -> response(adminUser))
                                                    .orElseGet(()-> Header.Error("해당 데이터 없음"));

    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub
        return adminUserRepository.findById(id).map(adminUser -> {
            adminUserRepository.delete(adminUser);
            return Header.OK();
        }).orElseGet(() -> Header.Error("해당 데이터 없음"));
    }

    public Header<AdminUserApiResponse> response (AdminUser adminUser){

        AdminUserApiResponse adminUserApiResponse = AdminUserApiResponse.builder()
                                                                        .id(adminUser.getId())
                                                                        .account(adminUser.getAccount())
                                                                        .password(adminUser.getPassword())
                                                                        .status(adminUser.getStatus())
                                                                        .role(adminUser.getRole())
                                                                        .lastLoginAt(adminUser.getLastLoginAt())
                                                                        .passwordUpdatedAt(adminUser.getPasswordUpdatedAt())
                                                                        .loginFailCount(adminUser.getLoginFailCount())
                                                                        .registeredAt(adminUser.getRegisteredAt())
                                                                        .unregisteredAt(adminUser.getUnregisteredAt())
                                                                        .createdAt(adminUser.getCreatedAt())
                                                                        .createdBy(adminUser.getCreatedBy())
                                                                        .updatedAt(adminUser.getUpdatedAt())
                                                                        .updatedBy(adminUser.getUpdatedBy()).build();
                                                                        
        return Header.OK(adminUserApiResponse);
    }

}