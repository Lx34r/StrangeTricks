在Java 8中，Base64编码已经成为Java类库的标准。

Base64是一种字符串编码格式，采用了A-Z，a-z，0-9，“+”和“/”这64个字符来编码原始字符（还有垫字符“=”）。一个字符本身是一个字节，也就是8位，而base64编码后的一个字符只能表示6位的信息。也就是原始字符串中的3字节的信息编码会变成4字节的信息。Base64的主要作用是满足MIME的传输需求。

Java 8 内置了 Base64 编码的编码器和解码器。

Base64工具类提供了一套静态方法获取下面三种BASE64编解码器：

- **基本**：输出被映射到一组字符A-Za-z0-9+/，编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/。
- **URL**：输出映射到一组字符A-Za-z0-9+_，输出是URL和文件。
- **MIME**：输出隐射到MIME友好格式。输出每行不超过76字符，并且使用'\r'并跟随'\n'作为分割。编码输出最后没有行分割。

## <font size=4> **`0x000`** </font> <font size=4> **Base64的原理** </font> 

`为什么会有Base64编码呢？因为有些网络传送渠道并不支持所有的字节，例如传统的邮件只支持可见字符的传送，像ASCII码的控制字符就 不能通过邮件传送。这样用途就受到了很大的限制，比如图片二进制流的每个字节不可能全部是可见字符，所以就传送不了。最好的方法就是在不改变传统协议的情 况下，做一种扩展方案来支持二进制文件的传送。把不可打印的字符也能用可打印字符来表示，问题就解决了。Base64编码应运而生，Base64就是一种 基于64个可打印字符来表示二进制数据的表示方法。
`
有一个数组，里面有“A-Z, a-z, 0-9 , + , /”一共64个字符。然后对需要处理的的二进制数据做处理：每3个字节（24bit）一组，因此按照6bit一组为Base64的规则可以划为4组，每组6bit，刚好64位（对应数组的64个值）

Base64的码表只有64个字符， 如果要表达64个字符的话，使用6的bit即可完全表示(2的6次方为64)。
`如果是字符串转换为Base64码， 会先把对应的字符串转换为ascll码表对应的数字， 然后再把数字转换为2进制， 比如a的ascll码味97， 97的二进制是：01100001， 把8个二进制提取成6个，剩下的2个二进制和后面的二进制继续拼接， 最后再把6个二进制码转换为Base64对于的编码
`
**所以，Base64编码会把3字节的二进制数据编码为4字节的文本数据，长度增加33%，好处是编码后的文本数据可以在邮件正文、网页等直接显示。**

如果要编码的二进制数据不是3的倍数，最后会剩下1个或2个字节怎么办？Base64用\x00字节在末尾补足后，再在编码的末尾加上1个或2个=号，表示补了多少字节，解码的时候，会自动去掉。

## <font size=4> **`0x001`** </font> <font size=4> **内嵌类** </font> 
|序号	|内嵌类 & 描述|
| --- | ----------------- |
|1	|**static class Base64.Decoder** <br>该类实现一个解码器用于，使用 Base64 编码来解码字节数据。|
|2	|**static class Base64.Encoder** <br>该类实现一个编码器，使用 Base64 编码来编码字节数据。|

## <font size=4> **`0x002`** </font> <font size=4> **方法** </font> 
|序号	|方法名 & 描述|
| --- | ----------------- |
|1	|**static Base64.Decoder getDecoder()** <br>返回一个 Base64.Decoder ，解码使用基本型 base64 编码方案。|
|2	|**static Base64.Encoder getEncoder()** <br>返回一个 Base64.Encoder ，编码使用基本型 base64 编码方案。|
|3	|**static Base64.Decoder getMimeDecoder()** <br>返回一个 Base64.Decoder ，解码使用 MIME 型 base64 编码方案。|
|4	|**static Base64.Encoder getMimeEncoder()** <br>返回一个 Base64.Encoder ，编码使用 MIME 型 base64 编码方案。|
|5	|**static Base64.Encoder getMimeEncoder(int lineLength, byte[] lineSeparator)** <br>返回一个 Base64.Encoder ，编码使用 MIME 型 base64 编码方案，可以通过参数指定每行的长度及行的分隔符。|
|6	|**static Base64.Decoder getUrlDecoder()** <br>返回一个 Base64.Decoder ，解码使用 URL 和文件名安全型 base64 编码方案。|
|7	|**static Base64.Encoder getUrlEncoder()** <br>返回一个 Base64.Encoder ，编码使用 URL 和文件名安全型 base64 编码方案。|

