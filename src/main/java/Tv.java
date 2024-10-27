public class Tv {

	private boolean on = false;

	void on() {
		on = true;
	}

	void off() {
		on = false;
	}

	public boolean isOn() {
		return on;
	}
}
