package com.springapp.mvc.mapper;

import com.springapp.mvc.po.Items;
import com.springapp.mvc.po.ItemsCustom;
import org.springframework.stereotype.Component;

/**
 * Created by richard on 15-12-2.
 */
@Component("ItemsMapper")
public interface ItemsMapper {

    Items selectByPrimaryKey(Integer id);

    void updateByPrimaryKeyWithBLOBs(ItemsCustom itemsCustom);

    void deleteItems(Integer[] ids);
}
