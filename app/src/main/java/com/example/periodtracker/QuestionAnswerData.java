package com.example.periodtracker;

import java.util.Optional;

public class QuestionAnswerData {
    String question;
    String answer;
    //TODO (matthew fletcher) could add this in the future
    Optional<String> questionImageUrl;

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
