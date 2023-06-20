package com.example.kiddolearn;

import java.util.ArrayList;
import java.util.List;

public class QuestionMath {
     private String question;
     private List<Answers> mListAnswers = new ArrayList<>();

    public QuestionMath(String question, List<Answers> mListAnswers) {
        this.question = question;
        this.mListAnswers = mListAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answers> getmListAnswers() {
        return mListAnswers;
    }

    public void setmListAnswers(List<Answers> mListAnswers) {
        this.mListAnswers = mListAnswers;
    }

    static class Answers{
        String Conten ;
        boolean istrue;

        public Answers(String conten, boolean istrue) {
            Conten = conten;
            this.istrue = istrue;
        }

        public String getConten() {
            return Conten;
        }

        public void setConten(String conten) {
            Conten = conten;
        }

        public boolean isIstrue() {
            return istrue;
        }

        public void setIstrue(boolean istrue) {
            this.istrue = istrue;
        }
    }



}


