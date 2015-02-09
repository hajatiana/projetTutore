package controleur;

import model.Node;
import model.Step;

public class StepController {
	private NodeController nodeController;

	public StepController(){
		nodeController = new NodeController();
	}

	public void showStep(Step step){
		System.out.print("Step"+step.getNumber()+": ");
		for (Node node : step) {
			nodeController.showNode(node);
			System.out.print(" ");
		}
	}
}
