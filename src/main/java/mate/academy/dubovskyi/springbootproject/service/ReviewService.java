package mate.academy.dubovskyi.springbootproject.service;

import java.util.List;

import mate.academy.dubovskyi.springbootproject.model.Review;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    List<Review> saveAll(List<Review> reviews);
}
