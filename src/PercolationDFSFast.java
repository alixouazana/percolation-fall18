
public class PercolationDFSFast extends PercolationDFS{

	public PercolationDFSFast(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void updateOnOpen(int row, int col) {
			
		
			if(row == 0) {
				dfs(row,col);
			}
			if(row !=0 && isFull(row-1,col)) {
				dfs(row,col);
			}
			if(row != myGrid.length && isFull(row+1, col)){
				dfs(row,col);
			}
			
			if(col != 0 && isFull(row,col-1)) {
				dfs(row,col);
			}
			if(col != myGrid[0].length && isFull(row,col+1)) {
				dfs(row,col);
			}
			
			
		
	}

}


