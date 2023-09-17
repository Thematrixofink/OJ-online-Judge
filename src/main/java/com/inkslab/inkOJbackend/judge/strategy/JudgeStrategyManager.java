package com.inkslab.inkOJbackend.judge.strategy;

import com.inkslab.inkOJbackend.judge.model.JudgeContext;
import com.inkslab.inkOJbackend.judge.strategy.strategies.DefaultJudgeStrategy;
import com.inkslab.inkOJbackend.judge.model.JudgeInfo;
import org.springframework.stereotype.Component;

/**
 * 判题策略管理，便于调用
 */
@Component
public class JudgeStrategyManager {

    /**
     * 判题操作
     * @param judgeContext
     * @return
     */
    //todo 针对特定的题目调用别的判题策略
    public JudgeInfo doJudge(JudgeContext judgeContext){
        String language = judgeContext.getQuestionSubmit().getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if(language.equals("java")){
            judgeStrategy = new DefaultJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
