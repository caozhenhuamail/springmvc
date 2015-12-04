package com.springapp.mvc.controller;



import com.springapp.mvc.po.ItemsCustom;
import com.springapp.mvc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/test")
public class HelloController {

    @Autowired
    ItemsService itemsService;

	@RequestMapping(method = {RequestMethod.GET,RequestMethod.HEAD})
    @ResponseBody
	public Map<String,String> printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","b");
		return map;
	}


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserList() {
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("total", "1");
        modelMap.put("success", "true");
        return modelMap;
    }

    @RequestMapping(value = "/itemsJson")
    @ResponseBody
    public ItemsCustom getItems() throws Exception {

        ItemsCustom itemsCustom = itemsService.findItemsById(1);

        return itemsCustom;

    }

    /**
     *
     * @param itemsCustom
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/requestJson", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) throws Exception {

        return itemsCustom;

    }

    @RequestMapping(value = "/responseJson", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ItemsCustom responseJson(ItemsCustom itemsCustom) throws Exception {

        return itemsCustom;

    }

}