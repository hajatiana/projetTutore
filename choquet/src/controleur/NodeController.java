package controleur;

import model.Node;

public class NodeController {
	public void showNode(Node node){
		System.out.print("("+node.getName()+";"+node.getWeight()+")");
	}
}
