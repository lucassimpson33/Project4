package edu.ilstu.linkedlist.chutesandladders;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
	Square start;
	ArrayList <Square> positions;
	int curPlayerPos;
	
/**
 * •	A Constructor that:
o	Takes number of players and instantiates the players ArrayList with that number.
o	Generates a new board by creating 100 squares.
	It should assign each square a number sequentially from 1 to 100
	Make connections between the squares
	Randomly assign a jump value. Make sure that the player will not jump out of the board. The chances of getting a zero jump should be 75%.

 * @param players
 */
	public Game(int players)
	{
		positions = new ArrayList<>(players);
		for(int i = 0; i < players; i++)
		{
			
			Square player = null;
			positions.add(player);
		}
		int jump = calculateJump(1);
		Square start = new Square(1, jump, null);
		Square current = start;
		
		for(Square person: positions)
		{
			person = start;
		}
		
		
		for(int i = 2; i < 101; i++)
		{
			int nextJump = calculateJump(i);
			Square next = new Square(i, nextJump, current );
			current.nextSquare = next;
			current = next;
			
		}
	
	}
	public void play()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Press any key to roll the die:");
		scan.nextLine();
		Random rand = new Random();
		int randNum = rand.nextInt(6 - 1 + 1) + 1;
		
		
		
	}
	
	private void move(int playerNum, int jumps)
	{
		Square player = positions.get(playerNum);
		for(int i = 0; i < jumps; i++)
		{
			player = player.nextSquare;
		}
		
	}
	private int calcSign()
	{
		Random rand = new Random();
		int randNum = rand.nextInt(2);
		int sign = -1;
		 if(randNum == 1)
		{
			sign = 1;
		}
		 return sign;
	}
	
	private int generatePercentage()
	{
		Random rand = new Random();
		return rand.nextInt(101);
	}
	
	public int calculateJump(int curSquare)
	{
		int number = generatePercentage();
		int num = 0;
		if(number >= 75)
		{
			Random rand = new Random();
			num = rand.nextInt(101);
			int sign = calcSign();
			if(sign > 0)
			{
				while(num >= (100 - curSquare))
				{
				
					num = rand.nextInt(101);
				
				}
			}
			else if(sign < 0)
			{
				
				while(num >= curSquare)
				{
					num = rand.nextInt(101);
				}
				num *= -1;
			}
			
			
		}
		
		return num;
	}
	
	 
	
	
	
	
	
	
	
	
	private static class Square {
		Square prevSquare;
		Square nextSquare;
		int currentSquare;
		int jumpVal;
		//o	A constructor that will take the square number, the jump value, and the previous square reference.
		public Square(int currentSquare, int jumpVal, Square prevSquare )
		{
			this.currentSquare = currentSquare; 
			this.jumpVal = jumpVal;
			this.prevSquare = prevSquare;
		}
		
		
		

	}
}
