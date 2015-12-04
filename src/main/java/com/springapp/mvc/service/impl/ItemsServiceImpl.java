package com.springapp.mvc.service.impl;


import com.springapp.mvc.mapper.ItemsCustomMapper;
import com.springapp.mvc.mapper.ItemsMapper;
import com.springapp.mvc.po.Items;
import com.springapp.mvc.po.ItemsCustom;
import com.springapp.mvc.po.ItemsQueryVo;
import com.springapp.mvc.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by richard on 15-12-1.
 */
@Service("ItemsService")
public class ItemsServiceImpl implements ItemsService {

    /**
     * Spring @Autowired,@Resource,@Required注解的用法和作用
     * @Autowired的用法和作用
     * 这个注解就是spring可以自动帮你把bean里面引用的对象的setter/getter方法省略，它会自动帮你set/get
     */
    @Autowired
    ItemsCustomMapper itemsCustomMapper;

    @Autowired
    ItemsMapper itemsMapper;

    /**
     * 查询商品列表
     * @param itemsQueryVo
     * @return
     * @throws Exception
     */
    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {

        return itemsCustomMapper.findItemsList(itemsQueryVo);

    }

    /**
     * 根据主键查询商品列表
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public ItemsCustom findItemsById(Integer id) throws Exception {

        Items items = itemsMapper.selectByPrimaryKey(id);
        //这里会有一些业务处理逻辑最后转换为itemsCustom对象
        ItemsCustom itemsCustom = new ItemsCustom();
        //将items copy到itemCustom
        BeanUtils.copyProperties(items, itemsCustom);

        return itemsCustom;
    }


    /**
     * 根据主键更新商品信息
     * @param id
     * @param itemsCustom
     * @throws Exception
     */
    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        //根据业务功能需要校验传入的参数是否空等在这里处理....
        itemsCustom.setId(id);
        //BLOBS方法可以对整个对象进行更新.
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);

    }

    /**
     * 根据主键删除商品信息
     * @param ids
     * @throws Exception
     */
    @Override
    public void deleteItems(Integer[] ids) throws Exception {

        itemsMapper.deleteItems(ids);

    }
}
