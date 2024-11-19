package Design_questions.ratingService;

import java.util.HashMap;
import java.util.Map;

public class Response {
    private Survey survey;
    private Map<Question, Integer> questionRatings = new HashMap<>();

    public Response(Survey survey) {
        this.survey = survey;
    }

    public void addAnswer(Question question, int rating) {
        questionRatings.put(question, rating);
    }

    public Map<Question, Integer> getQuestionRatings() {
        return questionRatings;
    }
}
