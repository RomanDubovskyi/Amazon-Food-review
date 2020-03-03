package mate.academy.dubovskyi.springbootproject.repository;

import mate.academy.dubovskyi.springbootproject.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
