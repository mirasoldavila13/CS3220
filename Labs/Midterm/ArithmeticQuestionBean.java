package Midterm;

public class ArithmeticQuestionBean {
	int randNumber1;
	int randNumber2;
	int operation;
	int answer;
	String question;
	
	public ArithmeticQuestionBean(){
		 randNumber1 = 0 + (int) (Math.random() * (60 - 0) + 1);
		 randNumber2 = 0 + (int) (Math.random() * (60 - 0) + 1);
		 operation = (int)(Math.random() * 3) + 1;//1 -4
		//store this result into question, when to the to string method is called we would return the quesiton
		switch (operation) {
		case 1: question = "What is " + randNumber1 + " + " + randNumber2 + " ?";
				answer = randNumber1 + randNumber2; // the correct answer
				//compare the answer from the question to the users input
				
				
				break;
		case 2: question =  "What is " + randNumber1 + " - " + randNumber2 + " ?";
				answer = randNumber1 - randNumber2; // the correct answer
				break;
		case 3: question = "What is " + randNumber1 + " * " + randNumber2 + " ?";
				answer = randNumber1 * randNumber2; // the correct answer
				break;
		case 4: question =  "What is " + randNumber1 + " / " + randNumber2 + " ?";
				answer = randNumber1 / randNumber2; // the correct answer
		
		}
		
		
		
	}
	
	
	
	public ArithmeticQuestionBean(int randNumber1, int randNumber2, int operation) {
		this.randNumber1 = randNumber1;
		this.randNumber2 = randNumber2;
		this.operation = operation;
	}
	public int getAnswer() {
		return answer;
	}


	public void setAnswer(int answer) {
		this.answer = answer;
	}


	public int getRandNumber1() {
		return randNumber1;
	}
	public void setRandNumber1(int randNumber1) {
		this.randNumber1 = randNumber1;
	}
	public int getRandNumber2() {
		return randNumber2;
	}
	public void setRandNumber2(int randNumber2) {
		this.randNumber2 = randNumber2;
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	
	public String toString(){
		
		return question;
		
	
	}

}
