package com.springmvc.controller;

import com.springmvc.common.ExportExcelUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExportExcelController {

    @RequestMapping("/exportExcel")
    @ResponseBody
    public ModelAndView exportExcel(HttpServletRequest request, HttpServletResponse response) {
        try {

            // 这两行取出从js传回来的参数，没参数的可以不用
            String params = request.getParameter("params");
          //  JSONObject json = JSONObject.fromObject(params);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//            list.add(new HashMap<String, Object>("one",1) {
//
//            })
            String title="代办事件";
            String[] rowsName=new String[]{"序号","第二列标题","第三列标题","第四列标题"};
            List<Object[]> dataList=new ArrayList<Object[]>();

            ExportExcelUtils ex=new ExportExcelUtils(title,rowsName,dataList,response);
            ex.exportData();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  null;
    }

}
