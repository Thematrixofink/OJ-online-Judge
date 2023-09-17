package com.inkslab.inkOJbackend.judge;

import com.inkslab.inkOJbackend.model.entity.QuestionSubmit;

/**
 * 判题服务
 */
public interface JudgeService {

    /**
     * 判题服务
     * @param questionSubmitId 提交题目的id
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
