/**
 * 项目名称:  my-shop
 * 文件名:    UploadController
 * 作者:     金威
 * 修改日期:  2020/7/23 14:02
 * 描述:
 */
package com.jinwei.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传控制器
 */
@Controller

public class UploadController {
    private static final String UPLOAD_PATH ="/static/upload/";
    /**
     * 文件上传
     * @param dropFile dropzone
     * @param editorFile wangeditor
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile dropFile, MultipartFile editorFile , HttpServletRequest request) throws IOException {

        Map<String,Object> result =new HashMap<> ();
        MultipartFile myFile= dropFile == null ? editorFile :dropFile ;

        //文件名
        String fileName =myFile.getOriginalFilename ();
        //文件后缀
        String fileSuffix =fileName.substring (fileName.lastIndexOf ("."));

        //文件存放路径
        String filePath = request.getSession ().getServletContext ().getRealPath (UPLOAD_PATH);
        File file =new File (filePath);
        if (!file.exists ()){
            file.mkdir ();

        }

        //将文件写入目标文件夹
        file =new File (filePath, UUID.randomUUID ()+fileSuffix);
        myFile.transferTo (file);

        if (dropFile != null){
            result.put ("fileName",UPLOAD_PATH+ file.getName ());

        }
        else {
            String serverPath =request.getScheme ()+"://"+ request.getServerName ()+":"+request.getServerPort ();
            result.put ("errno",0);
            result.put ("data",new String[]{serverPath + UPLOAD_PATH + file.getName ()});
        }


        return result;
    }
}
