import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
	}
	
	@Override
	protected void dfs(int row, int col) {
		Queue<Integer> qp = new LinkedList<>();
		int cell = myGrid[row][col];
		cell = FULL;
		qp.add(cell);
		
		
		// out of bounds?
		if (! inBounds(row,col)) return;
		
		// full or NOT open, don't process
		if (isFull(row, col) || !isOpen(row, col))
			return;
		
		myGrid[row][col] = FULL;
		dfs(row - 1, col);
		dfs(row, col - 1);
		dfs(row, col + 1);
		dfs(row + 1, col);
	}


}
