package com.springapp.mvc.mapper;


import com.springapp.mvc.po.ItemsCustom;
import com.springapp.mvc.po.ItemsQueryVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by richard on 15-12-1.
 */
@Component("ItemsCustomMapper")
public interface ItemsCustomMapper {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

}
