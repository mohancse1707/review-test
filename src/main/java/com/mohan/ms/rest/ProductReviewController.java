package com.mohan.ms.rest;

import com.mohan.ms.rest.response.ProductReviewSuccessResponse;
import com.mohan.ms.service.ProductReviewService;
import com.mohan.ms.service.dto.ProductReviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductReviewController {

	private final ProductReviewService productReviewService;

	public ProductReviewController(ProductReviewService productReviewService) {
		this.productReviewService = productReviewService;
	}

	@GetMapping("/{product_id}")
	public ResponseEntity<List<ProductReviewDTO>> getProductReviewByProductId(@PathVariable(value = "product_id") String productId)  {
		List<ProductReviewDTO> reviewList = productReviewService.getAllReviewByProductId(productId);
		return new ResponseEntity<List<ProductReviewDTO>>(reviewList, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProductReviewDTO>> getAllProductReview()  {
		List<ProductReviewDTO> reviewList = productReviewService.getAllProductReview();
		return new ResponseEntity<List<ProductReviewDTO>>(reviewList, HttpStatus.OK);
	}

	@PostMapping("/addProductReview")
	public ResponseEntity<ProductReviewSuccessResponse> addProductReview(@RequestBody ProductReviewDTO reviewDTO) {
		productReviewService.addProductReview(reviewDTO);
		ProductReviewSuccessResponse response = new ProductReviewSuccessResponse();
		response.setMessage("Product Review Added Successfully!");
		return new ResponseEntity<ProductReviewSuccessResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/updateProductReview")
	public ResponseEntity<ProductReviewSuccessResponse> updateProductReview(@RequestBody ProductReviewDTO reviewDTO) {
		productReviewService.updateProductReview(reviewDTO);
		ProductReviewSuccessResponse response = new ProductReviewSuccessResponse();
		response.setMessage("Product Review Updated Successfully!");
		return new ResponseEntity<ProductReviewSuccessResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteProductReview")
	public ResponseEntity<ProductReviewSuccessResponse> deleteProductReview(@RequestParam(value = "id", required = false) Long id) {
		productReviewService.deleteProductReview(id);
		ProductReviewSuccessResponse response = new ProductReviewSuccessResponse();
		response.setMessage("Product Review Deleted Successfully!");
		return new ResponseEntity<ProductReviewSuccessResponse>(response, HttpStatus.OK);
	}
}