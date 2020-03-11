package mate.academy.dubovskyi.springbootproject.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import mate.academy.dubovskyi.springbootproject.CsvReader;
import mate.academy.dubovskyi.springbootproject.model.Review;
import mate.academy.dubovskyi.springbootproject.service.ReviewService;
import org.springframework.stereotype.Component;

@Component
public class InitController {
    private ReviewService reviewService;

    public InitController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostConstruct
    List<Review> insertReviewsToDb() {
        CsvReader reader = new CsvReader("src/main/resources/Reviews.csv");
        List<Review> reviewsFromFile = reader.getReviewsFromFile();
        return reviewService.saveAll(reviewsFromFile);
    }
}
