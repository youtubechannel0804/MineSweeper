# MineSweeper

URL to play MIneSweeper online.

https://minesweeper.online/en/

Game Rules:

1. The board is a two dimensional space, which has a predetermined number of mines.
2. Cells has two states, opened and closed.
3. If you left-click on a closed cell:
    a.Cell is empty and opened.
        1.If neighbour cell(s) have mine(s), this opened cell shows neighbour mine count.
        2.If neighbour cells have no mine, all neighbour cells are opened automatically.
    b.Cell has a mine, game ends with FAIL.
4.If you right-click on a closed cell, you put a flag which shows that "I know that cell has a mine".
5.If you multiclick (both right and left click) on a cell which is opened and has at least one mine on its neighbours:
    a.If neighbour cells' total flag count equals to this multi-clicked cell's count and predicted mine locations are true,         all closed and unflagged neighbour cells are opened automatically.
    b.If neighbour cells' total flag count equals to this multi-clicked cell's count and at least one predicted mine location       is wrong, game ends with FAIL.
6.If all cells (without mines) are opened using left clicks and/or multi-clicks, game ends with SUCCESS.

Refrences :
1. http://www.eecs.qmul.ac.uk/~mmh/ItP/resources/MineSweeper/Notes.html
2. 