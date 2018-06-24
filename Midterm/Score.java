package Midterm;

import java.util.ArrayList;

public class Score {
	ArrayList<ArithmeticQuestionBean> questions = new ArrayList<ArithmeticQuestionBean>();
	ArrayList<Integer> answers = new ArrayList<Integer>();
	String name;
	int amountOfQuestions;
	int numberCorrect = 0;
	double percentCorrect;
	
	public Score(ArithmeticQuestionBean questionList, Integer answer, String name) {
		add(questionList, answer);
//		this.amountOfQuestions = questionList.size();//size of amount of question in questionList
//		for(int i = 0; i < questionList.size(); i++){
//			if(questionList.get(i).answer == answers.get(i)){
//				numberCorrect++;
//			}
//		}
//		
//		
		this.name = name;
//		this.questions = questionList;
//		this.answers = answers;
	}
	
	public void add(ArithmeticQuestionBean questionList, Integer answer){
		questions.add(questionList);
		answers.add(answer);
		
	}
	public ArrayList<ArithmeticQuestionBean> getQuestions() {
		return questions;
	}
	public ArrayList<Integer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Integer> answers) {
		this.answers = answers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmountOfQuestions() {
		return questions.size();//size of amount of question in questionList;
	}
	public void setAmountOfQuestions(int amountOfQuestions) {
		this.amountOfQuestions = amountOfQuestions;
	}
	public int getNumberCorrect() {
		int count = 0;
		for(int i = 0; i < questions.size(); i++){
			if(questions.get(i).answer == answers.get(i)){
				count++;
			}
		}
		return count;
	}
	public void setNumberCorrect(int numberCorrect) {
		this.numberCorrect = numberCorrect;
	}
	public double getPercentCorrect() {
		double ratio = getNumberCorrect() / (( 1.0)*getAmountOfQuestions());
		
		return  100* ratio;
	}
	public void setPercentCorrect(double percentCorrect) {
		this.percentCorrect = percentCorrect;
	}
	public void setQuestions(ArrayList<ArithmeticQuestionBean> questions) {
		this.questions = questions;
	}
	public ArrayList<Integer> getAnswer() {
		return answers;
	}
	public void setAnswer(ArrayList<Integer> answers) {
		this.answers = answers;
	}

}
