package com.ink.inkOJbackend.controller;

import com.ink.inkOJbackend.common.BaseResponse;
import com.ink.inkOJbackend.common.ErrorCode;
import com.ink.inkOJbackend.common.ResultUtils;
import com.ink.inkOJbackend.exception.BusinessException;
import com.ink.inkOJbackend.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.ink.inkOJbackend.model.entity.User;
import com.ink.inkOJbackend.service.QuestionSubmitService;
import com.ink.inkOJbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子点赞接口
 *
 */
@RestController
@RequestMapping("/question/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    @PostMapping("/do")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,HttpServletRequest request){
        if(questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        final User user = userService.getLoginUser(request);
        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest,user);
        return ResultUtils.success(result);
    }

}
