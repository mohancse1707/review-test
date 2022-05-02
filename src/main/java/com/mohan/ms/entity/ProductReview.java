package com.mohan.ms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product_review")

public class ProductReview implements Serializable {
    @Id
    private Long id;
    private String productId;
    private Long averageReviewScore;
    private Long numberOfReview;
}
