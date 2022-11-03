import java.util.ArrayList;
import java.util.List;

public class Player {

    private Color color;
    private Board board;
    private int putTokens;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    void putToken() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.getCoordinate();
            error = this.getPutTokenError(coordinate);
        } while (!error.isNull());
        this.board.putToken(coordinate, color);
        this.putTokens++;
    }


    public Error getPutTokenError(Coordinate coordinate) {
        assert coordinate != null;
        Error error = Error.NULL;
        if (board.colors[coordinate.getRow()][coordinate.getColumn()] != Color.NULL) {
            error = Error.NOT_EMPTY;
        }
        error.writeln();
        return error;
    }

    Coordinate getCoordinate(){
        Coordinate coordinate = new Coordinate(0, 0);
        Console console = new Console();
        String coord = new String();
        int aux = 0;
        do{
            do{
                Message.ENTER_COORDINATE_TO_PUT.writeln();
                aux = console.readInt(coord);
                coordinate.setColumn(aux);
                if (aux > 6 || aux < 0){
                    Error.WRONG_COORDINATES.writeln();
                }
            }while(aux > 6 || aux < 0);

            coordinate.setRow(board.checkColumn(aux));
            
            if(board.checkColumn(aux) == -1){
                Error.FULL_COLUMN.writeln();
            }
        }while (board.checkColumn(aux) == -1); 
        return coordinate;
    }

}

