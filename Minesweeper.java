import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;


 abstract class CL implements ActionListener {
//	private String str;
	private int row;
	private int col;
	public CL(int row, int col) {
		this.row = row;
		this.col = col;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		
		this.CListener(this.row,this.col);
	}
	public abstract void CListener(int row, int col);
	
	
	
	

}
 class Grid {
	
	private boolean[][] bombGrid;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
//	Grid(): 							//10 rows, 10 columns, (10 x 10 Grid), 25 bombs
	public Grid() {
		this.numRows=10;
		this.numColumns=10;
		this.bombGrid= new boolean[10][10];
		this.countGrid= new int[10][10];
		this.numBombs= 25;
		createBombGrid();
		createCountGrid();
	}
//	Grid(int rows, int columns): 				//(rows x columns Grid), default value of 25 bombs 
public Grid(int numRows, int numColumns) {
	super();
	this.numRows = numRows;
	this.numColumns = numColumns;
	this.bombGrid= new boolean[this.numRows][this.numColumns];
	this.countGrid= new int[this.numRows][this.numColumns];
	this.numBombs= 25;
	createBombGrid();
	createCountGrid();
//	createBombGrid();
}
public Grid(int numRows, int numColumns, int numBombs) {
	super();
	this.numRows = numRows;
	this.numColumns = numColumns;
	this.numBombs = numBombs;
	this.bombGrid= new boolean[this.numRows][this.numColumns];
	this.countGrid= new int[this.numRows][this.numColumns];
	createBombGrid();
	createCountGrid();
////	createBombGrid();
//	
}
public boolean[][] getBombGrid() {
	boolean [][]bomb= new boolean[this.numRows][this.numColumns];
	
	for(int i=0;i<this.numRows;i++) {
		for(int j=0;j<this.numColumns;j++) {
			if(this.bombGrid[i][j]==true) {
				bomb[i][j]= true;
			}else {
				bomb[i][j]= false;
			}
		}
	}
	return bomb;
}
public int[][] getCountGrid() {
	int [][]count= new int[this.numRows][this.numColumns];
	for(int i=0;i<this.numRows;i++) {
		for(int j=0;j<this.numColumns;j++) {
			count[i][j]= this.countGrid[i][j];
		}
	}
	
	return count;
}
public int getNumRows() {
	return numRows;
}
public int getNumColumns() {
	return numColumns;
}
public int getNumBombs() {
	return numBombs;
}
	
public boolean isBombAtLocation(int row, int column) {
	if(bombGrid[row][column]==true) {
		return true;
	}else
		return false;
	
//	return bombGrid[row][column];
}
public int getCountAtLocation(int row, int column) {
	int count=0;
//	00 01 02	00 01
//	10 11 12	10 11
//	20 21 22 
	for(int i=row-1;i<=row+1;i++) {
		for(int j=column-1;j<=column+1;j++) {
			if((i>=0 && i<this.numRows) &&(j>=0 && j<this.numColumns) ) {
				if(bombGrid[i][j]== true) {
				count++;
				}
			}
		}
	}
	

	
	return count;
}

//createBombGrid() : void 	//called by constructors to create and populate the bombGrid
private void createBombGrid() {
	int bombFilled=0;
	int count=0;
	 Random random= new Random();
	while(bombFilled<this.numBombs) {
		int x= random.nextInt(bombGrid.length);
		int y= random.nextInt(bombGrid[x].length);
//		int x= random.nextInt(0, this.numColumns-1);
//		int y= random.nextInt(0,this.numRows-1);
		if(bombGrid[x][y]!= true) {
		bombGrid[x][y] = true;
		bombFilled++;
		}
//		System.out.println();
		
		
	}
	
//	System.out.println("the bombCount is "+count);
	for(int i=0;i<this.numRows;i++) {
		for(int j=0;j<this.numColumns;j++) {
			
			if(bombGrid[i][j]==true) {
				bombGrid[i][j]= true;
			}else {
				bombGrid[i][j]= false;
			}
		}
//		System.out.println();
	}
	
}
//public void printGrid() {
//	for(int i=0;i<this.numRows;i++) {
//		for(int j=0;j<this.numColumns;j++) {
//			
//			System.out.print(bombGrid[i][j]+"\t");
//		}
//		System.out.println();
//	}
//}
//createCountGrid() : void 	//called by constructors to create and populate countGrid from bombGrid

private void createCountGrid() {
	for(int i=0;i<this.numRows;i++) {
		for(int j=0;j<this.numColumns;j++) {
			countGrid[i][j]=this.getCountAtLocation(i, j);
		}
	}
	
}
//	Grid(int rows, int columns, int numBombs): 		//(rows x columns Grid), numBombs as specified
//public void player1Move(int row, int col) {
//	try {
//		if(bombGrid[row][col]== true) {
//			
//			
//		}
//	}
//	
//	// TODO Auto-generated method stub
//	
//}
public void resetGrid() {
	for (int i = 0; i < bombGrid.length; i++) {
		for (int j = 0; j < bombGrid[i].length; j++) {
			bombGrid[i][j] = false;
		}
	}
	this.createBombGrid();
//	Grid grid = new Grid();
	
}

}



