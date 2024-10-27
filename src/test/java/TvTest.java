import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TvTest {

	private Tv tv;

	@BeforeEach
	void setup() {
		tv = new Tv();
	}

	@Test
	void onOff() {
		tv.on();
		assertTrue(tv.isOn());
		tv.off();
		assertFalse(tv.isOn());
	}
}