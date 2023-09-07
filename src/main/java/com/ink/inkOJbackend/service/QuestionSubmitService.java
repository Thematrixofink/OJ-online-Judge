package com.ink.inkOJbackend.service;

import com.ink.inkOJbackend.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.ink.inkOJbackend.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ink.inkOJbackend.model.entity.User;

/**
* @author 24957
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2023-09-07 15:19:01
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param user
     * @return
     */
     long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User user);

    /**
     * 题目提交（内部服务）
     *
     * @param userId
     * @param postId
     * @return
     */
    int doQuestionSubmitInner(long postId,long userId);
}
