class Board {

	Cell[][] boardArray;
	int rows = 0;
	int cols = 0;
	boolean gameOver = false;

	public Board(int gridRows, int gridCols) {
		createBoard(gridRows, gridCols);
	}

	public Cell getCell(int rows, int col) {
		return boardArray[rows][col];
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver() {
		System.out.println("-----GAME OVER------");
		this.gameOver = true;
	}

	Cell[][] createBoard(int gridRows, int gridCols) {
		rows = gridRows;
		cols = gridCols;
		boardArray = new Cell[rows][cols];
		setRowsAndColumns();
		placeMines();
		placeNumbers();
		return boardArray;
	}

	private void setRowsAndColumns() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				boardArray[i][j] = new Cell(i, j, 0);
			}
		}

	}

	private void placeMines() {
		for (int i = 0; i < 9; i++) {
			int row = MineSweeperUtil.GenerateRandonNumber(rows);
			int col = MineSweeperUtil.GenerateRandonNumber(cols);
			boardArray[row][col] = new Cell(row, col, -1);
		}

	}

	private void placeNumbers() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!boardArray[i][j].hasMine()) {
					MineSweeperUtil.findNeighbourCells(i, j, this);
				}
			}
		}
	}

	public void click(int i, int j, char click) {
		if (!gameOver) {
			System.out.println("user Input is " + i + " "+j +" " +click);
			IAction action = null;
			if (click == 'L') {
				action = new LeftClickAction(i, j, this);
				action.action();
			} else if (click == 'R') {
				action = new RightClickAction(i, j, this);
				action.action();
			}
		}
	}

	public void displayStatusBoard() {
		System.out.println("---------STATUS BOARD -------------------------------");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(boardArray[i][j].getStatus() + " ");
			}
			System.out.println("");
		}
	}

	public void displayBoard() {
		System.out.println("--------- BOARD -------------------------------");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int val = getCell(i, j).getVal();
				System.out.print(val != -1 ? " "+val  :val);
			}
			System.out.println("");
		}
	}

}