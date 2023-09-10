package com.ink.inkOJbackend.judge;

import com.ink.inkOJbackend.judge.model.ExecuteCodeRequest;
import com.ink.inkOJbackend.judge.model.ExecuteCodeResponse;
import com.ink.inkOJbackend.model.entity.QuestionSubmit;
import com.ink.inkOJbackend.model.vo.QuestionSubmitVO;

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
