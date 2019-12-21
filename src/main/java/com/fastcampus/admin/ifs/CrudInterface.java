package com.fastcampus.admin.ifs;

import com.fastcampus.admin.model.network.Header;

public interface CrudInterface {
    
    Header create();

    Header read(Long id);

    Header update();

    Header delete(Long id);

}