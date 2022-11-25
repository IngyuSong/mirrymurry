package com.codepresso3.mirrymurry.service;

import com.codepresso3.mirrymurry.mapper.StoreMapper;
import com.codepresso3.mirrymurry.vo.BookMng;
import com.codepresso3.mirrymurry.vo.Menu;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class StoreService {

    private StoreMapper storeMapper;

    public StoreService(StoreMapper storeMapper){this.storeMapper=storeMapper;}

    public List<BookMng> bookMngList(Integer store_id, String bookDate){
        return storeMapper.bookMngList(store_id, bookDate);
    };

    public boolean bookCancel(Integer book_id){
        Integer result = storeMapper.bookCancel(book_id);
        return result==1;
    }

    public boolean addMenu(Menu menu){
        Integer result = storeMapper.addMenu(menu);
        return result == 1;
    }

    public boolean updateMenu(Menu menu){
        Integer result = storeMapper.updateMenu(menu);
        return result == 1;
    }

    public List<Menu> menuList(Integer store_id){
        return storeMapper.menuList(store_id);
    }



}
