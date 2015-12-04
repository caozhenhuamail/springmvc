package com.springapp.mvc.po;


import com.springapp.mvc.validation.ValidItemsGroup1;
import com.springapp.mvc.validation.ValidItemsGroup2;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by richard on 15-12-1.
 * 在pojo里进行校验，这样的范围针对不同的业务层需求不太灵活，对应controller也行只需要验证参数是否为空就好，
 * 但是现在明显针对所有的业务层都是这个规则。可以通过分组来实现更灵活的校验。
 *
 * 分组校验： controller可以直接指定ValidItemsGroup1.class 来只对name字段进行校验. 而不同时校验name和createTime字段.
 * controller中这样使用 @Validated(value = {ValidItemsGroup1.class}) ItemsCustom itemsCustom,
 */
public class Items {

    private Integer id;
    @Size(min =1 ,max = 30,message = "{items.name.length.error}", groups = {ValidItemsGroup1.class})
    private String name;

    private Float price;

    private String pic;

    private String description;

    @NotNull(message="{items.createtime.isNull}", groups = {ValidItemsGroup2.class})
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
