package checkmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckMateApplication.class, args);
	}

}



//Entities
//User → Exam (Teacher creates exam)
//Exam → Question (1-to-many)
//StudentSubmission → Exam & User
//StudentSubmission → AnswerSegment (1-to-many)
//AnswerSegment → Question
//AnswerSegment → Evaluation
//Evaluation → EvaluationAudit

