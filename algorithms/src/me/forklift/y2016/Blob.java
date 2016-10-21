package me.forklift.y2016;

public class Blob {
    private static final int BLACK = 0;
    private static final int WHITE = 1;
    private static final int VISITED = 2;

    private static final int SIZE_OF_PICTURE = 7;
    private static final int[][] PICTURE = { 
            { 1, 0, 0, 0, 0, 0, 1 }, 
            { 0, 1, 0, 1, 1, 1, 1 }, 
            { 1, 0, 0, 1, 0, 0, 0 },
            { 1, 1, 0, 0, 0, 0, 0 }, 
            { 1, 1, 0, 1, 1, 0, 1 }, 
            { 0, 0, 1, 1, 0, 0, 1 }, 
            { 0, 0, 1, 1, 0, 0, 1 } 
    };

    private void printPicture() {
        for (int x = 0; x < SIZE_OF_PICTURE; x++) {
            for (int y = 0; y < SIZE_OF_PICTURE; y++) {
                System.out.print(PICTURE[x][y] + " ");
            }
            System.out.println();
        }
    }

    private int calculateBlobSize(int x, int y) {

        if (x < 0 || y < 0 || x > SIZE_OF_PICTURE - 1 || y > SIZE_OF_PICTURE - 1)
            return 0;
        else if (PICTURE[x][y] != WHITE)
            return 0;
        else {
            // first mark current cell as a visited
            PICTURE[x][y] = VISITED;
            // and then try to find for eight direction
            return 1 + calculateBlobSize(x, y + 1) + calculateBlobSize(x + 1, y + 1) + calculateBlobSize(x + 1, y)
                    + calculateBlobSize(x + 1, y - 1) + calculateBlobSize(x, y - 1) + calculateBlobSize(x - 1, y - 1)
                    + calculateBlobSize(x - 1, y) + calculateBlobSize(x - 1, y + 1);
        }
    }

    public static void main(String[] args) {

        Blob blob = new Blob();

        blob.printPicture();
        int x = 0;
        int y = 0;
        System.out.println("(" + x + ", " + y + ") size = " + blob.calculateBlobSize(x, y));
        blob.printPicture();
    }
}
