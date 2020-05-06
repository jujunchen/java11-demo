提供用于获取有关类和对象的反射信息的类和接口，允许以编程方式访问有关已加载类的字段，方法和构造函数信息

## AccessibleObject
是类字段，方法，构造器对象的基础类，能够设置反射对象是否允许访问的方法

## AnnotatedArrayType
接口，表示带注解的数组类型的使用，AnnotatedType的子类

## AnnotatedElement
表示当前在VM中允许的程序带注解的元素。该接口允许以反射方式读取注解，此接口中方法返回的所有注解是不可变化，但可序列化的。
通过此接口方法返回的数组可以由调用者修改，而不会影响其他的调用者。

## AnnotatedParameterizedType
表示注解的参数化类型

## AnnotatedType
接口，AnnotatedParameterizedType 是其子类之一

## AnnotatedTypeVariable
接口，AnnotatedType的子类

## AnnotatedWildcardType
接口，AnnotatedType的子类

## Array
提供了动态创建和访问数组的静态方法  
Array允许在获取或设置操作期间进行加宽转换，但如果发生缩小转换，则抛出IllegalArgumentException 