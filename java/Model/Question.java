package Model;

import java.util.List;

public class Question {
	int Question_id;
	String  Question_title;
	int subject_id;
	String subject;
	int optionone_id;
	int optiontwo_id;
	int optionthree_id;
	int answeroption_id;
	String questioncode;
	String description;//optionone
	String descriptiontwo;//optiontwo
	String descriptionthree;//optionthree
	String answerdescription;//answeroption
	String score;
	public int getQuestion_id() {
		return Question_id;
	}
	public void setQuestion_id(int question_id) {
		Question_id = question_id;
	}
	public String getQuestion_title() {
		return Question_title;
	}
	public void setQuestion_title(String question_title) {
		Question_title = question_title;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getOptionone_id() {
		return optionone_id;
	}
	public void setOptionone_id(int optionone_id) {
		this.optionone_id = optionone_id;
	}
	public int getOptiontwo_id() {
		return optiontwo_id;
	}
	public void setOptiontwo_id(int optiontwo_id) {
		this.optiontwo_id = optiontwo_id;
	}
	public int getOptionthree_id() {
		return optionthree_id;
	}
	public void setOptionthree_id(int optionthree_id) {
		this.optionthree_id = optionthree_id;
	}
	public int getAnsweroption_id() {
		return answeroption_id;
	}
	public void setAnsweroption_id(int answeroption_id) {
		this.answeroption_id = answeroption_id;
	}
	public String getQuestioncode() {
		return questioncode;
	}
	public void setQuestioncode(String questioncode) {
		this.questioncode = questioncode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescriptiontwo() {
		return descriptiontwo;
	}
	public void setDescriptiontwo(String descriptiontwo) {
		this.descriptiontwo = descriptiontwo;
	}
	public String getDescriptionthree() {
		return descriptionthree;
	}
	public void setDescriptionthree(String descriptionthree) {
		this.descriptionthree = descriptionthree;
	}
	public String getAnswerdescription() {
		return answerdescription;
	}
	public void setAnswerdescription(String answerdescription) {
		this.answerdescription = answerdescription;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
	  private List<String> shuffledOptions;

	    public List<String> getShuffledOptions() {
	        return shuffledOptions;
	    }

	    public void setShuffledOptions(List<String> shuffledOptions) {
	        this.shuffledOptions = shuffledOptions;
	    }
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
	
	
	
}
