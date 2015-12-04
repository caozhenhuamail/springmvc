package com.springapp.mvc.service;


import com.springapp.mvc.po.ItemsCustom;
import com.springapp.mvc.po.ItemsQueryVo;

import java.util.List;

/**
 * 商品查询列表接口
 * Created by richard on 15-12-1.
 */

public interface ItemsService {

    //商品查询列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    //根据主键查询商品列表
    public ItemsCustom findItemsById(Integer id) throws Exception;
    //根据主键更新商品信息
    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;
    //根据主键删除商品
    public void deleteItems(Integer[] ids) throws Exception;

}
