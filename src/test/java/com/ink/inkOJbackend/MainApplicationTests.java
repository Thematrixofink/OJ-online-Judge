package com.ink.inkOJbackend;

import com.ink.inkOJbackend.config.WxOpenConfig;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

/**
 * 主类测试
 *
 */
@SpringBootTest
class MainApplicationTests {

    @Resource
    private WxOpenConfig wxOpenConfig;

    @Test
    void contextLoads() {
        System.out.println(wxOpenConfig);
    }


    private static final String SALT = "ink";
    @Test
    void getPassword(){
        String userPassword = "12345678";
        String s = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        System.out.println(s);
    }

}
