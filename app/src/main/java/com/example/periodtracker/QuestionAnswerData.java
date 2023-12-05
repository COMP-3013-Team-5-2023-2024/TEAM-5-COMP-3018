package com.example.periodtracker;

import java.util.Optional;

public class QuestionAnswerData {
    private String question;
    private String answer;
    //TODO could add images to the data
    private Optional<String> questionImageUrl;


    /**
     * Simple storage class
     *
     * @param question
     * @param answer
     * @param imageUrl
     */
    QuestionAnswerData(String question, String answer, Optional<String> imageUrl) {
        this.question = question;
        this.answer = answer;
        this.questionImageUrl = imageUrl;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Optional<String> getQuestionImageUrl() {
        return questionImageUrl;
    }

    public void setQuestionImageUrl(Optional<String> questionImageUrl) {
        this.questionImageUrl = questionImageUrl;
    }
}
