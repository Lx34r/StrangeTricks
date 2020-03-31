方法的参数名，在很多时候我们是需要反射得到的。但是在java8之前，代码编译为class文件后，方法参数的类型是固定的，但参数名称却丢失了，这和动态语言严重依赖参数名称形成了鲜明对比。（java是静态语言，所以入参名称叫什么其实无所谓的）。虽然名称无所谓，但很多时候，我们需要此名称来做更好的安排.

比如mybatis的Dao层接口方法，需要特意用个注解@Param来显示标识出参数名，当时写的时候我觉得挺傻X的一件事，所以java8来了，带来的新特性解决了这一问题

## <font size=4> **`0x000`** </font> <font size=4> **获取方法参数名称** </font> 
- **方法一：采用javassit包获取，很麻烦，此处省略**
- **方法二：通过spring的LocalVariableTableParameterNameDiscoverer**
```java
  public static void main(String[] args) {
        List<String> paramterNames = getParamterName(StaffMark.class, "fun1");
        paramterNames.forEach((x) -> System.out.println(x));
    }

    public static void fun1(String aaa, Integer bbb) {

    }

    public static List<String> getParamterName(Class clazz, String methodName) {
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (methodName.equals(method.getName())) {
                //获取到该方法的参数们
                String[] params = u.getParameterNames(method);
                return Arrays.asList(params);
            }
        }
        return null;
    }
输出:
aaa
bbb
```
备注：如果不用Class，而是通过spring注入的实例，然后instance.getClass.getDeclaredMethods()则无法得到参数名，调试时看到方法名称是通过jdk代理过的，拿不到参数名。

- **方法三：通过Java8的Parameter类**
现在，Java 8开始在class文件中保留参数名，给反射带来了极大的便利。jdk8增加了类Parameter

```java
  public static void main(String[] args) {
        List<String> paramterNames = getParameterNameJava8(StaffMark.class, "fun1");
        paramterNames.forEach((x) -> System.out.println(x));
    }

    public static void fun1(String aaa, Integer bbb) {

    }

    public static List<String> getParameterNameJava8(Class clazz, String methodName) {
        List<String> paramterList = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (methodName.equals(method.getName())) {
                //直接通过method就能拿到所有的参数
                Parameter[] params = method.getParameters();
                for (Parameter parameter : params) {
                    paramterList.add(parameter.getName());
                }

            }
        }

        return paramterList;
    }
输出:
arg0
arg1
```

哈哈，被骗了有木有？其实并不是，因为java8为了保持向下兼容，默认编译是不能获取到参数名称的。需要满足下面两个条件

1. JDK版本必须是1.8及以上
2. 编译时候必须有编译选项：javac -parameters打开，默认是关闭的

附：idea设置保留参数名：

在 preferences-》Java Compiler->设置模块字节码版本1.8，Javac Options中的 Additional command line parameters: -parameters

这样设置之后，我们再运行上面代码，发现输出的结果为：
```java
输出:
aaa
bbb
```
有了这个特性之后，以后咱们编译的时候加上启动参数，使用Mybatis再也不需要那烦人的@Param注解了

