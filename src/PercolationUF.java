
public class PercolationUF implements IPercolate{
	
	private boolean myGrid[][];
	private int myOpenCount = 0;
	private IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;
	
	
	public PercolationUF(int size, IUnionFind finder) {
		VTOP = size*size;
		VBOTTOM = size*size+1;
		myGrid = new boolean[size][size];
		finder.initialize(size*size +2);
		myFinder = finder;
		
	}
	
	
	@Override
	public void open(int row, int col) {
		// TODO Auto-generated method stub
		int rc = row*myGrid.length + col;
		int rmc = (row-1)*myGrid.length + col;
		int rcm = row*myGrid.length + (col-1);
		int rcp = row*myGrid.length + (col+1);
		int rpc = (row+1)*myGrid.length + col;
		
				
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		if (isOpen(row,col)) return;
		myGrid[row][col] = true;
		myOpenCount ++;
		if(row == 0) myFinder.union(VTOP,rc);
		if(row == myGrid.length-1) myFinder.union(VBOTTOM, rc);
		if(inBounds(row-1,col) && isOpen(row-1,col)) {
			myFinder.union(rc, rmc);
		}
		if(inBounds(row,col-1) && isOpen(row,col-1)) {
			myFinder.union(rc, rcm);
		}
		if(inBounds(row,col+1) && isOpen(row,col+1)) {
			myFinder.union(rc, rcp);
		}
		if(inBounds(row+1,col) && isOpen(row+1,col)) {
			myFinder.union(rc, rpc);
		}
	}

	@Override
	public boolean isOpen(int row, int col) {
		// TODO Auto-generated method stub
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		return myGrid[row][col];
	}

	


	@Override
	public boolean isFull(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		return myFinder.connected(VTOP, row*myGrid.length + col);
		
	}

	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);
	}

	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	
	private boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
		
	}

}
