public class Tv {

	private boolean hibernating;
	private boolean on;

	void on() {
		on = true;
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

	public void weakup() {
		hibernating = false;
	}
}
