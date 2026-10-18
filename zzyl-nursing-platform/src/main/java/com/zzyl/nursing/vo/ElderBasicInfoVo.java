package com.zzyl.nursing.vo;

import lombok.Data;

/**
 * 老人基本信息 VO（供 Dify 调用）
 */
@Data
public class ElderBasicInfoVo {

    /** 老人ID */
    private Long id;

    /** 姓名 */
    private String name;

    /** 年龄 */
    private Integer age;

    /** 性别（0:女 1:男） */
    private Integer sex;

    /** 性别描述 */
    private String sexDesc;

    /** 入住时间（yyyy-MM-dd） */
    private String checkInTime;

    /** 房间号 */
    private String roomNumber;

    /** 床位号 */
    private String bedNumber;

    /** 护理等级 */
    private String nursingLevelName;
}