package com.htdong.city.ly;

import java.io.IOException;

import com.shinemo.client.util.AESUtil;

/**
 * 
 * @author htdong
 */
public class Ly {

    public static void main(String[] args) throws IOException {
        System.out.println(AESUtil.md5(
                "access_token=Rdzg3//38kqHJkEVl42Vv+U6/NNsHz8bVefXl2+bvBIk+mHAf4RqWKT7UF0lmCPC&format=json&method=project_sync&partner_id=149EFA21CF&post_body={\"chineseDesc\":\"出差项目1\",\"code\":\"project1\",\"orgId\":\"TEST001\",\"status\":1}&requestid=aeb5961ea03e485fb6d3525ef9deebf6&signature_method=md5&timestamp=2019-02-13 13:43:49&version=v2&signature_key=ea03e485fb6d3525ef9d"));
    }
}
