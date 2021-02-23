package com.quan.dubbo.server.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.quan.dubbo.server.pojo.RecommendUser;
import com.quan.dubbo.server.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Service(version = "1.0.0")
public class RecommendUserApiImpl implements RecommendUserApi {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public RecommendUser queryWithMaxScore(Long userId) {
        // 条件
        Criteria criteria = Criteria.where("toUserId").is(userId);
        // 按照得分倒序排序，获取第一条数据
        Query query = Query.query(criteria).with(Sort.by(Sort.Order.desc("score")))
                .limit(1);
        return this.mongoTemplate.findOne(query, RecommendUser.class);
    }

    @Override
    public PageInfo<RecommendUser> queryPageInfo(Long userId, Integer pageNum, Integer pageSize) {
        Criteria criteria = Criteria.where("toUserId").is(userId);
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by(Sort.Order.desc("score")));
        Query query = Query.query(criteria).with(pageable);
        List<RecommendUser> recommendUsers = this.mongoTemplate.find(query, RecommendUser.class);

        // 说明：数据总条数，暂时不提供，如果需要的话再提供
        return new PageInfo<>(0, pageNum, pageSize, recommendUsers);
    }
}
