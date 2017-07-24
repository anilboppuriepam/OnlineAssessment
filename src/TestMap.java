import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.jport.bank.Question;
import com.jport.bank.ReviewQuestions;

public class TestMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Question> review = new HashMap<Integer, Question>();

	

		Question reviewQuestion = new Question();
		reviewQuestion.setQbid(1);
		reviewQuestion.setQuestion("who invented Java");
		reviewQuestion.setChoice1("tom");
		reviewQuestion.setChoice2("dick");
		reviewQuestion.setChoice3("harry");
		reviewQuestion.setChoice4("tin");
		reviewQuestion.setChoice5("gose");
		reviewQuestion.setAnswer(5);
		
        review.put(4,reviewQuestion);
		
		
		Question reviewQuestion2 = new Question();
		reviewQuestion.setQbid(2);
		reviewQuestion2.setQuestion("who invented Java");
		reviewQuestion2.setChoice1("tom");
		reviewQuestion2.setChoice2("dick");
		reviewQuestion2.setChoice3("harry");
		reviewQuestion2.setChoice4("tin");
		reviewQuestion2.setChoice5("gose");
		reviewQuestion2.setAnswer(5);
		
		review.put(2, reviewQuestion2);
		
		Set keys = review.keySet();
		Iterator iter = keys.iterator();
		while(iter.hasNext()){
			
	Integer key =(Integer)  iter.next();
	Question question = review.get(key);
	System.out.println(question.getQuestion());
//	System.out.println(question);
		}
		
		

	}

}
