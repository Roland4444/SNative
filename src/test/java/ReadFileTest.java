import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReadFileTest {

    @Test
    public void main() {
        String wav = "/home/roland/Downloads/download/.build_l64/tests_data/EE45AEAAD1A31B1B1A45F4B38C98BE62893E590A47C1166061B0B1C52163531C.wav";
        final PointerByReference ex9ValsRefPtr = new PointerByReference();
        final IntByReference ex9NumValsRef = new IntByReference();
        assertEquals(true, ReadFile.CLibrary.INSTANCE.read_file_content(wav, ex9ValsRefPtr, ex9NumValsRef));
        assertEquals(false, ReadFile.CLibrary.INSTANCE.read_file_content(wav+"0000", ex9ValsRefPtr, ex9NumValsRef));


    }
}



