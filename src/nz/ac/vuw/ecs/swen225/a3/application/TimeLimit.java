package nz.ac.vuw.ecs.swen225.a3.application;

import java.util.Timer;
import java.util.TimerTask;

public class TimeLimit {
	private Timer timer;
	private int time;
	private MainFrame mf;

	public TimeLimit(int seconds, MainFrame mf) {
		this.timer = new Timer();
		this.time = seconds;
		this.mf = mf;

		timer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				mf.getInterfacePanel().setTime(tick());
			}
		}, 0, 1000);
	}

	/**
	 * Decreases time until time is 0, then timer stops
	 * 
	 * @return time--
	 */
	private int tick() {
		if (time == 0) {
			timer.cancel();
		}
		return time--;
	}

	/**
	 * Sets the time. Used on new level.
	 * 
	 * @param time
	 */
	public void setTime(int time) {
		this.time = time;
	}
}
