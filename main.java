package edu.ilstu.linkedlist.chutesandladders;

public class main {

	public static void main(String[] args) {
		Game game = new Game(3);
		int jump = game.calculateJump(50);
		System.out.println(jump);
	}

}
