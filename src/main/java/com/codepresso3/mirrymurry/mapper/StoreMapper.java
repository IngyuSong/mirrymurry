package com.codepresso3.mirrymurry.mapper;

import com.codepresso3.mirrymurry.vo.BookMng;
import com.codepresso3.mirrymurry.vo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface StoreMapper {

    List<BookMng> bookMngList(@Param("store_id") Integer store_id);

    Integer bookOk(@Param("book_id") Integer book_id);

    Integer bookCancel(@Param("book_id") Integer book_id);

    Integer addMenu(@Param("menu") Menu menu);

    Integer updateMenu(@Param("menu") Menu menu);

    List<Menu> getMenuList(@Param("store_id") Integer store_id);


}

