package com.snake;

import javax.swing.*;
import java.awt.*;

public class GameView {

	 
    private final Grid grid;
    private final int DEFAULT_NODE_SIZE = 50;
    public GameView(Grid grid) {
        this.grid = grid;
    }

    public void draw(Graphics graphics) {
        drawSnake(graphics, grid.getSnake());
        drawFood(graphics, grid.getFood());
        drawGridBackground(graphics);
    }
    private void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
		int size = DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size, size , size );
    }


    private void drawCircle(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = DEFAULT_NODE_SIZE;
        graphics.fillOval(squareArea.getX() * size-1, squareArea.getY() * size-1, size-1, size-1);
    }

    public void drawSnake(Graphics graphics, Snake snake) {
    	Color black = new Color(255,255,0);
    	Node temp = new Node();
    	for(int i=0 ; i<=grid.getWidth() ; i++)
    	{
    		for(int j=0 ; j<=grid.getHeight() ; j++)
    		{
    			if(grid.status[i][j])
        		{
    				temp.setXY(i, j);
    				drawSquare(graphics,temp,black);
        		}	
    		}
    	}
    }
    public void drawFood(Graphics graphics, Node squareArea) {
    	Color red = new Color(255,0 ,0);
    	int x = grid.getFood().getX() , y = grid.getFood().getY();
    	Node temp = new Node(x,y);
    	drawCircle(graphics,temp,red);
    }

    public void drawGridBackground(Graphics graphics) {
    	Color white = new Color(0,0,0);
    	Node temp = new Node();
    	for(int i=0 ; i<=grid.getWidth() ; i++)
    	{
    		for(int j = 0;j<=grid.getHeight() ; j++)
    		{
    			temp.setXY(i,j);
        		drawSquare(graphics,temp,white);
    		}
    	}
    }
	
	
    private JPanel canvas;

    public void init() {
        canvas = new JPanel() {
            @Override
//            public void paintComponent(Graphics graphics) {
//                drawGridBackground(graphics);
//                drawSnake(graphics, grid.getSnake());
//                drawFood(graphics, grid.getFood());
//            }
            
            public void paint(Graphics graphics) {
            	drawGridBackground(graphics);
            	drawSnake(graphics, grid.getSnake());
                drawFood(graphics, grid.getFood());
//                System.out.println("周凯");
//                System.out.println(grid.getSnake().getHead().getX());
//                for(Node tempNode:grid.getSnake().getBody()) {
//                	System.out.println(tempNode.getX());
//                }
            }
            
        };
    }

    public void draw() {
        canvas.repaint();
    }
    
    public void showGameOverMessage() {

    	 JOptionPane.showMessageDialog(null, "游戏结束", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public JPanel getCanvas() {
        return canvas;
    }
}
