import java.util.ArrayList;
import java.util.List;

public class Board {
    public Color[][] colors;

    public Board(){
		this.colors = new Color[Coordinate.ROW][Coordinate.COLUMN];
    }

    public void reset() {
        for(int i= 0; i < Coordinate.ROW; i++){
            for(int j = 0; j < Coordinate.COLUMN; j++){
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    private Color getColor(Coordinate coordinate) {
		assert this.colors[coordinate.getRow()][coordinate.getColumn()] != Color.NULL;
		return this.colors[coordinate.getRow()][coordinate.getColumn()];
	}

	public void putToken(Coordinate coordinate, Color color){
		assert !(coordinate == null);

		this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
	}



	boolean isEmpty (Coordinate coordinate){
		if (colors[coordinate.getRow()][coordinate.getColumn()] == Color.NULL){
			return true;
		}else{
			return false;
		}
	}
	
	
	public int checkColumn(int column){
		int position = Coordinate.ROW-1;
		for (int i = position; i >= 0; i--){
			if (!colors[position][column].isNull()){
				position--;
			}
		}
		return position;
	}

	public boolean boardFull(){
		int acumulator = 0;
		for (int i = 0; i < 7; i++){
			if (checkColumn(i) == -1){
				acumulator++;
			}
		}
		return Coordinate.COLUMN==acumulator;
	}

    public void write() {
		Message.HORIZONTAL_LINE.writeln();
		for (int i = 0; i < Coordinate.ROW; i++) {
			Message.VERTICAL_LINE.write();
			for (int j = 0; j < Coordinate.COLUMN; j++) {
				this.getColor(new Coordinate(i, j)).write();
				Message.VERTICAL_LINE.write();
			}
			Console.getInstance().writeln();
		}
		Message.HORIZONTAL_LINE.writeln();
	}
}
