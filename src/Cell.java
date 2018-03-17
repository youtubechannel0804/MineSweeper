class Cell {
	int x;
	int y;
	int val = 0;
	int status = 0;

	public Cell(int row, int col, int value) {
		x = row;
		y = col;
		val = value;
	}
	
	

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	boolean hasMine() {
		return val == -1;
	}

	boolean isEmpty() {
		return val == 0;
	}

	boolean hasNumber() {
		return val > 0;
	}

	boolean isOpen() {
		return status == 1;
	}

	boolean isClosed() {
		return status == 0;
	}

	boolean isUserPlacedMine() {
		return status == 2;
	}
}

