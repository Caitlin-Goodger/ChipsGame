package nz.ac.vuw.ecs.swen225.a3.application;

import java.util.Timer;
import java.util.TimerTask;

public class TimeLimit {
	private Timer timer;
	private int interval;
	private MainFrame mf;

	public TimeLimit(int seconds, MainFrame mf) {
		this.timer = new Timer();
		this.interval = seconds;
		this.mf = mf;

		timer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				mf.getInterfacePanel().setTime(setInterval());
			}
		}, 0, 1000);
	}

	/**
	 * Decreases interval until time is 0, then timer stops
	 * 
	 * @return interval--
	 */
	private int setInterval() {
		if (interval == 0) {
			timer.cancel();
		}

		return interval--;
	}
}
