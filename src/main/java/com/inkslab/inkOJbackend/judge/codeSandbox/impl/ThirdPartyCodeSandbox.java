package com.inkslab.inkOJbackend.judge.codeSandbox.impl;

import com.inkslab.inkOJbackend.judge.codeSandbox.CodeSandbox;
import com.inkslab.inkOJbackend.judge.model.ExecuteCodeRequest;
import com.inkslab.inkOJbackend.judge.model.ExecuteCodeResponse;

/**
 * 第三方代码沙箱
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
