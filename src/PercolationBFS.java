import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
	}
	
	@Override
	protected void dfs(int row, int col) {
		// out of bounds?
		if (! inBounds(row,col)) return;
		
		int size = myGrid.length;
		Queue<Integer> q = new LinkedList<>();
		
		myGrid[row][col] = FULL;
		q.add(myGrid[row][col]);
		
		while(q.size()!=0) {
			int newcell = q.remove();
			row = newcell/size;
			col = newcell%size;

			if(inBounds(row-1, col) && isOpen(row-1, col) && !isFull(row, col)) {
				q.add(myGrid[row-1][col]);
			}
			if(inBounds(row, col-1) && isOpen(row, col-1) && !isFull(row, col-1)) {
				q.add(myGrid[row][col-1]);
			}
			if(inBounds(row, col+1) && isOpen(row, col+1) && !isFull(row, col+1)) {
				q.add(myGrid[row][col+1]);
			}	

			if(inBounds(row+1, col) && isOpen(row+1, col) && !isFull(row+1, col)) {
				q.add(myGrid[row+1][col]);
			}
		}
		
	
	}


}
