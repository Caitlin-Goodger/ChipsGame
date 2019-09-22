package nz.ac.vuw.ecs.swen225.a3.maze;

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
     * @return
     */
    public int getX() { return X; }

    /**
     * Get the y value. 
     * @return
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
