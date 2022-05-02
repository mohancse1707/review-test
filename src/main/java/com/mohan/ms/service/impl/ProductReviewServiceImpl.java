package com.mohan.ms.service.impl;


import com.mohan.ms.entity.ProductReview;
import com.mohan.ms.repository.ProductReviewRepository;
import com.mohan.ms.service.ProductReviewService;
import com.mohan.ms.service.dto.ProductReviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ProductReviewServiceImpl implements ProductReviewService {

	@Autowired
	private ProductReviewRepository productReviewRepository;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<ProductReviewDTO> getAllReviewByProductId(String productId) {
		List<ProductReview> reviewList = productReviewRepository.findAllByProductId(productId);
		return getProductReviewDTOS(reviewList);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<ProductReviewDTO> getAllProductReview() {
		List<ProductReview> reviewList = productReviewRepository.findAll();
		return getProductReviewDTOS(reviewList);
	}


	@Override
	@Transactional
	public void addProductReview(ProductReviewDTO reviewDTO) {
		ProductReview productReview = new ProductReview().builder()
				.productId(reviewDTO.getProductId())
				.averageReviewScore(reviewDTO.getAverageReviewScore())
				.numberOfReview(reviewDTO.getNumberOfReview())
				.build();
		productReviewRepository.save(productReview);
	}

	@Override
	@Transactional
	public void updateProductReview(ProductReviewDTO reviewDTO) {

		Optional<ProductReview> productReview = productReviewRepository.findById(reviewDTO.getId());
		if(productReview.isPresent()){
			productReview.get().setNumberOfReview(reviewDTO.getNumberOfReview());
			productReview.get().setAverageReviewScore(reviewDTO.getAverageReviewScore());
			 productReviewRepository.save(productReview.get());
		} else {
			return;
		}
	}

	@Override
	@Transactional
	public void deleteProductReview(Long id) {
		productReviewRepository.findById(id).ifPresent(productReview -> {
			productReviewRepository.delete(productReview);
		});
	}

	private List<ProductReviewDTO> getProductReviewDTOS(List<ProductReview> reviewList) {
		List<ProductReviewDTO> dtoList = new ArrayList<>();
		reviewList.stream().forEach(review -> {
			ProductReviewDTO dto = new ProductReviewDTO();
			BeanUtils.copyProperties(review, dto);
			dtoList.add(dto);
		});
		return dtoList;
	}

}
