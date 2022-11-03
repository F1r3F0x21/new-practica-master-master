
enum Message {
	TITLE("--- CONNECT4 ---"),
	HORIZONTAL_LINE("-------------------------------"),
	VERTICAL_LINE(" | "),
    ENTER_COORDINATE_TO_PUT("Enter a coordinate to put a token:"),
	COORDINATE_TO_PUT("Coordinate to put"),
	PLAYER_WIN("#player player: You win!!! :-)"), 
	FINISH("Ok, have a nice day"),
	RESET("Ok, we reset the board for you"),
	RESUME("Do you want to continue");
	

	private String message;

	Message(String message) {
		this.message = message;
	}

	void write() {
		Console.getInstance().write(this.message);
	}

	void writeln() {
		Console.getInstance().writeln(this.message);
	}

	void writeln(String player) {
		assert this == Message.PLAYER_WIN;
		
		Console.getInstance().writeln(this.message.replaceAll("#player", "" + player));
	}

	@Override
	public String toString() {
		return message;
	}
}
