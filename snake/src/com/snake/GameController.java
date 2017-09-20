package com.snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener, Runnable{

	Grid grid = null;
	GameView gameView = null;

	private boolean running;

	@Override
	public void keyPressed(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		switch (KeyCode) {
		case KeyEvent.VK_UP:
			grid.changeDirection(Direction.DOWN);
			break;
		case KeyEvent.VK_RIGHT:
			grid.changeDirection(Direction.RIGHT);
			break;
		case KeyEvent.VK_DOWN:
			grid.changeDirection(Direction.UP);
			break;
		case KeyEvent.VK_LEFT:
			grid.changeDirection(Direction.LEFT);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public GameController(Grid grid, GameView gameView) {
		super();
		// TODO Auto-generated constructor stub
		this.grid = grid;
		this.gameView = gameView;
		this.running = true;
	}

	@Override
	public void run() {
		while (running) {
			try {
				Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);
			} catch (InterruptedException e) {
				break;
			}
			if (grid.nextRound()) {
				gameView.draw();
			}else{
				gameView.showGameOverMessage();
				break;
			}
		}
		running = false;
	}

}
