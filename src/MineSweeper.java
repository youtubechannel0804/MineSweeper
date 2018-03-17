public class MineSweeper {

	/*
	 * Assumption:
	 * 
	 * on Board  -1 = Mine Cell
	 * 
	 * on Status 0 = Closed cell ,
	 * 		     1 = Open Cell, 
	 * 			 2 = Mine Flag Cell
	 * 
	 */

	private static final char RIGHT_CLICK = 'R';
	private static final char LEFT_CLICK = 'L';

	public static void main(String[] args) {

		int rows = 9;
		int cols = 9;

		// create Grid for board
		Board board = new Board(rows, cols);
		board.displayBoard();

		// function to automate User input
		while (!board.gameOver) {
			int row = MineSweeperUtil.GenerateRandonNumber(rows);
			int col = MineSweeperUtil.GenerateRandonNumber(cols);
			if (row % 2 == 0 && col % 2 == 1) {
				board.click(row, col, RIGHT_CLICK);
			} else {
				board.click(row, col, LEFT_CLICK);
				//board.click(row, col, LEFT_CLICK);
			}

		}
		// display Status board to check which all cells are open and which all
		// cells has mine flag
		board.displayStatusBoard();
	}

}
