import org.junit.Test;

import static org.junit.Assert.*;

public class EBSTest {

    @Test
    public void main() {
        EBS ebs = new EBS();
        String path_config = "/home/roland/Downloads/download/.build_l64/tests_data/cv_configuration.json";
        EBS.CLibrary.INSTANCE.printf("Hello, World\n");
        EBS.CLibrary.Session session= new EBS.CLibrary.Session();
        EBS.CLibrary.Version version = new EBS.CLibrary.Version();
        version.build=1;
        version.minor=1;
        version.major=3;
        session.version=version;
        session.id = "547875";

        assertEquals(true, EBS.CLibrary.INSTANCE.v_create_session(session, path_config));
    }
}