object runner extends App{
  import com.sun.jna.Native
  import HelloWorld.CLibrary
  import com.sun.jna.Library

   object MyLibrary {
    val INSTANCE: MyLibrary = Native.loadLibrary("HelloLibrary", classOf[MyLibrary]).asInstanceOf[MyLibrary]
  }

  trait MyLibrary extends Library {
    def SayHello(a: String, b: String ): Unit
  }
  var i = 0
  MyLibrary.INSTANCE.SayHello("Roman", "Bro!")
}
