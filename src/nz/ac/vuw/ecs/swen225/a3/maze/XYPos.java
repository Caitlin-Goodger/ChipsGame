package nz.ac.vuw.ecs.swen225.a3.maze;

/**
 * XYPos class. Used to store the x and y co-ordinates of a tile. 
 * @author Caitlin
 *
 */
public class XYPos {
    int X;
    int Y;
    
    /**
     * Constructor for the XYPos class. 
     * @param x = x co-ordinate. 
     * @param y = y co-ordinate 
     */
    public XYPos(int x, int y){
        X = x;
        Y = y;
    }

    /**
     * Get the x value.
     * @return int. 
     */
    public int getX() { return X; }

    /**
     * Get the y value. 
     * @return int. 
     */
    public int getY() { return Y; }

   /**
    * Update the x and y positions. 
    * @param addToX
    * @param addToY
    */
    public void updatePos(int addToX, int addToY){
        X = X + addToX;
        Y = Y + addToY;
    }
    
    public String toString() {
    	return "X:"+ this.X + " Y:" + this.Y;
    }
}
