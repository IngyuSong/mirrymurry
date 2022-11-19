package com.codepresso3.mirrymurry.mapper;

import com.codepresso3.mirrymurry.vo.BookMng;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {

    List<BookMng> getBookMngList();
}