class Minesweeper extends JFrame implements ActionListener {
	
	private JButton[][] butto;
	
	private Grid grid;
	
	
	public Minesweeper() {
//		gameInfo = new GameInfo(player1Name, player2Name);
		grid = new Grid();
		
		// Iterate through gameBoard, create each button
		butto = new JButton[grid.getNumRows()][grid.getNumColumns()];
		
		// Use GridLayout(3, 3).
		this.setLayout(new GridLayout(grid.getNumRows(), grid.getNumColumns()));
		
		for (int row = 0; row < butto.length; row++) {
			for (int col = 0; col < butto[row].length; col++) {
				butto[row][col] = new JButton(" ");
//				butto[row][col].setFont(new Font("mono spaced", Font.PLAIN, 100));
				String str= String.valueOf(row)+" - "+ String.valueOf(col);
				butto[row][col].addActionListener(new CL(row, col){

					@Override
					public void CListener(int r, int c) {
						System.out.println("row "+r+" col "+c);
						// TODO Auto-generated method stub
						if(grid.isBombAtLocation(r,c)==true) {
//							butto[r][c].setFont()
							butto[r][c].setText("*");
							butto[r][c].setFont(new Font("Courier", Font.BOLD,30));
//							butto[r][c].setBackground(Color.RED);
							for(int i=0;i<grid.getNumRows();i++) {
								for(int j=0;j<grid.getNumColumns();j++) {
									if(grid.isBombAtLocation(i, j)==true) {
//									butto[i][j].setBackground(Color.RED);
									butto[i][j].setText("*");
									butto[i][j].setFont(new Font("Courier", Font.BOLD,30));
									
									}
								}
							}
							butto[r][c].setIcon(null);
							System.out.println("Check");
							String message= "Game Over";
							
							int response = JOptionPane.showConfirmDialog(null, message + "\n New game?", "Game Over",
									JOptionPane.YES_NO_OPTION);
							if (response == JOptionPane.NO_OPTION) {
								System.exit(0);
							} else {
								grid.resetGrid();
								updateView();
								Minesweeper window = new Minesweeper();
								
								
								
								}
						}
						if(grid.isBombAtLocation(r, c)== false) {
							butto[r][c].setText(String.valueOf(grid.getCountAtLocation(r, c)));
							butto[r][c].setFont(new Font("Courier", Font.BOLD,30));
						}
						
					}
					
				});
				this.add(butto[row][col]);
//				butto[row][col].setText("*");
			}
		}
	}
	
	public static void main(String[] args) {

		
		
		
		Minesweeper window = new Minesweeper();
		
//		window.pack();
		window.setSize(600, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rowClicked = -1;
		int colClicked = -1;
		
		for (int row = 0; row < butto.length; row++) {
			for (int col = 0; col < butto[row].length; col++) {
				if (butto[row][col].equals(e.getSource())) {
					rowClicked = row;
					colClicked = col;
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
	private void updateView() {
		for (int row = 0; row < butto.length; row++) {
			for (int col = 0; col < butto[row].length; col++) {
//				butto[row][col].setText("" + grid.getBombGrid()[row][col]);
				butto[row][col].setText("" );
//				new Grid();
				
				
			}
		}
	}


}


