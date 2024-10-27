import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Tv {

	private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
	private final int adMills;
	private boolean hibernating;
	private boolean on;
	private boolean adPlaying;

	public Tv(int adMills) {
		this.adMills = adMills;
	}

	void on() {
		on = true;
		playAd();
	}

	private void playAd() {
		final LocalTime adStartTime = LocalTime.now();
		System.out.println("Ad start at " + adStartTime);
		adPlaying = true;
		scheduledExecutorService.schedule(
				() -> {
					adPlaying = false;
					System.out.println("Ad done after: " + Duration.between(adStartTime, LocalTime.now()));
				}
				, adMills, TimeUnit.MILLISECONDS);
	}

	void off() {
		on = false;
		hibernating = false;
	}

	public boolean isOn() {
		return on;
	}

	public void hibernate() {
		hibernating = true;
	}

	public boolean isHibernating() {
		return hibernating;
	}

	public void wakeup() {
		hibernating = false;
		playAd();
	}

	public boolean isAdPlaying() {
		return adPlaying;
	}
}
