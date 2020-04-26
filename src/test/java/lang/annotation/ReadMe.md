## Annotation
所有注解类的公共接口，但是手动扩展该接口，并不能定义注解类

## AnnotationFormatError
当注解解析器尝试从类文件中读取注解并确定注释格式错误时抛出

## AnnotationTypeMismatchException
抛出以表示程序已尝试访问注解的元素，该注释的类型在编译（或序列化）注解后已更改

## Documented
一个注解，如果其他的注解标记有该注解，表示Javadoc将处理该注解

## ElementType
此枚举类型的常量提供了注解可能出现在Java程序中的语法位置的简单分类。 这些常量用于Target元注释，以指定写入给定类型注释的合法位置

## IncompleteAnnotationException
抛出以指示程序已尝试访问在编译（或序列化）注释之后添加到注解类型定义的注解类型的元素。 如果新元素具有默认值，则不会抛出此异常

## Inherited
用于注解类上，具有该标识的注解，并且注解声明在类上，并且实现了子类，那么子类将继承该注解

## Repeatable
用于注解类上，有该标识的注解表示是可重复的
https://blog.csdn.net/ljcgit/article/details/81708679

## Retention
指示要保留带注释类型的注释的时间长度。 如果注释类型声明中不存在保留注释，则保留策略默认为RetentionPolicy.CLASS

## RetentionPolicy
注解保留策略。 此枚举类型的常量描述了用于保留注解的各种策略。 它们与Retention元注解类型结合使用，以指定要保留注解的时间

## Target
表示注解类型适用的上下文

