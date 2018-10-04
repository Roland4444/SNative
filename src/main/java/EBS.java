import com.sun.jna.*;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.util.Arrays;
import java.util.List;

public class EBS {
    public interface CLibrary extends Library {
        public static class Version extends Structure {
            @Override
            protected List<String> getFieldOrder() {
                return Arrays.asList(new String[] { "major", "minor", "build" });
            }

            public static class ByReference extends Version implements Structure.ByReference {}

            public int major;
            public int minor;
            public int build;
        }
        public static class Session extends Structure {
            @Override
            protected List<String> getFieldOrder() {
                return Arrays.asList(new String[] { "version", "id", "payment", "last_error" });
            }

            public static class ByReference extends Session implements Structure.ByReference {}

            public Version version;
            public String id;
            public Pointer payment;
            public int last_error;
        }
        CLibrary INSTANCE = (CLibrary)Native.loadLibrary(("cv"), CLibrary.class);
        boolean  read_file_content(String file_path, PointerByReference content, IntByReference content_size);
        void printf(String format, Object... args);
        boolean v_create_session(Pointer session, String config);
        boolean v_check(Pointer session, byte[] content, int content_size);
    }


    public static void main(String[] args) {
        String path_config = "/home/roland/Downloads/download/.build_l64/tests_data/cv_configuration.json";
        CLibrary.INSTANCE.printf("Hello, World\n");
        for (int i=0;i < args.length;i++) {
            CLibrary.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
        }
        CLibrary.Session session= new CLibrary.Session();
        CLibrary.Version version = new CLibrary.Version();
        version.build=1;
        version.minor=1;
        version.major=3;
        session.version=version;
        session.id = "547875";

        System.out.println(CLibrary.INSTANCE.v_create_session(session.getPointer(), path_config));
    }
}