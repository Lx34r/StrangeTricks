Java8开发代号是Spider(蜘蛛),于2014-03-18发行.

## <font size=4> **`0x000`** </font> <font size=4> **Lambda表达式** </font> 
Java 8可谓是自Java 5以来最具革命性的版本了，她在语言、编译器、类库、开发工具以及Java虚拟机等方面都带来了不少新特性。

## <font size=4> **`0x001`** </font> <font size=4> **Lambda表达式** </font> 
Lambda表达式可以说是Java 8最大的卖点，她将函数式编程引入了Java。Lambda允许把函数作为一个方法的参数，或者把代码看成数据。

一个Lambda表达式可以由用逗号分隔的参数列表、–>符号与函数体三部分表示。例如：
```java
Arrays.asList( "p", "k", "u","f", "o", "r","k").forEach( e -> System.out.println( e ) );
```

为了使现有函数更好的支持Lambda表达式，Java 8引入了函数式接口的概念。函数式接口就是只有一个方法的普通接口。java.lang.Runnable与java.util.concurrent.Callable是函数式接口最典型的例子。为此，Java 8增加了一种特殊的注解@FunctionalInterface

## <font size=4> **`0x002`** </font> <font size=4> **接口的默认方法与静态方法** </font> 
我们可以在接口中定义默认方法，使用default关键字，并提供默认的实现。所有实现这个接口的类都会接受默认方法的实现，除非子类提供的自己的实现。例如：
```java
 public interface DefaultFunctionInterface {
     default String defaultFunction() {
         return "default function";
     }
 }
```
我们还可以在接口中定义静态方法，使用static关键字，也可以提供实现。例如：

```java
 public interface StaticFunctionInterface {
     static String staticFunction() {
         return "static function";
     }
 }
```

接口的默认方法和静态方法的引入，其实可以认为引入了C＋＋中抽象类的理念，以后我们再也不用在每个实现类中都写重复的代码了。

## <font size=4> **`0x003`** </font> <font size=4> **方法引用（含构造方法引用）** </font> 
通常与Lambda表达式联合使用，可以直接引用已有Java类或对象的方法。一般有四种不同的方法引用：

1.构造器引用。语法是Class::new，或者更一般的Class< T >::new，可无参，可有参数。方法签名保持一致；

2.静态方法引用。语法是Class::static_method，要求方法签名保持一致；

3.特定类的任意对象方法引用。它的语法是Class::method。要求方法签名保持一致；

4.特定对象的方法引用，它的语法是instance::method。要求方法签名保持一致。与3不同的地方在于，3是在列表元素上分别调用方法，而4是在某个对象上调用方法，将列表元素作为参数传入；

## <font size=4> **`0x004`** </font> <font size=4> **重复注解** </font> 
在Java 5中使用注解有一个限制，即相同的注解在同一位置只能声明一次。Java 8引入重复注解，这样相同的注解在同一地方也可以声明多次。重复注解机制本身需要用@Repeatable注解。Java 8在编译器层做了优化，相同注解会以集合的方式保存，因此底层的原理并没有变化。

## <font size=4> **`0x005`** </font> <font size=4> **扩展注解的支持（类型注解）** </font> 
Java 8扩展了注解的上下文，几乎可以为任何东西添加注解，包括局部变量、泛型类、父类与接口的实现，连方法的异常也能添加注解。
```java
private @NotNull String name;
```
## <font size=4> **`0x006`** </font> <font size=4> **Optional** </font> 
Java 8引入Optional类来防止空指针异常，Optional类最先是由Google的Guava项目引入的。Optional类实际上是个容器：它可以保存类型T的值，或者保存null。使用Optional类我们就不用显式进行空指针检查了。

## <font size=4> **`0x007`** </font> <font size=4> **Stream** </font> 
Stream API是把真正的函数式编程风格引入到Java中。其实简单来说可以把Stream理解为MapReduce，当然Google的MapReduce的灵感也是来自函数式编程。她其实是一连串支持连续、并行聚集操作的元素。从语法上看，也很像linux的管道、或者链式编程，代码写起来简洁明了，非常酷帅！

