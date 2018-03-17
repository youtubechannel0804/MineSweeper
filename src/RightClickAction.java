
public class RightClickAction implements IAction {
	int row = 0;
	int col = 0;
	Board board = null;

	public RightClickAction(int i, int j, Board boardParam) {
		row = i;
		col = j;
		board = boardParam;
	}

	@Override
	public void action() {
		if(board.getCell(row, col).getStatus() == 0){
			board.getCell(row, col).setStatus(2);
		}
		
	}

}
