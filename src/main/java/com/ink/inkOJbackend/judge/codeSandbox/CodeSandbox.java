package com.ink.inkOJbackend.judge.codeSandbox;

import com.ink.inkOJbackend.judge.model.ExecuteCodeRequest;
import com.ink.inkOJbackend.judge.model.ExecuteCodeResponse;

/**
 * 沙箱接口，定义沙箱的操作
 */
public interface CodeSandbox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}

