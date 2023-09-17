package com.inkslab.inkOJbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inkslab.inkOJbackend.model.dto.question.QuestionQueryRequest;
import com.inkslab.inkOJbackend.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inkslab.inkOJbackend.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 24957
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2023-09-07 15:17:57
*/
public interface QuestionService extends IService<Question> {
    /**
     * 校验
     *
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);



    /**
     * 获取题目封装
     *
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
}
