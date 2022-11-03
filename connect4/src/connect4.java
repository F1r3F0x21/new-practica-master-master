public class connect4 {
    private Board board;
    private Turn turn;

    connect4(){
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void play() {
        board.reset();
        do {
            this.playGame();
        } while (this.isResumedGame());
    }

    private void playGame() {
        Message.TITLE.writeln();
        this.board.write();
        do {
            this.turn.play();
            this.board.write();
        } while (!board.boardFull());
    }


    public boolean isResumedGame() {
        boolean ok=false;
        Console console= new Console();
        String confirmation= new String();
        do {
            Message.RESUME.writeln();
            confirmation= console.readString();
            if (confirmation.equals("YES")||confirmation.equals("NO")){
                ok=true;
            }
        }while(!ok);
        if (confirmation.equals("YES")){
            Message.RESET.writeln();
            board.reset();
            return true;
        }else{
            Message.FINISH.writeln();
            return false;
        }
    }

    public static void main(String[] args) {
        connect4 game = new connect4();
        game.play();
    }

}
