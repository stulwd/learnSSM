package com.lwdHouse.dao;

import com.lwdHouse.domain.Goods;

public interface GoodsDao {
    int updateGoods(Goods goods);
    Goods selectGoods(Integer id);
}
