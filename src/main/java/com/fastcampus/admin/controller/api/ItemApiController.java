package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.controller.CrudController;
import com.fastcampus.admin.model.entity.Item;
import com.fastcampus.admin.model.network.request.ItemApiRequest;
import com.fastcampus.admin.model.network.response.ItemApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest,ItemApiResponse,Item> {

    // @Autowired
    // private ItemApiLogicService itemApiLogicService;

    // @PostConstruct // 상속받은 서비스에 의존성 주입한 서비스를 추가함
    // public void init(){
    //     this.baseService = itemApiLogicService;
    // }

}