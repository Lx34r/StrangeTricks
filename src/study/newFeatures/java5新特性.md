Java5开发代号为Tiger(老虎),于2004-09-30发行

## <font size=4> **`0x000`** </font> <font size=4> **简述** </font>
- 泛型
- 枚举
- 自动装箱拆箱
- 可变参数
- 注解
- foreach循环（增强for、for/in）
- 静态导入
- 格式化（System.out.println 支持%s %d等格式化输出）
- 线程框架/数据结构 JUC
- Arrays工具类/StringBuilder/instrument

## <font size=4> **`0x001`** </font> <font size=4> **泛型** </font>
所谓类型擦除指的就是Java源码中的范型信息只允许停留在编译前期，而编译后的字节码文件中将不再保留任何的范型信息。也就是说，范型信息在编译时将会被全部删除，其中范型类型的类型参数则会被替换为Object类型，并在实际使用时强制转换为指定的目标数据类型。而C++中的模板则会在编译时将模板类型中的类型参数根据所传递的指定数据类型生成相对应的目标代码。
```java
Map<Integer, Integer> squares = new HashMap<Integer, Integer>();
```
- 通配符类型：避免unchecked警告，问号表示任何类型都可以接受
```java
public void printList(List<?> list, PrintStream out) throws IOException {
    for (Iterator<?> i = list.iterator(); i.hasNext(); ) {
      out.println(i.next().toString());
    }
  }
```

- 限制类型
```java
public static <A extends Number> double sum(Box<A> box1,Box<A> box2){
    double total = 0;
    for (Iterator<A> i = box1.contents.iterator(); i.hasNext(); ) {
      total = total + i.next().doubleValue();
    }
    for (Iterator<A> i = box2.contents.iterator(); i.hasNext(); ) {
      total = total + i.next().doubleValue();
    }
    return total;
  }
```
## <font size=4> **`0x002`** </font> <font size=4> **枚举** </font>
- EnumMap
```java
public void testEnumMap(PrintStream out) throws IOException {
    // Create a map with the key and a String message
    EnumMap<AntStatus, String> antMessages =
      new EnumMap<AntStatus, String>(AntStatus.class);
    // Initialize the map
    antMessages.put(AntStatus.INITIALIZING, "Initializing Ant...");
    antMessages.put(AntStatus.COMPILING,    "Compiling Java classes...");
    antMessages.put(AntStatus.COPYING,      "Copying files...");
    antMessages.put(AntStatus.JARRING,      "JARring up files...");
    antMessages.put(AntStatus.ZIPPING,      "ZIPping up files...");
    antMessages.put(AntStatus.DONE,         "Build complete.");
    antMessages.put(AntStatus.ERROR,        "Error occurred.");
    // Iterate and print messages
    for (AntStatus status : AntStatus.values() ) {
      out.println("For status " + status + ", message is: " +
                  antMessages.get(status));
    }
  }
```

- switch枚举
```java
public String getDescription() {
    switch(this) {
      case ROSEWOOD:      return "Rosewood back and sides";
      case MAHOGANY:      return "Mahogany back and sides";
      case ZIRICOTE:      return "Ziricote back and sides";
      case SPRUCE:        return "Sitka Spruce top";
      case CEDAR:         return "Wester Red Cedar top";
      case AB_ROSETTE:    return "Abalone rosette";
      case AB_TOP_BORDER: return "Abalone top border";
      case IL_DIAMONDS:   
        return "Diamonds and squares fretboard inlay";
      case IL_DOTS:
        return "Small dots fretboard inlay";
      default: return "Unknown feature";
    }
  }
```
## <font size=4> **`0x003`** </font> <font size=4> **自动拆箱/装箱** </font>
将primitive类型转换成对应的wrapper类型：Boolean、Byte、Short、Character、Integer、Long、Float、Double

## <font size=4> **`0x004`** </font> <font size=4> **可变参数** </font>
```java
private String print(Object... values) {
    StringBuilder sb = new StringBuilder();
    for (Object o : values) {
      sb.append(o.toString())
        .append(" ");
    }
    return sb.toString();
  }
```

## <font size=4> **`0x005`** </font> <font size=4> **注解** </font>
- Inherited表示该注解是否对类的子类继承的方法等起作用
```java
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InProgress { }
```
- Target类型
- Rentation表示annotation是否保留在编译过的class文件中还是在运行时可读。

## <font size=4> **`0x006`** </font> <font size=4> **增强for循环 for/in** </font>
for/in循环办不到的事情：

（1）遍历同时获取index

（2）集合逗号拼接时去掉最后一个

（3）遍历的同时删除元素

## <font size=4> **`0x007`** </font> <font size=4> **静态导入** </font>
```java
import static java.lang.System.err;
import static java.lang.System.out;

err.println(msg); 
```

## <font size=4> **`0x008`** </font> <font size=4> **print输出格式化** </font>
```java
 System.out.printf("Line %d: %s%n", i++, line); // 不是println
```

## <font size=4> **`0x009`** </font> <font size=4> **并发支持（JUC）** </font>
- 线程池
- uncaught exception（可以抓住多线程内的异常）
```java
class SimpleThreadExceptionHandler implements
    Thread.UncaughtExceptionHandler {
  public void uncaughtException(Thread t, Throwable e) {
    System.err.printf("%s: %s at line %d of %s%n",
        t.getName(), 
        e.toString(),
        e.getStackTrace()[0].getLineNumber(),
        e.getStackTrace()[0].getFileName());
  }
```

- blocking queue(BlockingQueue)
- JUC类库
## <font size=4> **`0x010`** </font> <font size=4> **Arrays、Queue、线程安全StringBuilder** </font>
- Arrays工具类
```java
Arrays.sort(myArray);
Arrays.toString(myArray)
Arrays.binarySearch(myArray, 98)
Arrays.deepToString(ticTacToe)
Arrays.deepEquals(ticTacToe, ticTacToe3)
```

Queue

`避开集合的add/remove操作，使用**offer、poll操作（不抛异常）**`

Queue接口与List、Set同一级别，都是继承了Collection接口。LinkedList实现了Deque接口。
```java
Queue q = new LinkedList(); //采用它来实现queue
```
Queue相关知识，在后续博文中会有专题讲解。属于比较重要的一块

- Override返回类型
- 单线程StringBuilder
- java.lang.instrument