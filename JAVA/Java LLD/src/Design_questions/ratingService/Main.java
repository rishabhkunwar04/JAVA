package Design_questions.ratingService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SurveyService surveyService = new SurveyService();
        ResponseService responseService = new ResponseService();

        // Admin creates a survey
        Survey survey = surveyService.createSurvey("Customer Satisfaction Survey");

        // Add questions to the survey
        surveyService.addQuestion(survey, "Rate our service quality");
        surveyService.addQuestion(survey, "Rate our response time");

        // User submits a response with ratings
        responseService.submitResponse(survey, Arrays.asList(4, 5));

        // User submits another response
        responseService.submitResponse(survey, Arrays.asList(3, 4));

        // Calculate and print average ratings
        System.out.println("Average Survey Rating: " + responseService.getSurveyAverageRating(survey));
        for (Question question : survey.getQuestions()) {
            System.out.println("Average Rating for Question: " + question.getAverageRating());
        }
    }
}
