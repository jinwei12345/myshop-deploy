package com.jinwei.my.shop.web.ui.api;

import com.jinwei.my.shop.commons.utils.HttpClientUtils;
import com.jinwei.my.shop.commons.utils.MapperUtils;
import com.jinwei.my.shop.web.ui.dto.TbContent;

import java.util.List;

/**
 * 内容管理接口
 * <p>Title: ContentsApi</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/7/4 14:57
 */
public class ContentsApi {
    public  static final String PIC_SERVER_PATH="http://localhost:8080";

    /**
     * 请求幻灯片
     *
     * @return
     */
    public static List<TbContent> ppt() {
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS_PPT);
        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
            //把要请求的图片地址
            for (TbContent tbContent : tbContents) {
                 String newPicUrl =PIC_SERVER_PATH.concat (tbContent.getPic ());
                 tbContent.setPic (newPicUrl);
                String newPic2Url =PIC_SERVER_PATH.concat (tbContent.getPic2 ());
                tbContent.setPic2 (newPic2Url);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}
