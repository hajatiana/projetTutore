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
			Step currentStep = getPermutation(firstStep, i);
			currentStep.setNumber(i+1);			
			treilli.addStep(currentStep);
		}
		return treilli;
	}
		
	public Step getPermutation(Step tab, int lot){		
		Step result = new Step();		
		Node firstNode = tab.get(0);
		Step temp = (Step) tab.clone();					
		if(lot>0){			
			temp.remove(0);
			Step p = getPermutation(temp,lot-1);			
			for (Node node : p) {		
				Node currentNode = new Node();
				currentNode.setName(firstNode.getName()+node.getName());
				currentNode.setWeight(firstNode.getWeight()+node.getWeight());
				result.add(currentNode);
			}
			if(temp.size()>lot){
				result.addAll(getPermutation(temp,lot));
			}
		}else{
			return temp;
		}
		return result;
	}

}
