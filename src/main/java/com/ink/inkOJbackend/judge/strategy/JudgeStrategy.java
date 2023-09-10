package com.ink.inkOJbackend.judge.strategy;

import com.ink.inkOJbackend.judge.model.JudgeContext;
import com.ink.inkOJbackend.judge.model.JudgeInfo;

public interface JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
