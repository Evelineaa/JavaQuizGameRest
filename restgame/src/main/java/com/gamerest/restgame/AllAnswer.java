package com.gamerest.restgame;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllAnswer {
    private int id;
    private String answer;

    public int getId() {
        return id;
    } 
    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
     return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static List<AllAnswer> createAnswers() {
        List<AllAnswer> answers = new ArrayList<>();

     AllAnswer answers1 = new AllAnswer();
     answers1.setId(1);
     answers1.setAnswer("White");
     answers.add(answers1);

     AllAnswer answers2 = new AllAnswer();
     answers2.setId(2);
     answers2.setAnswer("France");
     answers.add(answers2);

     AllAnswer answers3 = new AllAnswer();
     answers3.setId(3);
     answers3.setAnswer("0");
     answers.add(answers3);

     AllAnswer answers4 = new AllAnswer();
     answers4.setId(4);
     answers4.setAnswer("baseball");
     answers.add(answers4);

     AllAnswer answers5 = new AllAnswer();
     answers5.setId(5);
     answers5.setAnswer("Sauli");
     answers.add(answers5);

     return answers;
     }
}
