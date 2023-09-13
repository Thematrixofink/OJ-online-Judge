package com.ink.inkOJbackend.judge.codeSandbox.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.ink.inkOJbackend.common.ErrorCode;
import com.ink.inkOJbackend.exception.BusinessException;
import com.ink.inkOJbackend.judge.codeSandbox.CodeSandbox;
import com.ink.inkOJbackend.judge.model.ExecuteCodeRequest;
import com.ink.inkOJbackend.judge.model.ExecuteCodeResponse;

/**
 * 远程代码沙箱
 */
public class RemoteCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://localhost:8102/executeCode";
        String requestJson = JSONUtil.toJsonStr(executeCodeRequest);
        String responseBody = HttpUtil.createPost(url)
                .body(requestJson)
                .execute()
                .body();
        if(!StrUtil.isNotBlank(responseBody)){
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR,"调用远程代码沙箱服务错误!");
        }
        return JSONUtil.toBean(responseBody, ExecuteCodeResponse.class);
    }
}
