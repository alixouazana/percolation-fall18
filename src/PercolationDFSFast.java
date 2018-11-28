
public class PercolationDFSFast extends PercolationDFS{

	public PercolationDFSFast(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void updateOnOpen(int row, int col) {

			if(row == 0 && isOpen(row,col)) myGrid[row][col] = FULL;

			if(row != 0 && isFull(row-1,col) && isOpen(row,col)) {  
				myGrid[row][col] = FULL;
			}
			if(col != 0 && isFull(row,col-1) && isOpen(row,col)) { 
				myGrid[row][col] = FULL;
			}
			if(col != myGrid[0].length -1 && isFull(row,col+1) && isOpen(row,col)) { 
				myGrid[row][col] = FULL;
			}

			if(isFull(row,col)) dfs(row,col);
		
	}

}


