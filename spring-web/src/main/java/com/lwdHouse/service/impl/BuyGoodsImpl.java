package com.lwdHouse.service.impl;

import com.lwdHouse.dao.GoodsDao;
import com.lwdHouse.dao.SaleDao;
import com.lwdHouse.domain.Goods;
import com.lwdHouse.domain.Sale;
import com.lwdHouse.excep.NotEnoughException;
import com.lwdHouse.service.BuyGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("buyGoodsImpl")
public class BuyGoodsImpl implements BuyGoods {

    @Autowired(required = true)
    private GoodsDao goodsDao;
    @Autowired(required = true)
    private SaleDao saleDao;

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public SaleDao getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

//    配合事务处理方式一使用
//    @Transactional(
//            propagation = Propagation.REQUIRED,
//            isolation = Isolation.DEFAULT,
//            readOnly = false,
//            rollbackFor = {                   // 方法发生什么异常时要回滚事务
//                    NotEnoughException.class,
//                    NullPointerException.class
//            }
//    )
    // Transactional默认值: Propagation.REQUIRED, Isolation.DEFAULT, readOnly = false
    // 所以一般只写@Transactional即可
//    @Transactional
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("=====buy()方法开始=====");
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        // 查询商品总数
        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null){
            throw new NullPointerException("编号为 "+ goodsId+ " 的商品不存在");
        }
        if (goods.getAmount() < nums){
            throw new NotEnoughException("编号为 "+goodsId+" 的商品库存不足");
        }

        // 修改库存
        Goods buyGoods = new Goods();
        buyGoods.setAmount(nums);
        buyGoods.setId(goodsId);
        goodsDao.updateGoods(buyGoods);
        System.out.println("=====buy()方法结束=====");
    }

    public void addSale(){};
    public void addGoods(){};

    public void modifySale(){};
    public void modifyGoods(){};

    public void removeSale(){};
    public void removeGoods(){};

    public void querySale(){};
    public void queryGoods(){};
}
