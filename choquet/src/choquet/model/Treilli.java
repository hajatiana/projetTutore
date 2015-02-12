package choquet.model;

import java.util.ArrayList;

public class Treilli {
	private int size;
	private int maxStepSize;
	ArrayList<Step> steps;

	public Treilli(int size) {
		super();
		this.size = size;
		steps = new ArrayList<Step>();
	}
	public void addStep(Step step) {
		this.steps.add(step);
	}
	public int getMaxStepSize() {
		return maxStepSize;
	}
	public int getSize() {
		return size;
	}
	public ArrayList<Step> getSteps() {
		return steps;
	}
	public void setMaxStepSize(int maxStepSize) {
		this.maxStepSize = maxStepSize;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public void setSteps(ArrayList<Step> steps) {
		this.steps = steps;
	}
}