## <font size=4> **`0x008`** </font> <font size=4> **Date/Time API (JSR 310)** </font> 
Java 8新的Date-Time API (JSR 310)受Joda-Time的影响，提供了新的java.time包，可以用来替代 java.util.Date和java.util.Calendar。一般会用到Clock、LocaleDate、LocalTime、LocaleDateTime、ZonedDateTime、Duration这些类，对于时间日期的改进还是非常不错的。

## <font size=4> **`0x009`** </font> <font size=4> **JavaScript引擎Nashorn** </font> 
Nashorn允许在JVM上开发运行JavaScript应用，允许Java与JavaScript相互调用。

## <font size=4> **`0x010`** </font> <font size=4> **Base64** </font> 
**在Java8中Base64编码已经成为Java类库的标准，且内置了Base64编码的编码器和解码器。**

**java8的Api提供了Basic编码、URL编码、MIME编码、对流的支持**

## <font size=4> **`0x011`** </font> <font size=4> **更好的类型推测机制** </font> 
Java 8在类型推测方面有了很大的提高，这就使代码更整洁，不需要太多的强制类型转换了。

## <font size=4> **`0x012`** </font> <font size=4> **编译器优化** </font> 
Java 8将方法的参数名加入了字节码中，这样在运行时通过反射就能获取到参数名，只需要在编译时使用-parameters参数。

## <font size=4> **`0x013`** </font> <font size=4> **并行（parallel）数组** </font> 
支持对数组进行并行处理，主要是parallelSort()方法，它可以在多核机器上极大提高数组排序的速度。

## <font size=4> **`0x014`** </font> <font size=4> **并发（Concurrency）** </font> 
在新增Stream机制与Lambda的基础之上，加入了一些新方法来支持聚集操作。

## <font size=4> **`0x015`** </font> <font size=4> **Nashorn引擎jjs** </font> 
基于Nashorn引擎的命令行工具。它接受一些JavaScript源代码为参数，并且执行这些源代码。

## <font size=4> **`0x016`** </font> <font size=4> **类依赖分析器jdeps** </font> 
可以显示Java类的包级别或类级别的依赖。

## <font size=4> **`0x017`** </font> <font size=4> **JVM的PermGen空间被移除** </font> 
取代它的是Metaspace（JEP 122）。

## <font size=4> **`0x018`** </font> <font size=4> **编程风格** </font> 
Java 8 希望有自己的编程风格，并与 Java 7 区别开，以下实例展示了 Java 7 和 Java 8 的编程格式：
```java
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
 
public class Java8Tester {
   public static void main(String args[]){
   
      List<String> names1 = new ArrayList<String>();
      names1.add("Google ");
      names1.add("Runoob ");
      names1.add("Taobao ");
      names1.add("Baidu ");
      names1.add("Sina ");
        
      List<String> names2 = new ArrayList<String>();
      names2.add("Google ");
      names2.add("Runoob ");
      names2.add("Taobao ");
      names2.add("Baidu ");
      names2.add("Sina ");
        
      Java8Tester tester = new Java8Tester();
      System.out.println("使用 Java 7 语法: ");
        
      tester.sortUsingJava7(names1);
      System.out.println(names1);
      System.out.println("使用 Java 8 语法: ");
        
      tester.sortUsingJava8(names2);
      System.out.println(names2);
   }
   
   // 使用 java 7 排序
   private void sortUsingJava7(List<String> names){   
      Collections.sort(names, new Comparator<String>() {
         @Override
         public int compare(String s1, String s2) {
            return s1.compareTo(s2);
         }
      });
   }
   
   // 使用 java 8 排序
   private void sortUsingJava8(List<String> names){
      Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
   }
}
```
执行以上脚本，输出结果为：

```
$ javac Java8Tester.java
$ java Java8Tester
使用 Java 7 语法: 
[Baidu , Google , Runoob , Sina , Taobao ]
使用 Java 8 语法: 
[Baidu , Google , Runoob , Sina , Taobao ]
```
