package main;


import java.util.Collections;
import java.util.Vector;

class Snake {
    Vector<Coord> body = new Vector<>();
    int score = 0;

    public Snake(Coord initialCoord) {
        this.body.add(initialCoord);
        this.body.add(new Coord(initialCoord.x-1, initialCoord.y));

    }

    public void moveUp(Dot objective, Line endLine) {
        Coord position = this.body.firstElement();
        Coord newPosition = new Coord(position.x, position.y +1 );
        this.adjustBody(newPosition);
        tryToCaptureDot(newPosition, objective);

        if (endLine.body.contains(newPosition)) {
            System.out.println("GAME OVER");
        }
    }

    public void moveDown(Dot objective, Line endLine) {
        Coord position = this.body.firstElement();
        Coord newPosition = new Coord(position.x, position.y -1 );
        this.adjustBody(newPosition);
        tryToCaptureDot(newPosition, objective);

        if (endLine.body.contains(newPosition)) {
            System.out.println("GAME OVER");
        }
    }

    public void moveRight(Dot objective, Line endLine) {
        Coord position = this.body.firstElement();
        Coord newPosition = new Coord(position.x+1, position.y);
        this.adjustBody(newPosition);
        tryToCaptureDot(newPosition, objective);

        if (endLine.body.contains(newPosition)) {
            System.out.println("GAME OVER");
        }
    }

    public void moveLeft(Dot objective, Line endLine) {
        Coord position = this.body.firstElement();
        Coord newPosition = new Coord(position.x-1, position.y);
        this.adjustBody(newPosition);
        tryToCaptureDot(newPosition, objective);

        if (endLine.body.contains(newPosition)) {
            System.out.println("GAME OVER");
        }

    }

    private void adjustBody(Coord newPosition) {
        Collections.reverse(this.body);
        this.body.add(newPosition);
        Collections.reverse(this.body);
    }

    private void tryToCaptureDot(Coord position, Dot dot) {
        if (position.x == dot.coord.x && position.y == dot.coord.y) {
            this.score += dot.value;
            this.body.add(dot.coord);
            System.out.printf("Dot Captured!\nScore: %d\n", this.score);
        }
    }
}
