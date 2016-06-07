@@ -1,75 +0,0 @@
//マーカーアノテーション型宣言
import java.lang.annotation.*;

/**
 *　このアノテーションがつけられたメソッドがテストメソッドであることを示す。
 * パラメータなしのstaticのメソッドに対してだけ使用すること。
 */

 @Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.METHOD)
 public @interface Test{ 　
 }

 //マーカーアノテーションを含むプログラム
public class Sample{
  @Test public static void m1(){
    //テストは成功すべき
  }

  public static void m2(){
  }

  @Test public static void m3(){
    //テストは失敗すべき
    throw new RuntimeException("Boom");
  }

  public static void m4(){
  }

  @Test public void m5(){
    //不正な使用:staticでないメソッド
  }

  @Test public static void m6(){
  }

  @Test public static void m7(){
    //テストは失敗すべき
  }

  public static void m8(){
  }
}


//マーカーアノテーションを処理するプログラム
import java.lang.reflect.*;

public class RunTests{
  public static void main(String[] args) throws Exception{
    int tests = 0;
    int passed = 0;
    Class testClass = Class.forName(args[0]);
    for(Method m : testClass.getDeclaredMethods()){
      if(m.isAnnotationPresent(Test.class)){
        tests++;
        try{
          m.invoke(null);
          passed++;
        } catch(InvocationTargetException wrappedExc){
          Throwable exc = wrappedExc.getCause();
          System.out.println(m + "failed: " + exc);
        } catch(Exception　exc){
          System.out.println("INVALID @Test: " + m);
        }

      }
    }
    System.out.printf("Passed: %d, Failed %d%n", passed, tests - passed);
  }

}


//パラメータを持つアノテーション型
import java.lang.annotation.*;
/**
*アノテーションがつけられたメソッドは、成功するには指定された例外を
*スローしなければならないテストメソッドであることを示す。
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest{
  Class<? extends Exception> value();
}

//パラメータを持つアノテーションを含むプログラム
public class Sample2{
  @ExceptionTest(ArithmeticException.class)
  public static void m1(){ //テストは成功すべき
    int i = 0;
    i = i / i;
  }

  @ExceptionTest(ArithmeticException.class)
  public static void m2(){ //テストは失敗すべき(誤った例外)
    int[] a = new int[0];
    int i = a[1];
  }

  @ExceptionTest(ArithmeticException.class)
  public static void m3(){ //テストは失敗すべき(例外なし)
  }

}

//配列パラメータを持つアノテーション型
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest{
  Class<? extends Exception>[] value();
}

//配列パラメータを持つアノテーションを含むコード
@ExceptionTest({IndexOutOfBoundsException.class, NullPointerException.class})
public static void doublyBad(){
  List<String> list new ArrayList<String>();
  //このメソッドがIndexOutOfBoundsExceptionかNullPointerExceptionをスローすることを
  //仕様は許している
  list.add(5, null);
}
