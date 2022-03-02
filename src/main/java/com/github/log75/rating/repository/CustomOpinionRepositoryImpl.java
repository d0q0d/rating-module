package com.github.log75.rating.repository;

import com.github.log75.rating.model.KeyQueryParam;
import com.github.log75.rating.model.RateOpinion;
import com.github.log75.rating.model.RateStatusEnum;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 */
@AllArgsConstructor
public class CustomOpinionRepositoryImpl implements CustomOpinionRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public void addKey(KeyQueryParam queryParam) {
        String type = setOpinionType(queryParam.getStatusEnum());
        mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("rateValueEnum").is(queryParam.getValueEnum())), new Update().push(type, queryParam.getKey()), RateOpinion.class);
    }

    @Override
    public void removeKey(KeyQueryParam queryParam) {
        String type = setOpinionType(queryParam.getStatusEnum());
        mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("rateValueEnum").is(queryParam.getValueEnum())), new Update().pull(type, queryParam.getKey()), RateOpinion.class);
    }

    private String setOpinionType(RateStatusEnum statusEnum) {
        var type = "";
        if (statusEnum.equals(RateStatusEnum.POSITIVE)) type = "positiveOpinions";
        else type = "negativeOpinions";
        return type;
    }

}
