package com.springapp.mvc.po;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品包装对象
 * 为了数据表的扩展性，一般不对原有表进行扩展
 * Created by richard on 15-12-1.
 */
@Repository
public class ItemsQueryVo {

    private Items items;

    private ItemsCustom itemsCustom;

    private List<ItemsCustom> listItems;

    public List<ItemsCustom> getListItems() {
        return listItems;
    }

    public void setListItems(List<ItemsCustom> listItems) {
        this.listItems = listItems;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return "ItemsQueryVo{" +
                "items=" + items +
                ", itemsCustom=" + itemsCustom +
                ", listItems=" + listItems +
                '}';
    }
}
