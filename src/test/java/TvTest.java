import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TvTest {

	private Tv tv;

	@BeforeEach
	void setup() {
		tv = new Tv(50);
		assertFalse(tv.isOn());
		tv.on();
		assertTrue(tv.isOn());
	}

	@Test
	void onOff() {
		tv.off();
		assertFalse(tv.isOn());
	}

	@Test
	void hibernate() {
		assertFalse(tv.isHibernating());
		tv.hibernate();
		assertTrue(tv.isOn());
		assertTrue(tv.isHibernating());
		tv.wakeup();
		assertTrue(tv.isOn());
		assertFalse(tv.isHibernating());
		tv.hibernate();
		tv.off();
		assertFalse(tv.isHibernating());
		assertFalse(tv.isOn());
	}

	@Test
	void playAd() throws InterruptedException {
		assertAdPlaying();
		tv.hibernate();
		tv.wakeup();
		assertAdPlaying();
	}

	private void assertAdPlaying() throws InterruptedException {
		assertTrue(tv.isAdPlaying());
		Thread.sleep(100);
		assertFalse(tv.isAdPlaying());
	}
}