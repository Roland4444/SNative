import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import org.junit.Test;

import static org.junit.Assert.*;

public class LetsCheckTest {

    @Test
    public void main() {
        String config = "/home/roland/Documents/callEBS/callEBS1/cv_config.json";
        String wav = "/home/roland/Documents/callEBS/callEBS1/1.wav";
        assertNotEquals(null, LetsCheck.CLibrary.INSTANCE.lets_check(config, wav));
        System.out.println("CHECKOUT"+LetsCheck.CLibrary.INSTANCE.lets_check(config, wav).check);

    }


}