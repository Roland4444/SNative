import java.util

import com.sun.jna.Structure

object runner extends App{
  import com.sun.jna.Native
  import EBS.CLibrary
  import com.sun.jna.Library

  import com.sun.jna.Structure





  object MyLibrary {
    val INSTANCE: MyLibrary = Native.loadLibrary("HelloLibrary", classOf[MyLibrary]).asInstanceOf[MyLibrary]
  }

  trait MyLibrary extends Library {
    def SayHello(a: String, b: String ): Unit
  }

  object ebsLibrary {
    val INSTANCE: ebsLibrary = Native.loadLibrary("cv", classOf[ebsLibrary]).asInstanceOf[ebsLibrary]
  }

  trait ebsLibrary extends Library {
    def v_create_session(Session: Object , path: String); Boolean

  }

  MyLibrary.INSTANCE.SayHello("Roman", "Bro!")
  print(ebsLibrary.INSTANCE.v_create_session(AnyRef, "/home/roland/Downloads/download/.build_l64/tests_data/cv_configuration.json"))

}
