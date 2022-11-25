package com.codepresso3.mirrymurry.mapper;

import com.codepresso3.mirrymurry.vo.BookMng;
import com.codepresso3.mirrymurry.vo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface StoreMapper {

    List<BookMng> bookMngList(@Param("store_id") Integer store_id, @Param("bookDate") String bookDate);

    Integer bookOk(@Param("book_id") Integer book_id);

    Integer bookCancel(@Param("book_id") Integer book_id);

    Integer addMenu(@Param("menu") Menu menu);

    Integer updateMenu(@Param("menu") Menu menu);

    List<Menu> menuList(@Param("store_id") Integer store_id);

    Menu getMenu(@Param("menu_id") Integer menu_id);


}

