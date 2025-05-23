package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int columns, int rows) {
        if (rows < 1 || columns < 1){
            throw new BoardException("erro criado tabuleiro, sem linha e coluna");
        }
        this.columns = columns;
        this.rows = rows;
        this.pieces = new Piece[rows][columns];
    }

    public int getRows() { return rows; }
    public int getColumns() {
        return columns;
    }

    //retorna a peça na localização x da matriz
    public Piece piece(int row, int column) {
        if (!positionExists(row,column)){
            throw new BoardException("posição não existe, erro de digitação");
        }
        return pieces[row][column];
    }
    //sobrecarga
    public Piece piece(Position position) {
        if (!positionExists(position)){
            throw new BoardException("posição não existe, erro de digitação");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("existe uma peça nessa posição -> " + position);
        }
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column) {
        return row >=  0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)){
            throw new BoardException("posição não existe, erro de digitação");
        }
        return piece(position) != null;
    }
}
