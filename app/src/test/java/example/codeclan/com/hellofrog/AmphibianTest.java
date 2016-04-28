package example.codeclan.com.hellofrog;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by sandy on 25/04/2016.
 */
public class AmphibianTest {
    @Test
    public void superAwesomeTest() {
        Amphibian amphibian = new Amphibian("Kermit");
        assertEquals("Kermit", amphibian.getName());
    }
}
