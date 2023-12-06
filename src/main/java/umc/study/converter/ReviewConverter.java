package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static StoreResponseDTO.createReviewResultDTO toCreateReviewResultDTO(Review review) {
        return StoreResponseDTO.createReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(StoreRequestDTO.createReviewDTO reuest) {
        return Review.builder()
                .body(reuest.getBody())
                .score(reuest.getScore())
                .reviewImageList(new ArrayList<>())
                .build();
    }
}
