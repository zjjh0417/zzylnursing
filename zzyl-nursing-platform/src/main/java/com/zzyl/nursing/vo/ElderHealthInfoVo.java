package com.zzyl.nursing.vo;

import lombok.Data;

/**
 * 老人健康信息 VO（供 Dify 调用）
 */
@Data
public class ElderHealthInfoVo {

    /** 健康评估ID */
    private Long id;

    /** 老人姓名 */
    private String elderName;

    /** 健康评分 */
    private String healthScore;

    /** 风险等级 */
    private String riskLevel;

    /** 健康报告总结 */
    private String reportSummary;
}