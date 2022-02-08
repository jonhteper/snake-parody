package main;

class GameException extends Exception {
    ExceptionType type;

    public GameException(ExceptionType type) {
        this.type = type;
    }


    public ExceptionType getType() {
        return type;
    }


}

enum ExceptionType {
    LineException,

}

