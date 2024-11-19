package Design_questions.ratingService;

import java.util.ArrayList;
import java.util.List;

public class SurveyService {
    private List<Survey> surveys = new ArrayList<>();

    public Survey createSurvey(String title) {
        Survey survey = new Survey(title);
        surveys.add(survey);
        return survey;
    }

    public void addQuestion(Survey survey, String questionText) {
        survey.addQuestion(questionText);
    }
}
