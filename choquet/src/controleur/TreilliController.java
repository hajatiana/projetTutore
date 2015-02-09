package controleur;

import model.Node;
import model.Step;
import model.Treilli;

public class TreilliController {
	StepController stepController;

	public TreilliController(){
		stepController = new StepController();
	}

	public void showTreilli(Treilli treilli){
		for (Step step : treilli.getSteps()) {
			stepController.showStep(step);
			System.out.println("");
		}
	}

	public Treilli createTreilli(int size){
		char a = 'a';
		Treilli treilli = new Treilli(size);

		// Ici, on initialise la première ligne
		Step firstStep = new Step();
		firstStep.setNumber(1);
		for(int j=0; j<size; j++){
			Node n = new Node();
			n.setName(Character.toString(a++));
			n.setWeight(1);
			firstStep.add(n);
		}
		firstStep.setNumber(1);
		treilli.addStep(firstStep);

		for(int i=1; i<size; i++){
			Step currentStep = new Step();
			currentStep.setNumber(i+1);
			for(int j=0; j<=size-currentStep.getNumber(); j++){
				int max=size-currentStep.getNumber();
				System.out.println("Step"+i+": j="+j+" et max="+max);
				Node nodeJ = firstStep.get(j);
				for(int k=j+1; k<currentStep.getNumber(); k++){
					String name = nodeJ.getName();
					Node node = new Node();
					Node nodeK = firstStep.get(k);
					name+=nodeK.getName();
					node.setName(name);
					node.setWeight(1);
					currentStep.add(node);
				}
			}
			treilli.addStep(currentStep);
		}
		return treilli;
	}

}
