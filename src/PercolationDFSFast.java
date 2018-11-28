
public class PercolationDFSFast extends PercolationDFS{

	public PercolationDFSFast(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void updateOnOpen(int row, int col) {
		if(row == 0 && myGrid[row][col] == OPEN) myGrid[row][col] = FULL;
		
		if(myGrid[row-1][col] == FULL && myGrid[row][col] == OPEN) {  
			myGrid[row][col] = FULL;
		}
		if(myGrid[row][col+1] == FULL && myGrid[row][col] == OPEN) { 
			myGrid[row][col] = FULL;
		}
		if(myGrid[row][col-1] == FULL && myGrid[row][col] == OPEN) { 
			myGrid[row][col] = FULL;
		}
		
		if(myGrid[row][col]== FULL) dfs(row,col);
	}

}


