package Design_questions.ratingService;

import java.util.ArrayList;
import java.util.List;

public class Survey {
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Survey(String title) {
        this.title = title;
    }

    public void addQuestion(String text) {
        questions.add(new Question(text));
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
