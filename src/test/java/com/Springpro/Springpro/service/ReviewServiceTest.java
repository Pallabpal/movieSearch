package com.Springpro.Springpro.service;

import com.Springpro.Springpro.domain.Review;
import com.Springpro.Springpro.repository.ReviewRepository;
import com.Springpro.Springpro.service.response.ReviewResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getReviewById_success() {
        // Arrange
        Long reviewId = 1L;
        Review mockReview = mock(Review.class);

        ReviewResponse mockReviewResponse = ReviewResponse.builder()
                .rating(1.2)
                .build();

        // Stub methods
        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(mockReview));



        // Act
        ReviewResponse result = reviewService.getReviewById(reviewId);

        // Assert
        assertNotNull(result, "The result should not be null.");
        assertEquals(mockReviewResponse.getRating(), result.getRating(), "The result should match the mock response.");
    }


}
