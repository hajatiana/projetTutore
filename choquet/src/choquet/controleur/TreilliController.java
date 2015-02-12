package choquet.controleur;

import choquet.model.Node;
import choquet.model.Step;
import choquet.model.Treilli;

public class TreilliController {
	StepController stepController;

	public TreilliController(){
		stepController = new StepController();
	}

	public Treilli createTreilli(int size){
		char a = 'a';
		Treilli treilli = new Treilli(size);
		Step firstStep = new Step();
		Step previewStep = new Step();
		firstStep.setNumber(1);
		for(int j=0; j<size; j++){
			Node n = new Node();
			n.setName(Character.toString(a++));
			n.setWeight((float)1/size);
			firstStep.add(n);
		}
		firstStep.setNumber(1);
		treilli.addStep(firstStep);
		previewStep=firstStep;
		int max=size;

		for(int i=1; i<size; i++){
			Step currentStep = getPermutation(firstStep, i);
			currentStep.setNumber(i+1);
			treilli.addStep(currentStep);
			for (Node node : currentStep) {
				for (Node nodePrev : previewStep) {
					for(int j=0; j<nodePrev.getName().length(); j++){
						if(findName(nodePrev.getName(), node.getName())){
							node.addParent(nodePrev);
							nodePrev.addChild(node);
						}
					}
				}
			}
			if(currentStep.size()>max) {
				max=currentStep.size();
			}
			previewStep=currentStep;
		}
		treilli.setMaxStepSize(max);
		return treilli;
	}

	public boolean findName(String prevName, String currentName){
		for(int i=0; i<prevName.length(); i++){
			if(currentName.indexOf(prevName.charAt(i))==-1){
				return false;
			}
		}
		return true;
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

	public void showTreilli(Treilli treilli){
		for (Step step : treilli.getSteps()) {
			stepController.showStep(step);
			System.out.println("");
		}
	}

}
