import java.util.Random;

public class MineSweeperUtil {

	static int[] ROWS = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] COLS = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

	static void findNeighbourCells(int row, int col, Board board) {
		for (int i = 0; i < ROWS.length; i++) {
			int xVal = row + ROWS[i];
			int yVal = col + COLS[i];
			if (isValid(xVal, yVal, board.rows)) {
				Cell cell = board.getCell(xVal, yVal);
				if (cell.getVal() == -1) {
					board.getCell(row, col).setVal(board.getCell(row, col).getVal() + 1);
				}
			}
		}
	}

	static boolean isValid(int xVal, int yVal, int length) {
		if (xVal > -1 && yVal > -1 && xVal < length && yVal < length) {
			return true;
		}
		return false;
	}

	static Status checkStatusOfNeighbourCell(int row, int col, Board board) {
		Status status = new Status();
		int closedCellRowIndex = 0;
		for (int i = 0; i < ROWS.length; i++) {
			int x = row + ROWS[i];
			int y = col + COLS[i];
			if (isValid(x, y, board.rows)) {
				if (board.boardArray[x][y].getStatus() == 2) {
					status.mineCellcount++;
				} else if (board.boardArray[x][y].getStatus() == 0) {
					status.closedCells[closedCellRowIndex][0] = x;
					status.closedCells[closedCellRowIndex][1] = y;
					status.closedCellCount++;// = status.closedCellCount++;
					closedCellRowIndex++;
				}
			}
		}
		return status;

	}

	static int GenerateRandonNumber(int range) {
		Random ran = new Random();
		return ran.nextInt(range);
	}

	static void checkGameOver(int row, int col, Board board) {
		if (board.getCell(row, col).getVal() == -1
				|| (board.getCell(row, col).getVal() != -1 && board.getCell(row, col).getStatus() == '*')) {
			System.out.println("GAME OVER" + " cell " + row + " " + col + " has mine. ");
			board.setGameOver();
		}
	}

}

class Status {
	int[][] closedCells = new int[][] { { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 },
			{ -1, -1 }, { -1, -1 }, { -1, -1 } };
	int closedCellCount = 0;
	int mineCellcount = 0;
}
