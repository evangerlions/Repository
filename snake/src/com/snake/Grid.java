package com.snake;

import java.util.Arrays;

public class Grid {

	public final boolean status[][];
	private final int height, width;

	private Snake snake;
	private Node food;

	// 初始方向默认设置向右
	private Direction snakeDirection = Direction.RIGHT;

	public Grid(int width, int height) {
		this.height = height;
		this.width = width;

		status = new boolean[width + 1][height + 1];
		int i;
		for (i = 0; i < width; i++) {
			Arrays.fill(status[i], false);
		}
		initSnake();
		createFood();
	}

	private Snake initSnake() {
		snake = new Snake();
		// 设置snake的body 更新棋盘的覆盖状态
		Node Head = new Node(width / 3, height / 2);
		status[width / 3][height / 2] = true;
		snake.getBody().addFirst(Head);
		for (int i = 0; i <= (width / 3); i++) {
			snake.addTail(new Node(width / 3 - i, height / 2));
			status[i][height / 2] = true;
		}
		return snake;
	}

	public Node createFood() {
		int x = 0, y = 0;
		x = (int) (Math.random() * width);
		y = (int) (Math.random() * height);
		if (!status[x][y]) {
			food = new Node(x, y);
		} else {
			createFood();
		}
		return food;
	}

	public boolean nextRound() {
		// 按当前方向移动贪吃蛇
		if (snake.isEat(food, snakeDirection)) {
			status[food.getX()][food.getY()] = true;
			createFood();
			return true;
		} else {
			Node lastNode;
			int tx, ty;
			lastNode = snake.move(snakeDirection);
			tx = snake.getHead().getX();
			ty = snake.getHead().getY();
			if (tx < width && ty < height && tx >= 0 && ty >= 0 && !status[tx][ty] ) {
				status[lastNode.getX()][lastNode.getY()] = false; // 尾结点状态更新
				status[tx][ty] = true;// 头结点状态更新
				return true;
			} else {
				return false;
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Node getFood() {
		return food;
	}

	public Snake getSnake() {
		return snake;
	}

	public Grid getGrid() {
		return this;
	}

	public Direction getDirection() {
		return snakeDirection;
	}

	public void changeDirection(Direction direction) {
		switch (direction) {
		case UP:
			if(snakeDirection !=Direction.DOWN ) {
				snakeDirection = Direction.UP;
			}
			break;
		case RIGHT:
			if(snakeDirection != Direction.LEFT ) {
			snakeDirection = Direction.RIGHT;
			}
			break;
		case DOWN:
			if(snakeDirection != Direction.UP ) {
			snakeDirection = Direction.DOWN;
			}
			break;
		case LEFT:
			if(snakeDirection !=Direction.RIGHT ) {
			snakeDirection = Direction.LEFT;
			}
			break;
		}
	}

}
