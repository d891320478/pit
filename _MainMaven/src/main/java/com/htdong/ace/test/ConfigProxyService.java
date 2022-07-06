package com.htdong.ace.test;

import java.util.Map;

import com.shinemo.ace4j.protocol.AceService;
import com.shinemo.common.tools.result.ApiResult;

@AceService
public interface ConfigProxyService {

    ApiResult<String> getByKey(String key);

    ApiResult<Map<String, String>> getByNode(String nodeName);

    ApiResult<String> getByKeyAndNode(String key, String nodeName);

    ApiResult<Map<String, String>> getSecretConf(String appName);

}