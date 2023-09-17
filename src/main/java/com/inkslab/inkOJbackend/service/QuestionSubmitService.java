package com.inkslab.inkOJbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inkslab.inkOJbackend.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.inkslab.inkOJbackend.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.inkslab.inkOJbackend.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inkslab.inkOJbackend.model.entity.User;
import com.inkslab.inkOJbackend.model.vo.QuestionSubmitVO;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 24957
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2023-09-07 15:19:01
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 提交问题内部方法
     * @param userId
     * @param questionId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int doQuestionSubmitInner(long userId, long questionId);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
