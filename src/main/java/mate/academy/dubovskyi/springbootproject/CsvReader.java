package mate.academy.dubovskyi.springbootproject;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import mate.academy.dubovskyi.springbootproject.model.Review;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvReader {
    private String pathToCsvFile;

    public CsvReader(String path) {
        this.pathToCsvFile = path;
    }

    public List<Review> getReviewsFromFile() {
        List<Review> reviewList;
        try (Reader reader = Files.newBufferedReader(Paths.get(pathToCsvFile));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withHeader("Id", "ProductId", "UserId", "ProfileName",
                             "HelpfulnessNumerator", "HelpfulnessDenominator",
                             "Score", "Time", "Summary", "Text")
                     .withIgnoreHeaderCase()
                     .withTrim()
                     .withFirstRecordAsHeader())) {
            int initialCapacity = (int) Files.lines(Paths.get(pathToCsvFile)).count();
            reviewList = new ArrayList<>(initialCapacity);
            for (CSVRecord csvRecord : csvParser) {
                reviewList.add(setReview(csvRecord));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't parse reviews from file", e);
        }
        return reviewList;
    }

    private Review setReview(CSVRecord csvRecord) {
        String foodItemId = csvRecord.get("ProductId");
        String profileName = csvRecord.get("ProfileName");
        String reviewBody = csvRecord.get("Text");
        Review review = new Review();
        review.setFoodItemId(foodItemId);
        review.setReview(reviewBody);
        review.setUserName(profileName);
        return review;
    }
}
