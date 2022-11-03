enum Error {

        NOT_EMPTY("The square is not empty"),
        SAME_COORDINATES("The origin and target squares are the same"),
        WRONG_COORDINATES("The coordinates are wrong"),
        FULL_COLUMN("The column is full, please select another one"), 
        NULL;

        private String message;

        Error(){
        }

        Error(String message){
            this.message = message;
        }

        void writeln() {
            if (!this.isNull()) {
                Console.getInstance().writeln(this.message);
            }
        }

        public boolean isNull() {
            return this == Error.NULL;
        }

}

