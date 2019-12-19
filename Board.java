package TicTac;

public class Board {
	private char board[][];
	private int boardsize=3;
	char p1symbol,p2symbol;
	int count;
	public final static int player_1_wins=1;
	public final static int player_2_wins=2;
	public final static int draw=3;
	public final static int incomplete=4;
	public final static int invalid=5;
	
	public Board(char p1symbol,char p2symbol) {
		board=new char[boardsize][boardsize];
		for(int i=0;i<boardsize;i++) {
			for(int j=0;j<boardsize;j++) {
				board[i][j]=' ';
			}
		}
		this.p1symbol=p1symbol;
		this.p2symbol=p2symbol;
	}
	public int move(char symbol,int x,int y) {
		if(x<0|| y<0 || x>=boardsize  || y>=boardsize || board[x][y]!=' ') {
			return invalid;
		}
		board[x][y]=symbol;
		count++;
		
		//check row
		if(board[x][0] == board[x][1] && board[x][0] == board[x][2] ) {
		return symbol == p1symbol ? player_1_wins:player_2_wins;	
		}
		//check column
		if(board[0][y] == board[1][y] && board[0][y] == board[2][y] ) {
			return symbol == p1symbol ? player_1_wins:player_2_wins;	
		}
		//check diagonal
		if(board[0][0] !=' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2] ) {
			return symbol == p1symbol ? player_1_wins:player_2_wins;	
		}
		//check diagonal
		if(board[0][2] !=' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0] ) {
			return symbol == p1symbol ? player_1_wins:player_2_wins;	
		}
		
		if(count == boardsize*boardsize) {
			return draw;
		}
		
		return incomplete;
}
	public void print() {
		System.out.println("......................");
		for(int i=0;i<boardsize;i++) {
			for(int j=0;j<boardsize;j++) {
				System.out.print("| "+board[i][j]+" |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("......................");
	}
	
	
}
