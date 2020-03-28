# java.lang包
**按照字典顺序排列**

## AbstractMethodError
在尝试调用抽象方法时抛出。 比如定义了一个抽象方法，其中一个方法需要子类实现，不希望用户直接通过抽象方法调用，就可以在该方法中抛出该异常
          
## Appendable
一个接口，定义了基本方法，用于将char序列追加到对象中，如StringBuilder实现了该接口

## ArithmeticException
发生算术异常时抛出，比如"除数为零"时会抛出该异常

## ArrayIndexOutOfBoundsException
非法索引访问数组，比如索引为负数或大于或等于数组的大小

## ArrayStoreException
将错误的类型的对象存储到对象数组中，比如
```
Object[] x = new String[3];
x[0] = new Integer(0);
```

## AssertionError
表示断言失败的错误。

## AutoCloseable
在退出try-with-resources块时，将自动调用close()方法，释放资源,
比如FileInputStream实现了该接口，用于自动关闭资源
https://www.jianshu.com/p/6adb6dbc4140

## Boolean
boolean的包装类

## BootstrapMethodError
表示invokedynamic指令或动态常量不能解决其引导方法和参数

## Byte
byte的包装类

## Character
char的包装类  
``
疑点：
isTitleCase什么是标题属性，没测试出来；
codePoint 是什么？我觉得可以理解为ASCII码值；  
https://www.jianshu.com/p/235ad9c63cf2;  
https://blog.csdn.net/GeekLeee/article/details/84966934
``

## CharSequence
该接口是char值的可读序列，提供对许多不同类型的char序列的统一，只读访问。
比如String,StringBuffer,StringBuilder等都实现了该接口。

## Class
类实例对象，表示类和接口。
枚举类型是一种类，注释类型是一种接口。 每个数组也属于一个类，该类反映为类对象，由具有相同元素类型和维数的所有数组共享。 原始Java类型（ boolean ， byte ， char ， short ， int ， long ， float ，和double ），以及关键字void也表示为类对象。

## ClassCastException
如果类无法强制转换为指定类，抛出该异常
```
Object x = new Integer(0);
System.out.println((String)x);
```

## ClassCircularityError
当Java虚拟机检测到正在加载类的超类存在循环时，抛出

## ClassFormatError
当Java虚拟机尝试读取类文件并格式化错误或者无法解析类文件时，抛出

## ClassLoader
类加载器是一个负责加载类的对象  
Java 9之前的类加载器：  
Bootstrap ClassLoader：负责加载rt.jar包中的类  
Extension ClassLoader: 负责加载Java的扩展类库，jre/lib/ext目录或者java.ext.dirs属性指定的目录  
System ClassLoader: 负责加载classpath配置路径的类文件

Java 9 之后：  
Bootstrap ClassLoader: 加载lib/modules基础模块  
Platform ClassLoader: 平台类加载器，加载Java SE 平台API，及其实现类和由平台类加载器或父级定义的运行时类  
System ClassLoader: 系统类加载器，也称为应用程序类加载器，加载指定的应用程序类路径，模块路径或者JDK指定工具上定义的类

## ClassNotFoundException
当应用程序尝试使用以下命令通过其字符串名称加载类时抛出：
- Class forName方法。
- ClassLoader的findSystemClass方法。
- ClassLoader的loadClass方法。
但是找不到具有指定名称的类的定义。

## ClassValue
懒惰地将计算值与（可能）每种类型相关联。例如，如果动态语言需要为消息发送调用站点遇到的每个类构造消息调度表，则可以使用ClassValue来缓存为遇到的每个类快速执行消息发送所需的信息。

## Cloneable
类实现Cloneable接口，以向Object.clone()方法指示该方法对该类的实例进行字段到字段复制是合法的。    
在未实现Cloneable接口的实例上调用Object的clone方法会导致抛出异常CloneNotSupportedException 。  
按照惯例，实现此接口的类应使用公共方法覆盖Object.clone （受保护），此接口不包含clone方法。 因此，仅仅通过实现该接口来克隆对象是不可能的。 即使反射调用clone方法，也无法保证它会成功

