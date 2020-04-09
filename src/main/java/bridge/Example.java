package bridge;

public class Example<E> {
  public void doStuff(E e) {}
}
// CORRECTION!!
// This is the bridge method, in my haste
// I created the wrong example.
// Note that with javap -c bridge.Ex2
// We see two methods called doStuff, one
// takes Object (conforming to parent)
// the other takes String (conforming here)
// technically, they're overloads,
// but the implementation delegates, so they
// behave like this overrides the other.
// Notice the decompilation of the method with
// Object argument gives:
/*
  public void doStuff(java.lang.Object);
    Code:
       0: aload_0
       1: aload_1
       2: checkcast     #2                  // class java/lang/String
       5: invokevirtual #3                  // Method doStuff:(Ljava/lang/String;)V
       8: return
 */
// Line five DELEGATES to the String argument
// version of the method
class Ex2 extends Example<String> {
  @Override
  public void doStuff(String e) {}
}