注意：Base64 类的很多方法从 **java.lang.Objectjava.lang.Object** 类继承。

## <font size=4> **`0x003`** </font> <font size=4> **Base64 实例** </font> 
以下实例演示了 Base64 的使用:
```java
import java.util.Base64;
import java.util.UUID;
import java.io.UnsupportedEncodingException;
 
public class Java8Tester {
   public static void main(String args[]){
      try {
        
         // 使用基本编码
         String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
         System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
        
         // 解码
         byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        
         System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
         base64encodedString = Base64.getUrlEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
         System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
        
         StringBuilder stringBuilder = new StringBuilder();
        
         for (int i = 0; i < 10; ++i) {
            stringBuilder.append(UUID.randomUUID().toString());
         }
        
         byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
         String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
         System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);
         
      }catch(UnsupportedEncodingException e){
         System.out.println("Error :" + e.getMessage());
      }
   }
}
```
执行以上脚本，输出结果为：
```
$ javac Java8Tester.java 
$ java Java8Tester
原始字符串: runoob?java8
Base64 编码字符串 (URL) :VHV0b3JpYWxzUG9pbnQ_amF2YTg=
Base64 编码字符串 (MIME) :M2Q4YmUxMTEtYWRkZi00NzBlLTgyZDgtN2MwNjgzOGY2NGFlOTQ3NDYyMWEtZDM4ZS00YWVhLTkz
OTYtY2ZjMzZiMzFhNmZmOGJmOGI2OTYtMzkxZi00OTJiLWEyMTQtMjgwN2RjOGI0MTBmZWUwMGNk
NTktY2ZiZS00MTMxLTgzODctNDRjMjFkYmZmNGM4Njg1NDc3OGItNzNlMC00ZWM4LTgxNzAtNjY3
NTgyMGY3YzVhZWQyMmNiZGItOTIwZi00NGUzLTlkMjAtOTkzZTI1MjUwMDU5ZjdkYjg2M2UtZTJm
YS00Y2Y2LWIwNDYtNWQ2MGRiOWQyZjFiMzJhMzYxOWQtNDE0ZS00MmRiLTk3NDgtNmM4NTczYjMx
ZDIzNGRhOWU4NDAtNTBiMi00ZmE2LWE0M2ItZjU3MWFiNTI2NmQ2NTlmMTFmZjctYjg1NC00NmE1
LWEzMWItYjk3MmEwZTYyNTdk
```

使用实例
```java
public static void main(String[] args) {
        String orig = "hello world!";
        //编码加密
        String desc = Base64.getEncoder().encodeToString(orig.getBytes(StandardCharsets.UTF_8));
        System.out.println("加密后的字符串为:"+desc);

        //解码解密
        String unDecodeStr=new String(Base64.getDecoder().decode(desc),StandardCharsets.UTF_8);
        System.out.println("解密后的字符串为"+unDecodeStr);
    }
输出:
加密后的字符串为:aGVsbG8gd29ybGQh
解密后的字符串为hello world!
```
将文件File转换为Base64
```java
public static String fileToBase64(String path) {
        File file = new File(path);
        FileInputStream inputFile;
        try {
            inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
            return Base64.getEncoder().encodeToString(buffer);
        } catch (Exception e) {
            throw new RuntimeException("文件路径无效\n" + e.getMessage());
        }
    }
```
将Base64转换为file文件
```java
public static boolean base64ToFile(String base64, String path) {
        byte[] buffer;
        try {
            buffer = Base64.getDecoder().decode(base64);
            FileOutputStream out = new FileOutputStream(path);
            out.write(buffer);
            out.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("base64字符串异常或地址异常\n" + e.getMessage());
        }
    }
```
