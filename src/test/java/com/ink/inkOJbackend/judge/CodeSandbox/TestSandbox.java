package com.ink.inkOJbackend.judge.CodeSandbox;

import com.ink.inkOJbackend.judge.codeSandbox.CodeSandbox;
import com.ink.inkOJbackend.judge.codeSandbox.impl.ExampleCodeSandbox;
import com.ink.inkOJbackend.judge.model.ExecuteCodeRequest;
import com.ink.inkOJbackend.judge.model.ExecuteCodeResponse;
import com.ink.inkOJbackend.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestSandbox {

    @Test
    void testSandbox(){
        CodeSandbox codeSandbox = new ExampleCodeSandbox();
        String code = "int main() {}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> input = Arrays.asList("1,2","3,4");
        /**
         * 链式的build
         */
        ExecuteCodeRequest executeCodeResponse = ExecuteCodeRequest.builder()
                .input(input)
                .language(language)
                .code(code)
                .build();
        ExecuteCodeResponse executeCodeResponse1 = codeSandbox.executeCode(executeCodeResponse);
    }
}
