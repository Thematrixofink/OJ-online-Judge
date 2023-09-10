package com.ink.inkOJbackend.judge.strategy.strategies;


import cn.hutool.json.JSONUtil;
import com.ink.inkOJbackend.judge.model.JudgeContext;
import com.ink.inkOJbackend.judge.strategy.JudgeStrategy;
import com.ink.inkOJbackend.model.dto.question.JudgeCase;
import com.ink.inkOJbackend.model.dto.question.JudgeConfig;
import com.ink.inkOJbackend.judge.model.JudgeInfo;
import com.ink.inkOJbackend.model.entity.Question;
import com.ink.inkOJbackend.model.enums.JudgeInfoEnum;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 默认的判题策略
 */
public class DefaultJudgeStrategy implements JudgeStrategy {

    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        //用户代码的运行状态
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        //输入用例
        List<String> inputList = judgeContext.getInputList();
        //用户代码的输出
        List<String> outputList = judgeContext.getOutputList();
        Question question = judgeContext.getQuestion();
        //得到正确输出用例
        List<JudgeCase> judgeCase = judgeContext.getJudgeCases();
        List<String> formalOutputList= judgeCase.stream().map(JudgeCase::getOutput).collect(Collectors.toList());

        //判断题目执行状态
        //获取用户代码运行的具体信息，时间内存等
        Long time = judgeInfo.getTime();
        Long memory = judgeInfo.getMemory();
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemory(memory);
        judgeInfoResponse.setTime(time);

        //开始判断输出结果是否一致
        //看输出的数量与标准输出的数量是否一致
        JudgeInfoEnum judgeInfoEnum = JudgeInfoEnum.WRONG_ANSWER;
        if(outputList.size() != inputList.size()){
            judgeInfoResponse.setMessage(judgeInfoEnum.getValue());
            return judgeInfoResponse;
        }
        //查看每一项输出是否与标准答案一致
        for(int i = 0 ; i < outputList.size() ; i++){
            if(!formalOutputList.get(i).equals(outputList.get(i))){
                judgeInfoResponse.setMessage(judgeInfoEnum.getValue());
                return judgeInfoResponse;
            }
        }
        //判断题目限制
        //获取运行的限制信息
        JudgeConfig judgeConfig = JSONUtil.toBean(question.getJudgeConfig(), JudgeConfig.class);
        Long timeLimit = judgeConfig.getTimeLimit();
        Long memoryLimit = judgeConfig.getMemoryLimit();
        //判断时间和内存
        if(time > timeLimit){
            judgeInfoEnum = JudgeInfoEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoEnum.getValue());
            return judgeInfoResponse;
        }
        if(memory > memoryLimit){
            judgeInfoEnum = JudgeInfoEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoEnum.getValue());
            return judgeInfoResponse;
        }
        //一路披荆斩棘，都通过了，返回成功
        judgeInfoEnum = JudgeInfoEnum.ACCEPTED;
        judgeInfoResponse.setMessage(judgeInfoEnum.getValue());
        return judgeInfoResponse;
    }
}
