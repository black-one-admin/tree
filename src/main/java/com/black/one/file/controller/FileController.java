package com.black.one.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文件上传
 *
 * @author swh
 * @create: 2020-04-30 17:12
 */
@Controller
@RequestMapping("/view")
public class FileController {



    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload(){
        return "upload";
    }


    @RequestMapping(value = "/data",method = RequestMethod.GET)
    @ResponseBody
    public String data(){
        return "upload";
    }
}
