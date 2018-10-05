import com.sun.jna.*;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.util.Arrays;
import java.util.List;

public class ReadFile {
    public interface CLibrary extends Library {

        CLibrary INSTANCE = (ReadFile.CLibrary)Native.loadLibrary(("readFile"), ReadFile.CLibrary.class);

        boolean  read_file_content(String file_path, PointerByReference content, Pointer content_size);
    }


    public static void main(String[] args) {

      //  System.out.println(EBS.CLibrary.INSTANCE.v_create_session(session.getPointer(), path_config));
    }
}




// boolean  read_file_content(String file_path, Pointer content, Pointer content_size);