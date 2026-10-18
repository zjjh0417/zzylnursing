package com.zzyl.nursing.controller;

import com.zzyl.common.core.domain.AjaxResult;
import com.zzyl.nursing.service.IElderService;
import com.zzyl.nursing.service.IHealthAssessmentService;
import com.zzyl.nursing.service.IReservationService;
import com.zzyl.nursing.vo.ElderBasicInfoVo;
import com.zzyl.nursing.vo.ElderHealthInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/dify/serve")
public class DifyServeController {

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IElderService elderService;

    @Autowired
    private IHealthAssessmentService healthAssessmentService;

    @GetMapping("/getReservationByToday")
    public String getReservationByDay(String datetime){
        System.out.println(datetime);

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 字符串转 LocalDateTime
        LocalDate dateTime = LocalDate.parse(datetime, formatter);

        return reservationService.getReservationByDay(dateTime);

    }

    /**
     * 查询老人基本信息
     *
     * @param nameOrId 老人姓名或ID
     * @return 老人基本信息
     */
    @GetMapping("/elder/basic-info")
    public AjaxResult getElderBasicInfo(@RequestParam(required = false) String nameOrId)
    {
        List<ElderBasicInfoVo> elderBasicInfos = elderService.selectElderBasicInfo(nameOrId);
        return AjaxResult.success(elderBasicInfos);
    }

    /**
     * 查询老人健康信息
     *
     * @param nameOrId 老人姓名或ID
     * @return 老人姓名、健康评分、风险等级、健康报告总结
     */
    @GetMapping("/elder/health-info")
        public AjaxResult getElderHealthInfo(@RequestParam(required = false) String nameOrId)
    {
        List<ElderHealthInfoVo> elderHealthInfos = healthAssessmentService.selectElderHealthInfo(nameOrId);
        return AjaxResult.success(elderHealthInfos);
    }

}