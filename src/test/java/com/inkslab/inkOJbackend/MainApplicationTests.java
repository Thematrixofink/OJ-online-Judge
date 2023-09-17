package com.inkslab.inkOJbackend;

import javax.annotation.Resource;

import com.inkslab.inkOJbackend.judge.codeSandbox.impl.RemoteCodeSandbox;
import com.inkslab.inkOJbackend.judge.model.ExecuteCodeRequest;
import com.inkslab.inkOJbackend.judge.model.ExecuteCodeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;

/**
 * 主类测试
 *
 */
@SpringBootTest
class MainApplicationTests {




    private static final String SALT = "ink";
    @Test
    void getPassword(){
        String userPassword = "12345678";
        String s = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        System.out.println(s);
    }

    @Test
    void testRemoteCodeSandBox(){
        ExecuteCodeRequest codeRequest = new ExecuteCodeRequest();
        String code = "public class Solution {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(a+b);\n" +
                "    }\n" +
                "}";
        ArrayList<String> input = new ArrayList<>();
        input.add("1 2");
        input.add("2 2");
        codeRequest.setCode(code);
        codeRequest.setInput(input);
        codeRequest.setLanguage("java");
        RemoteCodeSandbox remoteCodeSandbox = new RemoteCodeSandbox();
        ExecuteCodeResponse re = remoteCodeSandbox.executeCode(codeRequest);
        System.out.println(re);
    }
}
