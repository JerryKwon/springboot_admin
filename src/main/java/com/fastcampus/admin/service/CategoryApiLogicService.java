package com.fastcampus.admin.service;

import com.fastcampus.admin.ifs.CrudInterface;
import com.fastcampus.admin.model.entity.Category;
import com.fastcampus.admin.model.network.Header;
import com.fastcampus.admin.model.network.request.CategoryApiRequest;
import com.fastcampus.admin.model.network.response.CategoryApiResponse;
import com.fastcampus.admin.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryApiLogicService implements CrudInterface<CategoryApiRequest, CategoryApiResponse> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {
        // TODO Auto-generated method stub
        
        CategoryApiRequest body = request.getData();

        Category newCategory = Category.builder()
                                        .type(body.getType())
                                        .title(body.getTitle())
                                        .createdAt(body.getCreatedAt())
                                        .createdBy(body.getCreatedBy()).build();

        return response(categoryRepository.save(newCategory));

    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {
        // TODO Auto-generated method stub

        return categoryRepository.findById(id).map(category -> response(category)).orElseGet(()->Header.Error("해당 데이터 없음"));
        
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {
        // TODO Auto-generated method stub
 
        CategoryApiRequest body = request.getData();

        return categoryRepository.findById(body.getId()).map(category -> category.setType(body.getType())
                                                                            .setTitle(body.getTitle())
                                                                            .setCreatedAt(body.getCreatedAt())
                                                                            .setCreatedBy(body.getCreatedBy())
                                                                            .setUpdatedAt(body.getUpdatedAt())
                                                                            .setUpdatedBy(body.getUpdatedBy()))
                                                        .map(category -> categoryRepository.save(category))
                                                        .map(category -> response(category))
                                                        .orElseGet(() -> Header.Error("해당 데이터 없음"));

    }

    @Override
    public Header delete(Long id) {
        // TODO Auto-generated method stub
        return categoryRepository.findById(id).map(category->{
            categoryRepository.delete(category);
            return Header.OK();
        }).orElseGet(()->Header.Error("해당 데이터 없음"));
    }

    public Header<CategoryApiResponse> response(Category category) {
        CategoryApiResponse categoryApiResponse = CategoryApiResponse.builder()
                                                                        .id(category.getId())
                                                                        .type(category.getType())
                                                                        .title(category.getTitle())
                                                                        .createdAt(category.getCreatedAt())
                                                                        .createdBy(category.getCreatedBy())
                                                                        .updatedAt(category.getUpdatedAt())
                                                                        .updatedBy(category.getUpdatedBy()).build();

        return Header.OK(categoryApiResponse);
                                                                        
                                                                        
    }
}