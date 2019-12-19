package TicTac;

import java.util.Scanner;

public class TicTacToe {
	private player player1,player2;
	private Board board;
	
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		t.startgame();
	}
	public void startgame() {
		//player input
		Scanner s = new Scanner(System.in);
		player1 = takePlayerinput(1);
		player2 = takePlayerinput(2);
		while(player1.getsymbol() == player2.getsymbol()) {
			System.out.println("oops symbol already taken...please enter new symbol");
			char symbol=s.next().charAt(0);
			player2.setsymbol(symbol);
			
		}
		board = new Board(player1.getsymbol(),player2.getsymbol());
		//conduct game
		int status = Board.incomplete;
		boolean player1turn=true;
		while(status == Board.incomplete || status == Board.invalid) {
			if(player1turn) {
				System.out.println("player1 "+player1.getname()+" turn");
				System.out.println("EnterX");
				int x=s.nextInt();
				System.out.println("EnterY");
				int y=s.nextInt();
				status=board.move(player1.getsymbol(),x,y);
				if(status != Board.invalid) {
					player1turn=false;
					board.print();
				}else {
					System.out.println("invalid move try again!!!");
				}
				
				
				
				
			}else {
				System.out.println("player2 "+player2.getname()+" turn");
				System.out.println("EnterX");
				int x=s.nextInt();
				System.out.println("EnterY");
				int y=s.nextInt();
				status =board.move(player2.getsymbol(),x,y);
				if(status != Board.invalid) {
					player1turn=true;
					board.print();
				}else {
					System.out.println("invalid move try again!!!");
				}
					
			}
		}
		if(status == Board.player_1_wins) {
		
			System.out.println("player 1 "+player1.getname()+" wins");
		}
		if(status == Board.player_2_wins) {
			System.out.println("player 2 "+player2.getname()+" wins");
		}
		if(status == Board.draw) {
			System.out.println("Its Draw");
		}
		
		
		
	}

	private player takePlayerinput(int num) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter name"+num+"player");
		String name = s.nextLine();
		System.out.println("Enter player"+num+"symbol");
		char symbol=s.next().charAt(0);
		player p = new player(name, symbol);
		return p;
		
	}
}
