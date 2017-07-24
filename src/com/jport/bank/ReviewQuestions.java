package com.jport.bank;

import java.util.HashMap;

public class ReviewQuestions {

	private int qid;
	private Question question;
	private int choice;

	@Override
	public String toString() {
		return "ReviewQuestions [qid=" + qid + ", question=" + question + ", choice="
				+ choice + "]";
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

}
