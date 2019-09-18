package nz.ac.vuw.ecs.swen225.a3.maze;


// used to keep track of the positions of Objects
public class XYPos {
    int X;
    int Y;

    public XYPos(int x, int y){
        X = x;
        Y = y;
    }

    // getter methoids
    public int getX() { return X; }

    public int getY() { return Y; }

    // used to update where the tile is when the player moves
    public void updatePos(int addToX, int addToY){
        X = X + addToX;
        Y = Y + addToY;
    }
}
