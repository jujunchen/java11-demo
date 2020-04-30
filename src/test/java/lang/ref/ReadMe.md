提供引用对象类，支持与垃圾收集器有限度的交互。程序可以使用引用对象来维护对某个其他对象的引用，使得后者对象仍然可以由收集器回收。 程序还可以安排在收集器确定给定对象的可达性已经改变之后的某个时间通知。

## Cleaner
管理一组对象引用和相应的清理操作

## Reference
引用对象的抽象基类。 此类定义所有引用对象共有的操作。 由于引用对象是与垃圾收集器密切配合实现的，因此该类可能不会直接进行子类化。

## PhantomReference
幻像引用对象，在收集器之后排队，确定它们的对象可以被回收。 幻影参考通常用于安排事后清理操作。
为了确保可回收对象保持如此，可能无法检索幻像引用的引用：幻像引用的get方法始终返回null 。

## ReferenceQueue
参考队列，在检测到适当的可达性更改后，垃圾收集器将附加的注册引用对象附加到该引用队列

## SoftReference
软参考对象，由垃圾收集器根据内存需求自行决定清除。 软引用通常用于实现对内存敏感的缓存。

## WeakReference
弱引用对象，它们不会阻止它们的指示物被最终化，最终化，然后回收。 弱引用最常用于实现规范化映射。