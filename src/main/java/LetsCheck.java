import com.sun.jna.*;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;

public class LetsCheck {
    public interface CLibrary extends Library {
        public static class ResultCheck extends Structure {
            @Override
            protected List<String> getFieldOrder() {
                return Arrays.asList(new String[] { "check", "proc_return", "incallreturn"  });

            }
            public static class ByReference extends ResultCheck implements Structure.ByReference {}
            public boolean check;
            public int proc_return;
            public int incallreturn;
        }

        CLibrary INSTANCE = (CLibrary)Native.loadLibrary(("wEBS"), CLibrary.class);
        ResultCheck lets_check(String config, String filename);


    }


    public static void main(String[] args) {

        //  System.out.println(CLibrary.INSTANCE.v_create_session(session.getPointer(), path_config));
    }
}