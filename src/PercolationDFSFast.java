
public class PercolationDFSFast extends PercolationDFS{

	public PercolationDFSFast(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void updateOnOpen(int row, int col) {
			if(row == 0 || isFull(row+1, col) || isFull(row,col+1) || isFull(row-1,col) || isFull(row,col-1)) {
				dfs(row,col);
			}
		
	}

}


