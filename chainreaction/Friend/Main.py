def initialize_board(rows, cols):
    return [[0] * cols for _ in range(rows)]

def print_board(board):
    for row in board:
        print(" ".join(str(cell) for cell in row))

def add_atom(board, row, col):
    board[row][col] += 1
    chain_reaction(board,row,col)

def get_neighbors(row, col):
    neighbors = []
    rows, cols = 5,5

    if row> 0:
        neighbors.append((row - 1, col))

    if row < rows:
        neighbors.append((row + 1, col))

    if col > 0:
        neighbors.append((row, col - 1))

    if col < cols:
        neighbors.append((row, col + 1))

    return neighbors

def chain_reaction(board,row,col):
    updated = True
    while updated:
        if board[row][col]==2 and (row in [0,4] and col in[0,4]):
            board[row][col]=0
            for i in get_neighbors(row,col):
                add_atom(board,i[0],i[1])
        elif board[row][col]==3 and (row in [0,4] and col in [1,2]):
            board[row][col]=0
            for i in get_neighbors(row,col):
                add_atom(board,i[0],i[1])
        elif board[row][col]==4:
            board[row][col]=0
            for i in get_neighbors(row,col):
                add_atom(board,i[0],i[1])
        else:
            updated=False


def main():

    global board 
    board= initialize_board(5, 5)

    while True:
        print_board(board)
        row = int(input("Enter the row to add an atom: "))
        col = int(input("Enter the column to add an atom: "))
        add_atom(board, row, col)
  

if __name__ == "__main__":
    main()
