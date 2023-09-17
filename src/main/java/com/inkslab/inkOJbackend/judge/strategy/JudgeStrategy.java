package com.inkslab.inkOJbackend.judge.strategy;

import com.inkslab.inkOJbackend.judge.model.JudgeContext;
import com.inkslab.inkOJbackend.judge.model.JudgeInfo;

public interface JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
