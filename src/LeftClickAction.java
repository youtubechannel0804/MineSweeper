public class LeftClickAction implements IAction {

	int row = 0;
	int col = 0;
	Board board = null;

	public LeftClickAction(int i, int j, Board boardParam) {
		row = i;
		col = j;
		board = boardParam;
	}

	@Override
	public void action() {
		leftClick();
	}

	private void openAllCells() {
		board.getCell(row, col).setStatus(1);
		if (board.getCell(row, col).getVal() == 0) {
			checkNeighBourCell(row, col);
			System.out.println("cell " + row + " , " + col + " is All opened");
		}
		board.displayStatusBoard();
	}

	private void checkNeighBourCell(int row, int col) {
		for (int i = 0; i < MineSweeperUtil.ROWS.length; i++) {
			int xVal = row + MineSweeperUtil.ROWS[i];
			int yVal = col + MineSweeperUtil.COLS[i];
			if (MineSweeperUtil.isValid(xVal, yVal, board.rows)) {
				Cell cell = board.getCell(xVal, yVal);
				if (cell.getVal() > 0) {
					continue;
				}
				if (cell.getVal() == 0 && cell.getStatus() == 0) {
					cell.setStatus(1);
					checkNeighBourCell(xVal, yVal);
				}
			}
		}
	}

	private void leftClick() {
		MineSweeperUtil.checkGameOver(row, col, board);
		if (!board.gameOver) {
			if (board.getCell(row, col).getStatus() == 1 && board.getCell(row, col).getVal() != 0) {
				Status status = MineSweeperUtil.checkStatusOfNeighbourCell(row, col, board);
				if (status.mineCellcount > 0 && status.closedCellCount > 0) {
					if (status.mineCellcount == board.getCell(row, col).getVal()) {

						// mine location is correct then predicateOne

						for (int k = 0; k < status.closedCellCount; k++) {
							int x = status.closedCells[k][0];
							int y = status.closedCells[k][1];
							if (board.getCell(x, y).getVal() != -1) {
								board.getCell(x, y).setStatus(1);
							} else if (board.getCell(x, y).getVal() == -1) {
								board.setGameOver();
								return;
							}

						}
					} else if (status.mineCellcount > board.getCell(row, col).getVal()) {
						board.setGameOver();
						return;
					}
				}
				// else {
				// System.out.println("No closed cells for " + row + " , " +
				// col);
				// }
			} // if cell is closed then open it
			else if (board.getCell(row, col).getStatus() == 0) {
				openAllCells();
				// System.out.println("cell " + row + " , " + col + " is
				// opened");
			}
		}
	}
}
