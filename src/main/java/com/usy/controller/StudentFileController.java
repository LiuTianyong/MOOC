package com.usy.controller;

import com.usy.constant.ResponseCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/uploading")
public class StudentFileController {

    private static String uploadPath = "E:\\MOOCStudent" + File.separator;

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> upload(@RequestParam("file") MultipartFile multipartFile, Model model){
        //1.传到那里去
        //(1)判断
        Map<String,String> map = new HashMap<>();

        map.put(ResponseCode.CODE,ResponseCode.HAS_USE.toString());

        if (multipartFile != null && !multipartFile.isEmpty()){
            //不空才传
            //(2)构建新文件
            String originalFilename = multipartFile.getOriginalFilename();
            System.out.println(originalFilename);
            //(3)截取源文件的文件名前缀，不带后缀
            String fileNamePrefix = originalFilename.substring(0,originalFilename.lastIndexOf("."));
            //(4)加工处理文件名，将原文件名 + 时间戳
            String newFileNamefix = fileNamePrefix + new Date().getTime();
            //(5)得到新文件名
            String newFileName = newFileNamefix + originalFilename.substring(originalFilename.lastIndexOf("."));
            //(6)构建文件对象
            File file = new File(uploadPath + newFileName);
            //(7)上传
            try {
                multipartFile.transferTo(file);
                map.put(ResponseCode.CODE,ResponseCode.CAN_USE.toString());
                System.out.println("全路径:" + uploadPath + newFileName);


            }catch (IOException e){
                e.printStackTrace();
            }

        }
        //2.我传什么东西
        //3.传的细节
        return map;
    }

}
