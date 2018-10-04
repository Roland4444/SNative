import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class EBSTest {

    @Test
    public void main() {

        String path_config = "/home/roland/Downloads/download/.build_l64/tests_data/cv_configuration.json";
        EBS.CLibrary.INSTANCE.printf("Hello, World\n");
        EBS.CLibrary.Session session= new EBS.CLibrary.Session();
        EBS.CLibrary.Version version = new EBS.CLibrary.Version();
        version.build=1;
        version.minor=1;
        version.major=3;
        session.version=version;
        session.id = "547875";

        assertEquals(true, EBS.CLibrary.INSTANCE.v_create_session(session.getPointer(), path_config));
    }

    @Test
    public void main1() throws IOException {
        EBS ebs = new EBS();
        String wav = "/home/roland/Downloads/download/.build_l64/tests_data/EE45AEAAD1A31B1B1A45F4B38C98BE62893E590A47C1166061B0B1C52163531C.wav";
        String path_config = "/home/roland/Downloads/download/.build_l64/tests_data/cv_configuration.json";
        EBS.CLibrary.INSTANCE.printf("Hello, World\n");
        EBS.CLibrary.Session session= new EBS.CLibrary.Session();
        EBS.CLibrary.Version version = new EBS.CLibrary.Version();
        version.build=1;
        version.minor=1;
        version.major=3;
        session.version=version;
        session.id = "547875";
        Path p = Paths.get(wav);
        byte[] arr = Files.readAllBytes(p);
        assertNotEquals(null, arr);

        assertEquals(true, EBS.CLibrary.INSTANCE.v_check(session.getPointer(), arr, arr.length));
    }


    @Test
    public void readfile(){
        String wav = "/home/roland/Downloads/download/.build_l64/tests_data/EE45AEAAD1A31B1B1A45F4B38C98BE62893E590A47C1166061B0B1C52163531C.wav";
        final PointerByReference ex9ValsRefPtr = new PointerByReference();
        final IntByReference ex9NumValsRef = new IntByReference();
        assertEquals(true, EBS.CLibrary.INSTANCE.read_file_content(wav, ex9ValsRefPtr, ex9NumValsRef));
    }

}