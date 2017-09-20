package com.snake;

import java.awt.*;
import java.awt.event.KeyListener;

import javax.swing.*;

public class SnakeApp {

	public void init() {
		// 创建游戏窗体
		JFrame window = new JFrame("贪吃蛇");
		// 画出棋盘和贪吃蛇
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

		// 基于Grid初始化gamaView
		// 设置gameView中JPanel的大小
		gameView.getCanvas().setPreferredSize(new Dimension(Settings.DEFAULT_GRID_SCREEN_WIDTH, Settings.DEFAULT_GRID_SCREEN_HEIGHT));

		// 将gameView中JPanel加入到窗口中
		contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);

		window.pack();
	}

	public static void main(String[] args) {
		SnakeApp snakeApp = new SnakeApp();
		snakeApp.init();

	}

}
