package main;


import java.util.Random;

public class Main {
    public static void main(String[] args) throws GameException {
        Random random = new Random();
        // Add 5, so you don't get a ridiculously small map
        int width = random.nextInt(50)+5, height = random.nextInt(50)+5;
        Map map1 = new Map(width, height);

        System.out.printf(
                "GAME STARTS\nScore:0\nGame Measurements %d x %d\n\nDot is in: (%d, %d)\n",
                width,
                height,
                map1.dot.coord.x,
                map1.dot.coord.y
        );
        System.out.println("************************************************");
        map1.snakePosition();

        map1.snakeDown();
        map1.snakeDown();

        map1.snakeLeft();
        map1.snakeUp();

        map1.snakeRight();
        map1.snakeUp();



    }
}
