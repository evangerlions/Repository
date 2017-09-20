package com.snake;

import java.util.LinkedList;

public class Snake {

	private LinkedList<Node> body = new LinkedList<>();

	public boolean isEat(Node food, Direction direction) {
		int hx = body.getFirst().getX(), hy = body.getFirst().getY();
		if (hx == food.getX() && hy == food.getY() + 1 && direction == Direction.DOWN) {
			body.addFirst(food);
			return true;
		} else if (hx == food.getX() && hy == food.getY() - 1 && direction == Direction.UP) {
			body.addFirst(food);
			return true;
		} else if (hx == food.getX() + 1 && hy == food.getY() && direction == Direction.LEFT) {
			body.addFirst(food);
			return true;
		} else if (hx == food.getX() - 1 && hy == food.getY() && direction == Direction.RIGHT)

		{
			body.addFirst(food);
			return true;
		}
		return false;
	}
   
	public Node move(Direction direction) {
		// 移动body,返回移动前尾部位置?
		Node temp, lastTail;
		lastTail = body.getLast();
		switch (direction) {
		case UP:
			temp = new Node(getHead().getX(), getHead().getY() + 1);
			body.addFirst(temp);
			body.removeLast();
			break;
		case RIGHT:
			temp = new Node(getHead().getX() + 1, getHead().getY());
			body.addFirst(temp);
			body.removeLast();
			break;
		case DOWN:
			temp = new Node(getHead().getX(), getHead().getY() - 1);
			body.addFirst(temp);
			body.removeLast();
			break;
		case LEFT:
			temp = new Node(getHead().getX() - 1, getHead().getY());
			body.addFirst(temp);
			body.removeLast();
			break;
		}
		return lastTail;
	}

	public Node getHead() {
		// 得到头部位置
		return body.getFirst();
	}

	public Node addTail(Node area) {
		this.body.addLast(area);
		return area;
	}

	public LinkedList<Node> getBody() {
		return body;
	}
}
