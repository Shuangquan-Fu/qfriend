package com.quan.dubbo.server.api;

import com.quan.dubbo.server.pojo.RecommendUser;
import com.quan.dubbo.server.vo.PageInfo;

public interface RecommendUserApi {
    /**
     * 查询一位得分最高的推荐用户
     *
     * @param userId
     * @return
     */
    RecommendUser queryWithMaxScore(Long userId);

    /**
     * 按照得分倒序
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<RecommendUser> queryPageInfo(Long userId, Integer pageNum, Integer pageSize);
}
