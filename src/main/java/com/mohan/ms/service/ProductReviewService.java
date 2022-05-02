package com.mohan.ms.service;

import com.mohan.ms.service.dto.ProductReviewDTO;

import java.util.List;

public interface ProductReviewService {
    List<ProductReviewDTO> getAllReviewByProductId(String productId);

    List<ProductReviewDTO> getAllProductReview();

    void addProductReview(ProductReviewDTO reviewDTO);

    void updateProductReview(ProductReviewDTO reviewDTO);

    void deleteProductReview(Long id);
}