## CloneNotSupportedException
抛出此异常表示调用类Object中的clone方法来克隆对象，但该对象的类未实现Cloneable接口。  
覆盖clone方法的应用程序也可以抛出此异常，以指示无法克隆或不应克隆对象

## Comparable
实现此接口的对象的列表（和数组）可以由Collections.sort （和Arrays.sort ）自动排序。   
实现该接口的对象，可以使用如在键sorted map或作为在元件sorted set ，而不需要指定一个comparator 。

## Deprecated
标识了表示代码不建议使用，或者未来会删除

## Double
基本类型double的包装类型

## Enum
枚举类型的公共基类

## EnumConstantNotPresentException
当应用程序尝试按名称访问枚举常量并且枚举类型不包含具有指定名称的常量时抛出

## Error
Error是Throwable的一个子类，表示严重的错误，不应该捕获

## Exception
Throwable的子类，表示合理的应用程序异常，可以捕获.  
不属于RuntimeException子类的异常都是检查异常，需要显式throws抛出

## ExceptionInInitializerError
表示在静态初始化程序或者静态变量初始化时发生异常

## Float
基本类型float的包装类型

## Throwable
所有错误和异常的超类。  
//todo  
getCause 为什么需要加synchronized？  
printStackTrace 导致内存异常？

## FunctionalInterface
一种注解，表示该接口是一种功能接口，可以使用Lambda表达式。  
但不使用该注解，编译器还是会将满足功能接口定义的任何接口视为功能接口

## IllegalAccessError
如果应用程序尝试访问或修改字段，或调用其无权访问的方法，则抛出该异常。  
通常，编译器会捕获此错误; 如果类的定义不兼容地更改，则此错误只能在运行时发生

## IllegalAccessException
当应用程序尝试反射创建实例（数组除外），当前正在执行的方法无法访问指定类的字段，方法或构造函数，抛出IllegalAccessException，  

## IllegalArgumentException
当方法被传递非法或不适当的参数时，抛出该异常

## IllegalCallerException
当调用发不正确的调用方法时，抛出该异常

## IllegalMonitorStateException
抛出此异常表示线程已尝试在对象的监视器上等待，或者在没有指定监视器的情况下通知在对象监视器上等待的其他线程

## IllegalStateException
表示在非法或者不适当的时间调用了方法

## IllegalThreadStateException
线程未处于所请求操作的适当状态，将抛出异常

## IncompatibleClassChangeError
在某些类定义发生不兼容的类更改时抛出。   
此后正在执行的方法所依赖的某个类的定义已经发生了变化

## IndexOutOfBoundsException
抛出以指示某种索引（例如数组，字符串或向量）超出范围。  
应用程序可以将此类子类化以指示类似的异常

## InheritableThreadLocal
ThreadLocal的子类，他可以获取父线程中的数据  
https://www.cnblogs.com/noteless/p/10448283.html

## InstantiationError
当应用程序尝试使用Java new构造来实例化抽象类或接口时，抛出该异常

## InstantiationException
当应用程序尝试使用Class的newInstance方法创建类的实例时抛出，但无法实例化指定的类对象。 
实例化可能由于各种原因而失败，包括但不限于：
class对象表示抽象类，接口，数组类，基元类型或void
该类没有空构造函数

## Integer
基本类型int的包装类型

## InternalError
表示虚拟机内部发生了意外错误

## InterruptedException
线程被中断时抛出该异常
```
if (Thread.interrupted())  // Clears interrupted status!
      throw new InterruptedException();
```

## Iterable
实现此接口,就允许对象使用增强型for语句

## LayerInstantiationException
创建module layer 失败时抛出

## LinkageError
表示某个类对另一个类存在依懒性，但另一个类编译后，两个类存在不兼容现象

## Long
基本类型long的包装类

## Math
包含一些计算方法