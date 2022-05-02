package com.mohan.ms.repository;

import com.mohan.ms.entity.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview, Long> {
    List<ProductReview> findAllByProductId(String productId);
}
