package com.inkslab.inkOJbackend.judge.codeSandbox;

import com.inkslab.inkOJbackend.judge.model.ExecuteCodeRequest;
import com.inkslab.inkOJbackend.judge.model.ExecuteCodeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 沙箱的代理类，便于进行扩展
 */
@Slf4j
@AllArgsConstructor
public class CodeSandboxProxy implements CodeSandbox{

    private final CodeSandbox codeSandbox;

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息"+executeCodeRequest.toString());
        ExecuteCodeResponse response = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱响应信息"+response.toString());
        return response;
    }
}
