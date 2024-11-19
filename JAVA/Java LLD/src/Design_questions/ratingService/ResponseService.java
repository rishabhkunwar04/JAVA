package Design_questions.ratingService;

import java.util.List;

public class ResponseService {
    public void submitResponse(Survey survey, List<Integer> ratings) {
        List<Question> questions = survey.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).addRating(ratings.get(i));
        }
    }

    public double getSurveyAverageRating(Survey survey) {
        return survey.getQuestions().stream()
                .mapToDouble(Question::getAverageRating)
                .average()
                .orElse(0);
    }

    public double getQuestionAverageRating(Question question) {
        return question.getAverageRating();
    }
}
