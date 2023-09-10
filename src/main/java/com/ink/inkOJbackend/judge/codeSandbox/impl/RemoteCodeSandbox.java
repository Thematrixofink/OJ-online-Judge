package com.ink.inkOJbackend.judge.codeSandbox.impl;

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
        return null;
    }
}
