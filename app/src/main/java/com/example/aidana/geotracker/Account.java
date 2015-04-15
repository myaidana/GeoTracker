package com.example.aidana.geotracker;

/**
 * Created by erevear on 4/14/15.
 */
public class Account {

    private String userName;
    private String userEmail;
    private String userPassword;
    private String userQuestion;
    private String userAnswer;

    public Account(String name, String email, String password, String question, String answer) {
        userName = name;
        userEmail = email;
        userPassword = password;
        userQuestion = question;
        userAnswer = answer;

    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
