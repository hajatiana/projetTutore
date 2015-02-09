package model;

import java.util.Vector;

public class Node {
	private String name;
	private int weight;
	private Vector<Node> parent;
	private Vector<Node> child;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Vector<Node> getParent() {
		return parent;
	}
	public void setParent(Vector<Node> parent) {
		this.parent = parent;
	}
	public Vector<Node> getChild() {
		return child;
	}
	public void setChild(Vector<Node> child) {
		this.child = child;
	}
}
