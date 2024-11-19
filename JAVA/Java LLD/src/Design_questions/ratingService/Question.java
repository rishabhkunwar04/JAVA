package Design_questions.ratingService;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String text;
    private List<Integer> ratings = new ArrayList<>();

    public Question(String text) {
        this.text = text;
    }

    public void addRating(int rating) {
        ratings.add(rating);
    }

    public double getAverageRating() {
        return ratings.isEmpty() ? 0 : ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
