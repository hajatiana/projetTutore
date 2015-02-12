package choquet.model;

import java.util.Vector;

public class Node {
	private String name;
	private float weight;
	private int x;
	private int y;
	private Vector<Node> parents = new Vector<Node>();
	private Vector<Node> childs = new Vector<Node>();

	public void addChild(Node child) {
		childs.add(child);
	}
	public void addParent(Node parent) {
		parents.add(parent);
	}
	public Vector<Node> getChilds() {
		return childs;
	}
	public String getName() {
		return name;
	}
	public Vector<Node> getParents() {
		return parents;
	}
	public float getWeight() {
		return weight;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setChild(Vector<Node> childs) {
		this.childs = childs;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParent(Vector<Node> parents) {
		this.parents = parents;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

}
