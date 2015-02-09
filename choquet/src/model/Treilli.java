package model;

import java.util.ArrayList;

public class Treilli {
	private int size;
	ArrayList<Step> steps;

	public Treilli(int size) {
		super();
		this.size = size;
		steps = new ArrayList<Step>();
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ArrayList<Step> getSteps() {
		return steps;
	}
	public void setSteps(ArrayList<Step> steps) {
		this.steps = steps;
	}

	public void addStep(Step step) {
		this.steps.add(step);
	}
}
