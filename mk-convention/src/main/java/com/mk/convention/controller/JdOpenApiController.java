package com.mk.convention.controller;


import com.mk.convention.meta.JsonResult;
import com.mk.convention.service.JDOpenApiService;
import com.stylefeng.guns.core.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class JdOpenApiController {

    @Autowired
    JDOpenApiService jdOpenApiService;

    private JsonResult checkData(String Message){
        JsonResult jsonResult =new JsonResult();
        jsonResult.setCode(ResponseCode.SERVER_ERROR);
        jsonResult.setMessage(Message);
        jsonResult.setResult(null);
        return jsonResult;
    }

    @RequestMapping(value = "/getAccessToken",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getItemsById() {
        return jdOpenApiService.getAccessToken();
    }

    @RequestMapping(value = "/getPageNum",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getPageNum() {
        return jdOpenApiService.getPageNum();
    }

    @RequestMapping(value = "/getSkuByPage",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getSkuByPage(@RequestParam(value = "pageNum") String pageNum , @RequestParam(value = "pageNo")Integer pageNo){
        JsonResult jsonResult ;

        if (pageNum != null && !pageNum.isEmpty())//
        {//
            if (pageNum != null && !pageNum.isEmpty()){//
                jsonResult =  jdOpenApiService.getSkuByPage(pageNum,pageNo);//
            }else{//
                jsonResult = checkData("页码(pageNo)不能为空");//
                return  jsonResult;//
            }
        }else{//
            jsonResult = checkData("商品池编号(pageNum)不能为空");//
            return   jsonResult;//
        }
        return jsonResult;
    }

    @RequestMapping(value = "/getDetail",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getDetail(@RequestParam("skuId") String sku){
        JsonResult jsonResult;
        if(null!=sku&&!sku.isEmpty()){
        jsonResult = jdOpenApiService.getDetail(sku,null);
        }else{
            jsonResult = checkData("商品编号不能爲空");
        }
        return jsonResult;
    }

    @RequestMapping(value = "/getSkuState",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getSkuState(@RequestParam(value = "skuIds") String skuIds ){
        JsonResult jsonResult;

        if( null != skuIds &&!skuIds.isEmpty()){
            if (skuIds.substring(skuIds.length()-1,skuIds.length()).equals(",")){
                skuIds = skuIds.substring(0,skuIds.length()-1);
            }
                jsonResult=jdOpenApiService.getSkuSate(skuIds);
        }else{
            jsonResult=checkData("商品编号不能为空！");
        }
        return jsonResult;
    }

}
