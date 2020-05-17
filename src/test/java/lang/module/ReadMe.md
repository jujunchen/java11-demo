模块相关配置类 
module-info.java 中定义模块配置
```java
//导入模块
module appstart {
    requires appfuncs;
}
```

```java
//导出模块
module appfuncs {
    exports appfuncs.simplefuncs;
}
```