package mate.academy.dubovskyi.springbootproject.service.impl;

import java.util.List;

import mate.academy.dubovskyi.springbootproject.model.Review;
import mate.academy.dubovskyi.springbootproject.repository.ReviewRepository;
import mate.academy.dubovskyi.springbootproject.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> saveAll(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }
}
