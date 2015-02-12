package choquet.controleur;

import choquet.model.Node;

public class NodeController {
	public String getNodeName(Node node){
		StringBuffer sb = new StringBuffer("");
		sb.append("{");
		for(int i=0;i<node.getName().length();i++){
			if(i!=0) {
				sb.append(",");
			}
			sb.append(node.getName().charAt(i));
		}
		sb.append("}");
		return sb.toString();
	}

	public void showNode(Node node){
		System.out.print("("+node.getName()+";"+node.getWeight()+")");
	}
}
