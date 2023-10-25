package com.gamerest.restgame;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Restgame {
    private List<Questions> questions = Questions.createQuestions();
    private List<AllAnswer> answers = AllAnswer.createAnswers();

    private int questionIndex = 0;

    @GetMapping ("/") 
    public String getHome() {

        String htmlMode= "<html><strong>Welcome to question game! Use /questions/{question_id} to search questions</strong> <br>Let's see how good you are</html>";
        String htmlQuestions= "<html><br> ID path = <br> 1. History <br> 2. Geography <br> 3. Math <br> 4. Sports <br> 5. Politics </html>";
        String htmlAnswers ="<html> Write the answer to Postman and remember to change it from GET to POST -> /useranswers/{question_id}/{youranswer}, and you will see if it's right</html>";
        return htmlMode + htmlQuestions + htmlAnswers;  //<br> ja <html> muodoilla yritin tehdä selvemmäksi internetissä. 
    }

    @GetMapping ("/questions/{question_id}")
    public ResponseEntity<Questions>getQuestion(@PathVariable int question_id) {  //Katsoo, että meneehän kysymysten määrä oikein
    if (question_id >= 1 && question_id <= questions.size()) {

        int index = question_id - 1;
        System.out.println("Index: " + index);
        return ResponseEntity.ok(questions.get(index));
    } else {
        return ResponseEntity.notFound().build();
    }
  }

  @GetMapping ("/answers/{answers_id}") //Tämä on periaatteessa turha nyt, kun vastauksen saa postmappingistä. 
  public ResponseEntity<AllAnswer>getAnswers(@PathVariable int answers_id) {
    if (answers_id >= 1 && answers_id <= answers.size()) {
        int indexAnswer = answers_id - 1;
         return ResponseEntity.ok(answers.get(indexAnswer));
     } else {
        return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/useranswers/{question_id}/{useranswer}")
  public ResponseEntity<String> checkAnswer (@PathVariable int question_id, @PathVariable String useranswer) {
    if (question_id >= 0 && question_id <= questions.size()) {
        int index = question_id - 1;
        String correctAnswer = answers.get(index).getAnswer();

        if(correctAnswer.equals(useranswer)) {
            return ResponseEntity.ok("Answer is right.");
        } else {
            return ResponseEntity.ok("Wrong answer. The correct answer is: " + correctAnswer);
        }
    } else {
        return ResponseEntity.ok("Check the question_id parameter");
    }
    System.out.println("tere")
   }
  }
