package com.ink.inkOJbackend.judge.codeSandbox;

import com.ink.inkOJbackend.judge.codeSandbox.impl.ExampleCodeSandbox;
import com.ink.inkOJbackend.judge.codeSandbox.impl.RemoteCodeSandbox;
import com.ink.inkOJbackend.judge.codeSandbox.impl.ThirdPartyCodeSandbox;

/**
 * 沙箱工厂
 */
public class CodeSandboxFactory {
    /**
     * 创建沙箱实例
     * @param type
     * @return
     */
    public static CodeSandbox newInstance(String type){
        switch (type){
            case "example" :
                return new ExampleCodeSandbox();
            case "remote" :
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();

        }
    }
}
