package nz.ac.vuw.ecs.swen225.a3.util;

import java.util.Timer;
import java.util.TimerTask;

import nz.ac.vuw.ecs.swen225.a3.gui.MainFrame;

/**
 * TimeLimit class is responsible for the timer.
 */
public class TimeLimit {
  private Timer timer;
  private int time;
  /**
   * Constructor for the time limit.
   * 
   * @param seconds = the time you want on the timer
   * @param mf      = the main frame to update time
   */
  public TimeLimit(int seconds, MainFrame mf) {
    this.timer = new Timer();
    this.time = seconds;

    this.timer.scheduleAtFixedRate(new TimerTask() {
      public void run() {
        if(mf.getGame().isFinished()==false)
          mf.getInterfacePanel().setTime(tick());
      }
    }, 0, 1000);    
    
    this.timer.scheduleAtFixedRate(new TimerTask() {

      public void run() {
        if(mf.getGame().isFinished()==false) {
          mf.getGame().moveMonsters();
          mf.refreshBoard();
        }
      }
    }, 0, 250);    
  }
  
  

  /**
   * Decreases time until time is 0, then timer stops.
   * 
   * @return time
   */
  private int tick() {
    if (this.time == 0) {
      this.timer.cancel();
    }

    this.time--;

    if (this.time > 0) {
      assert this.time > 0;

      return this.time;
    }

    return 0;
  }

  /**
   * Sets the time. Used on new level.
   * 
   * @param time = the time you want to set the timer to
   */
  public void setTime(int time) {
    if (time < 0) {
      throw new IllegalArgumentException("Argument must be greater than 0.");
    }

    this.time = time;

    assert this.time == time;
  }
}
