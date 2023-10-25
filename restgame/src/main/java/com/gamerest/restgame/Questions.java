package com.gamerest.restgame;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Questions {
    private int id;
    private String questionNext;
   // private String correctAnswer;

    public int getId() {
        return id;
    } 
    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionNext() {
        return questionNext;
    }

    public void setQuestionNext(String questionNext) {
        this.questionNext = questionNext;
    }

     public static List<Questions> createQuestions() {
        List<Questions> questions = new ArrayList<>();

     Questions question1 = new Questions();
     question1.setId(1);
     question1.setQuestionNext("Which colour is napoleons white horse?");
     questions.add(question1);

    Questions question2 = new Questions();
     question2.setId(2);
     question2.setQuestionNext("What is kongo's national language?");
     questions.add(question2);
     
    Questions question3 = new Questions();
     question3.setId(3);
     question3.setQuestionNext("How much is 0*1*2/2*3+0");
     questions.add(question3);

    Questions question4 = new Questions();
     question4.setId(4);
     question4.setQuestionNext("What is Finnish nationalSport?");
     questions.add(question4);

    Questions question5 = new Questions();
     question5.setId(5);
     question5.setQuestionNext("Who is the president of Finland?(Name only)");
     questions.add(question5);

     return questions;
     }
}
