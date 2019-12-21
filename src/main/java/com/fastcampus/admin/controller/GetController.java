package com.fastcampus.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.admin.model.SearchParam;
import com.fastcampus.admin.model.network.Header;

//Spring에게 컨트롤러로 활용함을 알려주는 지시자
@RestController
//이곳으로 들어올 API 주소를 매핑하기 위한 지시자(괄호 안에는 어떤 path에서 받을지 명명)
@RequestMapping("/api") //localhost:8080/api ���� ����

//��Ʈ�ѷ�: ����ڷ� ���� ������ �޾��ֱ� ���� �ּҵ��� ����
public class GetController {

	//method�� GET method�� Ȱ���ϰ� ,path�� ��� �ּҷ� �޾Ƶ��̴ٴ� ��
	@RequestMapping(method = RequestMethod.GET, path="/getMethod") //localhost:8080/api/getMethod�� ȣ���ϸ� ������� ����� �Ʒ��� �޼ҵ�� ����
	public String getRequest() {
		 
		return "Hi getMethod";
	}
	//����ڰ� ��� ���� �������� �˼��� ����. �Ķ���͸� �ޱ� ���� ��� ������������ ������ ��?
	
	@GetMapping("/getParameter") //RequestMapping���� �޸� path�� ���	localhost:8080/api/getParameter?id=1234@password=abcd 
	public String getParmeter(@RequestParam String id, @RequestParam(name="password") String pwd) {
		
		//���� �ݵ�� �������������� password�� ����Ͽ��� �Ѵٸ�?? [Spring������ �Ķ���ͷ� �޾Ƽ� ����ϴ� ���� ����] ���� pwd�� ���� ó��
		String password = "???";
		
		System.out.println("id: "+id );
		System.out.println("pwd: "+pwd );
		
		return id+pwd;
	}
	
	//���� ���� ���� �ټ��� �Ķ���Ͱ� ��������� ��� �� ����ϰ� ���� ���ΰ�??? �ϳ��� Class�� �����صξ �� Ŭ������ �ٷ� �Ķ���ͷ� ���� ����
	@GetMapping("/getMultiParameter")
	public SearchParam getMultiParameter(SearchParam searchParam) {
		System.out.println(searchParam.getAccount());
		System.out.println(searchParam.getEmail());
		System.out.println(searchParam.getPage());
		
		//�׷��� ��Ʈ��Ʈ ��Žÿ��� JSON ���·� ����� ���ٵ�... JSON�� ��� ó���ϴ°�?
		//jackson library�� ���� SearchParam���� �������. => Spring Boot������ default�� ����Ǿ� ����.
		//��ü�� Return�Ѵٴ� ���� JSON ���·� RETURN �ϰڴٴ� ��.
		
		// {"account":"", "email":"", "page":0}
		
	// �߰�: Mapping �ϴ� �ּҰ� ������ ��쿡 Spring Boot�� � ���� �����ؾ� �� �� ���� ������ ����.	
	// �׷��� Class�� ��ġ�� �� RequestMapping("")�� ������ ���� Error X
		return searchParam;
	}
	
	
	//���� ���� ��ǥ�� localhost:8080/api/getMethod�� ����ڰ� ȣ���� �� ó��,
	//����ڰ� ȣ���� �Ϳ� ���ؼ� ���ϴ� ������ �����ͺ��̽����� ������ ���� �����Ͽ� ������ ������� return�� �ִ� ��
	
	@GetMapping("/getHeader")
	public Header getHeader(){
		return Header.builder().resultCode("OK").description("OK").build();
	}

}

