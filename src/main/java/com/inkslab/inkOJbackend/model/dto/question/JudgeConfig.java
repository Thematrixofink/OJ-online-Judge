package com.inkslab.inkOJbackend.model.dto.question;

import lombok.Data;

@Data
public class JudgeConfig {
    /**
     * 时间限制ms
     */
    private Long timeLimit;
    /**
     * 内存限制 KB
     */
    private Long memoryLimit;

    /**
     * 堆栈限制 KB
     */
    private Long stackLimit;
}
