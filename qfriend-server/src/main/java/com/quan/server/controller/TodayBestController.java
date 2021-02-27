package com.quan.server.controller;


import com.quan.server.mapper.UserMapper;
import com.quan.server.pojo.User;
import com.quan.server.pojo.UserInfo;
import com.quan.server.service.TodayBestService;
import com.quan.server.vo.PageResult;
import com.quan.server.vo.RecommendUserQueryParam;
import com.quan.server.vo.TodayBest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("qfriend")
public class TodayBestController {

    @Autowired
    private TodayBestService todayBestService;


   @GetMapping("todaybest")
    public TodayBest queryTodayBest(@RequestParam(name = "id")Long id) {
        return this.todayBestService.queryTodayBest(id);
    }

    @GetMapping("recommendation")
    public PageResult queryRecommendUserList(RecommendUserQueryParam queryParam, @RequestParam(name = "id")Long id) {
       return this.todayBestService.queryRecommendUserList(queryParam,id);
    }

}
