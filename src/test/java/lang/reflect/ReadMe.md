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

## Constructor
提供类的构造函数的信息和访问权限

## Executable
Method 和 Constructor的超类

## Field
提供字段的信息和访问权限，可以是静态字段和实例字段

## GenericArrayType
表示一种数组类型，其组件类型是参数化类型或类型变量

## GenericDeclaration
声明类型变量的所有实体的通用接口

## GenericSignatureFormatError
当需要解释类型，方法或构造函数的通用签名信息的反射方法遇到语法错误的签名属性时抛出

## InaccessibleObjectException
不能设置访问权限时，抛出的异常

## InvocationHandler
是由代理实例的调用处理程序实现的接口  
每个代理实例都有一个关联的调用处理程序。 在代理实例上调用方法时，方法调用将被编码并调度到其调用处理程序的invoke方法

## InvocationTargetException
是一个已检查的异常，它包装被调用的方法或构造函数抛出的异常

## MalformedParameterizedTypeException
当需要实例化它的反射方法遇到语义错误的参数化类型时抛出

## MalformedParametersException
尝试从类文件中读取方法参数并确定一个或多个参数格式错误时抛出

## Member
成员是反映单个成员（字段或方法）或构造函数的标识信息的接口

## Method
方法提供有关类或接口上的单个方法的信息和访问权限。 反射的方法可以是类方法或实例方法（包括抽象方法）。  
方法允许在将实际参数与基础方法的形式参数进行匹配时进行扩展转换，但如果发生缩小转换则会抛出IllegalArgumentException

## Modifier
修饰符集，通过常量来判断类，方法，成员的访问修饰符

## Parameter
提供有关方法参数的信息，包括名称和修饰符
https://www.shangmayuan.com/a/10368cdcf8a5426a9131160f.html

## ParameterizedType
参数化方法在反射方法第一次需要时创建，实现此接口的实例必须实现equals()

## Proxy
提供动态创建对象的静态方法

## ReflectPermission
反射操作的权限类，用于构造具有指定权限的反射操作权限类

## Type
所有Type类型的接口

## TypeVariable
类型变量的接口

## UndeclaredThrowableException
由invoke抛出的异常

## WildcardType
比如?,？extends Number 或者 ？super Integer ，具有获取类型的上限，和下限方法