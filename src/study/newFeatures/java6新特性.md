Java6开发代号为Mustang(野马),于2006-12-11发行.

## <font size=4> **`0x000`** </font> <font size=4> **简述** </font> 
鸡肋的版本，有JDBC4.0更新、Complier API、WebSevice支持的加强等更新。

## <font size=4> **`0x001`** </font> <font size=4> **Web Services** </font> 
优先支持编写 XML web service 客户端程序。你可以用过简单的annotaion将你的API发布成.NET交互的web services. Mustang 添加了新的解析和 XML 在 Java object-mapping APIs中, 之前只在Java EE平台实现或者Java Web Services Pack中提供.

## <font size=4> **`0x002`** </font> <font size=4> **Scripting（开启JS的支持，算是比较有用的）** </font> 
现在你可以在Java源代码中混入JavaScript了，这对开发原型很有有用，你也可以插入自己的脚本引擎。

## <font size=4> **`0x003`** </font> <font size=4> **Database** </font> 
Mustang 将联合绑定 Java DB (Apache Derby). JDBC 4.0 增加了许多特性例如支持XML作为SQL数据类型，更好的集成Binary Large OBjects (BLOBs) 和 Character Large OBjects (CLOBs) .

## <font size=4> **`0x004`** </font> <font size=4> **More Desktop APIs** </font> 
GUI 开发者可以有更多的技巧来使用 SwingWorker utility ，以帮助GUI应用中的多线程。, JTable 分类和过滤，以及添加splash闪屏。

很显然，这对于主攻服务器开发的Java来说，并没有太多吸引力

## <font size=4> **`0x005`** </font> <font size=4> **Monitoring and Management.** </font> 
绑定了不是很知名的 memory-heap 分析工具Jhat 来查看内核导出。

## <font size=4> **`0x006`** </font> <font size=4> **Compiler Access（这个很厉害）** </font> 
compiler API提供编程访问javac，可以实现进程内编译，动态产生Java代码。

## <font size=4> **`0x007`** </font> <font size=4> **Pluggable Annotation** </font> 
## <font size=4> **`0x008`** </font> <font size=4> **Desktop Deployment.** </font> 
Swing拥有更好的 look-and-feel , LCD 文本呈现, 整体GUI性能的提升。Java应用程序可以和本地平台更好的集成，例如访问平台的系统托盘和开始菜单。Mustang将Java插件技术和Java Web Start引擎统一了起来。

## <font size=4> **`0x009`** </font> <font size=4> **Security** </font> 
XML-数字签名(XML-DSIG) APIs 用于创建和操纵数字签名); 新的方法来访问本地平台的安全服务

## <font size=4> **`0x010`** </font> <font size=4> **The -ilities（很好的习惯）** </font> 
质量，兼容性，稳定性。 80,000 test cases 和数百万行测试代码(只是测试活动中的一个方面). Mustang 的快照发布已经被下载15个月了，每一步中的Bug都被修复了，表现比J2SE 5还要好。

