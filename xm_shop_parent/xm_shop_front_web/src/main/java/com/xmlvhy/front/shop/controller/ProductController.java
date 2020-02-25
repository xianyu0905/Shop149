package com.xmlvhy.front.shop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmlvhy.shop.common.constant.PaginationConstant;
import com.xmlvhy.shop.params.ProductParam;
import com.xmlvhy.shop.pojo.Product;
import com.xmlvhy.shop.pojo.ProductType;
import com.xmlvhy.shop.service.ProductService;
import com.xmlvhy.shop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author: 小莫
 * Date: 2019-03-12 13:42
 * Description: 前台商品接口
 */
@Controller
@RequestMapping("/front/product")
public class ProductController {

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductService productService;


    /**
     *功能描述: 加载所有商品列表
     * @Author 小莫
     * @Date 9:47 2019/03/14
     * @Param [productParam, pageName, model]
     * @return java.lang.String
     */
    @RequestMapping("/searchAllProducts")
    public String searchAllProducts(ProductParam productParam, Integer pageName, Model model){
        if (ObjectUtils.isEmpty(pageName)) {
            pageName = PaginationConstant.PAGE_NUM;
        }
        PageHelper.startPage(pageName,PaginationConstant.FRONT_PAGE_SIZE);
        List<Product> productList = productService.findByProductParams(productParam);
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        model.addAttribute("pageInfo",pageInfo);
        return "main";
    }

    /**
     *功能描述: 页面初始化
     * @Author 小莫
     * @Date 9:47 2019/03/14
     * @Param []
     * @return java.util.List<com.xmlvhy.shop.pojo.ProductType>
     */
    @ModelAttribute("productTypes")
    public List<ProductType> loadProductTypes(){
        List<ProductType> productTypes = productTypeService.findAllEnableProductTypes();
        return productTypes;
    }

    /**
     *功能描述: 展示商品详情
     * @Author 小莫
     * @Date 14:46 2019/03/19
     * @Param [model, id]
     * @return com.xmlvhy.shop.common.utils.ResponseResult
     */
    @RequestMapping("showProductDetail")
    public String showProductDetail(Model model,Integer id) {

        Product product = productService.findProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
        }
        return "productDetail";
    }


    /**
     *功能描述: 获取图片，修改商品信息预览图片显示
     * 图片地址：/admin/product/images/图片名称
     * @Author 小莫
     * @Date 23:05 2019/03/10
     * @Param [path, outputStream]
     * @return void
     */
    @RequestMapping("images/{date}/{imageName:.+}")
    @ResponseBody
    public void showImage(@PathVariable(name = "date") String date, @PathVariable(name = "imageName") String imageName, HttpServletResponse response) throws IOException {
        ServletOutputStream output = null;
        //直接响应写入到输出流中
        InputStream input = productService.downloadImage("/" + date + "/" + imageName, response);
        output = response.getOutputStream();
        response.setContentType("image/jpeg");
        byte imageArray[] = new byte[4064];
        int len = 0;
        while((len = input.read(imageArray)) != -1){
            output.write(imageArray, 0, len);
        }
        input.close();
        output.flush();
    }

}
