package com.fastcampus.admin.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.admin.model.SearchParam;

@RestController
@RequestMapping("/api")

public class PostController {

	//POST�� �Ͼ�� ���
	//HTML�� FORM TAG
	//ajax�� �˻��� �� (port �������)
	
	//@ReqeustBody => HTML ��Žÿ� post�� body�� �����͸� ���� �־ �����ϰڴٴ� ��
	//json, xml, multipart-form, text-plain ������� �����͸� ������ �� ���� 
	//produce�� ������ �� �ִ� ���µ��� ����
	
	
	@PostMapping(value = "/postMethod")
	public SearchParam postMethod(@RequestBody SearchParam searchParam) {
	
		return searchParam;
		
	}
	
	@PutMapping("/putMethod")
	public void put() {
		
	}
	
	@PatchMapping("/patchMethod")
	public void patch() {
		
	}
	
}
