package com.wqz.marketbg.dao;

import java.util.List;

import com.wqz.marketbg.pojo.Carousel;

public interface CarouselMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);
    
    List<Carousel> selectCarousel();
}