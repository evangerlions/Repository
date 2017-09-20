package com.snake;

public class Node {

	private  int x;
	private  int y;
	public Node(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public Node() {
		this.x = 0;
		this.y = 0;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	} 
	public void setXY(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
