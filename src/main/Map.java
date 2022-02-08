package main;

import java.util.Vector;
import java.util.Random;
public class Map {
    int width = 0, height = 0;
    Line borderTop, borderRight, borderBottom, borderLeft;
    Snake snake;
    Dot dot;

    public Map(int width, int height) throws GameException {
        this.width = width;
        this.height = height;

        Coord origin = new Coord(0,0);
        Coord point1 = new Coord(this.width, 0); // width, 0
        Coord point2 = new Coord(width,height); // width, height
        Coord point3 = new Coord(0,height); // 0, height

        this.borderBottom = new Line(origin, point1);
        this.borderRight = new Line(point1, point2);
        this.borderTop = new Line(point2, point3);
        this.borderLeft = new Line(point3, origin);

        Random random = new Random();


        // Max dot value = 3
        this.dot = new Dot(new Coord(
                random.nextInt(this.width),
                random.nextInt(this.height)),
                random.nextInt(3)
        );

        // Try center the snake
        int x = (width %2 ==0 ? width/2: width/2+1);
        int y = (height %2 ==0 ? height/2: height/2+1);
        this.snake = new Snake(new Coord(x, y));

    }

    public void snakeUp() {
        this.snake.moveUp(this.dot, this.borderTop);
        this.snakePosition();
    }

    public void snakeRight() {
        this.snake.moveRight(this.dot, this.borderRight);
        this.snakePosition();
    }

    public void snakeDown() {
        this.snake.moveDown(this.dot, this.borderBottom);
        this.snakePosition();
    }
    public void snakeLeft() {
        this.snake.moveLeft(this.dot, this.borderLeft);
        this.snakePosition();
    }

    public void snakePosition() {
        Coord coord = this.snake.body.firstElement();
        System.out.printf("Snake is in (%d, %d)\n", coord.x, coord.y);
    }
}


class Line {
    Vector<Coord> body;

    public Line(Coord start, Coord end) throws GameException {
        this.body = new Vector<>();

        if (start.x == end.x) {
            for (int i = start.y; i < end.y; i++) {
                this.body.add(new Coord(start.x, i));
            }

        } else if(start.y == end.y ){
            for (int i = start.x; i < end.x; i++) {
                this.body.add(new Coord(i, end.y));
            }

        } else {
            throw new GameException(ExceptionType.LineException);
        }

    }


    public Vector<Coord> getBody() {
        return body;
    }
}

class Coord {
    public int x = 0, y = 0;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Dot {
    Coord coord;
    int value;

    public Dot(Coord coord, int value) {
        this.coord = coord;
        this.value = value;
    }
}

