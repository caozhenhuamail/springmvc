package com.springapp.mvc.controller;


import com.springapp.mvc.po.ItemsCustom;
import com.springapp.mvc.po.ItemsQueryVo;
import com.springapp.mvc.service.ItemsService;
import com.springapp.mvc.validation.ValidItemsGroup1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Controller，类级别上的注解。我们定义的类可以只是一个 javabean，不需要实现任何接口。标注了
 * @Controller，借助 <context:component-scan>，框架能自动识别到这就是一个 Controller
 *
 * @RequestMapping 可以出现在类级别上，也可以出现在方法上。如果出现在类级别上，那请求的 url 为 类级别
 * 上的 @RequestMapping + 方法级别上的 @RequestMapping，否则直接取方法级上的 @RequestMapping。
 * 类级别的 @RequestMapping 不是必需的。
 */
@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemsService itemsService;

    /**
     * 查询商品信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(ItemsQueryVo itemsQueryVo, HttpSession session) throws Exception {

        List<ItemsCustom> itemCustomList = itemsService.findItemsList(itemsQueryVo);

        ModelAndView mv = new ModelAndView();
        //添加模型数据 可以是仸意的 POJO 对象
        mv.addObject("itemsList", itemCustomList);
        mv.addObject("username", session.getAttribute("username"));
        //讴置逻辑规图名,规图解析器会根据该名字解析到具体的规图页面
        mv.setViewName("itemsList");

        return mv;
    }

    /**
     * 商品编辑页面提交
     * @return
     * @throws Exception
     * pojo的绑定规则是说，如果表单的提交数据的name名称和对象的名称一致那么就会自动绑定成功.
     * 在需要校验的pojo前边添加@Validated, 后面添加BindingResult 接收错误信息.这两者是成对出现的.
     *  @ModelAttribute("items") 表示指定pojo回显示到页面的request的key.
     *  同时还可以将方法的返回值传到页面在页面显示.
     *
     *  @ModelAttribute 可以为视图渲染提供更多的模型数据，而不需要在处理请求的方法里添加 ModelMap 或
     * Model 类型的参数。
     *
     * @ModelAttribute 可以标注在方法(存数据)上，也可以标注在方法参数(取数据)上。
     */
    @RequestMapping(value="/editItemsSubmit")
    public String edititemsSubmit(Model model, HttpServletRequest request,
                                  Integer id,
                                  @ModelAttribute("itemsCustom")
                                  @Validated(value = {ValidItemsGroup1.class}) ItemsCustom itemsCustom,
                                  BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError: allErrors) {
                //objectError.getDefaultMessage();
            }
            model.addAttribute("allErrors", allErrors);
            return "editItem";
        }

        itemsService.updateItems(id, itemsCustom);

        return "forward:queryItems";
    }

    /**
     * 商品删除页面提交
     * @return
     * @throws Exception
     * 数组的绑定规则是，在删除这个功能里是name属性的名称和形参的名称一致.
     * 在mapper里可以不需要定义parameterType
     */
    @RequestMapping(value="/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception {

        itemsService.deleteItems(items_id);

        return "forward:queryItems";
    }

    /**
     * 批量编辑商品信息
     * @return
     * @throws Exception
     * 列表的绑定规则是：应该是一个pojo的对象列表. 前端页面使用情况可以参考editItemsList页面
     */
    @RequestMapping(value="/editItemsList")
    public String editItemsList(List<ItemsCustom> listItems) throws Exception {
        return "success";
    }

    /**
     * 编辑商品信息
     * @return
     * @throws Exception
     * 参数绑定说明：
     * 如果不使用@RequestParam,要求request传入的参数名称和controller的方法的形参名称一致.方可绑定成功
     * 如果使用这没有以上限制.
     */
    @RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView editItems(@RequestParam(value="id", required = true, defaultValue = "1") Integer item_id)
            throws Exception {

        ItemsCustom itemsCustom = itemsService.findItemsById(item_id);

        ModelAndView mv = new ModelAndView();
        //添加模型数据 可以是仸意的 POJO 对象
        mv.addObject("itemsCustom", itemsCustom);
        //讴置逻辑规图名,规图解析器会根据该名字解析到具体的规图页面
        mv.setViewName("editItem");

        return mv;
    }

    /**
     * 以下为返回值的另外一种形式，返回字符串而不是ModelAndView
     * 编辑商品信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editItems1", method = {RequestMethod.POST, RequestMethod.GET})
    public String editItems(Model model) throws Exception {

        ItemsCustom itemCustom = itemsService.findItemsById(1);

        model.addAttribute("itemCustom", itemCustom);

        //页面里可以进行重定向或者页面转发
        //重定向：return "redirect:queryItems";
        //页面转发: return "forward:queryItems" request 请求可以共享. 页面参数可以被重用.
        return "editItem";
    }

    /**
     * 以下为返回值的另外一种形式，void方式
     * HttpServletRequest,HttpServletResponse,Model,ModelMap,HttpSession,这些是Springmvc默认的参数绑定的方式.
     * 编辑商品信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editItems2", method = {RequestMethod.POST, RequestMethod.GET})
    public void editItems(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ItemsCustom itemCustom = itemsService.findItemsById(1);

        model.addAttribute("itemCustom", itemCustom);

        //request可以用来获取参数.
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("json");
    }


}
