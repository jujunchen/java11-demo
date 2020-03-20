# java.lang包
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