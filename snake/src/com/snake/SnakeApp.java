package com.snake;

import java.awt.*;
import java.awt.event.KeyListener;

import javax.swing.*;

public class SnakeApp {

	public void init() {
		// ������Ϸ����
		JFrame window = new JFrame("̰����");
		// �������̺�̰����
		Grid grid = new Grid(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT);
		GameView gameView;
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		gameView = new GameView(grid);
		gameView.init();

		GameController gameController = new GameController(grid, gameView);
		window.addKeyListener(gameController);
		// MyThread thread = new MyThread();
		new Thread(gameController).start();
		Container contentPane = window.getContentPane();

		// ����Grid��ʼ��gamaView
		// ����gameView��JPanel�Ĵ�С
		gameView.getCanvas().setPreferredSize(new Dimension(Settings.DEFAULT_GRID_SCREEN_WIDTH, Settings.DEFAULT_GRID_SCREEN_HEIGHT));

		// ��gameView��JPanel���뵽������
		contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);

		window.pack();
	}

	public static void main(String[] args) {
		SnakeApp snakeApp = new SnakeApp();
		snakeApp.init();

	}

}
