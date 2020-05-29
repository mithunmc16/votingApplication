package com.example.comp2100_6442;

public class SurveyQuestionModel {
    private String question, optionA, optionB, optionC, optionD;
    private int setno;
    public SurveyQuestionModel(){
        //for firebase
    }



    public SurveyQuestionModel(String question, String optionA, String optionB, String optionC, String optionD, int setno) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.setno = setno;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
    public int getSetno() {
        return setno;
    }

    public void setSetno(int setno) {
        this.setno = setno;
    }
}
