package lang;

import lang.test.Dog;
import org.junit.Test;

import java.beans.JavaBean;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.*;

/**
 * java.lang.Class 测试类
 *
 * @author jujun chen
 * @date 2020/03/01
 */
public class ClassTest {

    @Test
    public void toGenericString() {
        /**
         * 返回描述Class的字符串，包括修饰符，和类型参数的信息
         * @since 1.8
         */
        System.out.println(this.getClass().toGenericString()); //public class lang.ClassTest
    }

    @Test
    public void forName() throws Exception {
        /**
         * 返回与给定字符串名称相关联的类或接口的Class对象
         *  此方法等效于：
         *  Class.forName(className, true, currentLoader)
         * 其中currentLoader表示当前类的定义类加载器。
         * 例如，以下代码片段返回名为java.lang.Thread的类的运行时类描述符：
         *  Class t = Class.forName("java.lang.Thread")
         * 调用forName("X")会导致名为X的类被初始化。
         *
         * 参数：
         * className - 类的全限定名
         */
        Class chinesePeople = Class.forName("lang.ChinesePeople");

        /**
         * 使用指定的类加载器，加载给定字符串名称相关联的Class对象
         *
         * 参数：
         * name - 类的全限定名
         * initialize - true 代表加载类，false代表不加载类
         * loader - 指定的类加载器
         */
        Class chinessPeople1 = Class.forName("lang.ChinesePeople", true, this.getClass().getClassLoader());

        /**
         * 返回指定模块中，与给定字符串相关的Class对象
         * 不会初始化类
         *
         * 参数：
         *  module - 模块
         *  name - 类的全限定名
         */
        //todo
        //Class.forName();
    }

    /**
     * 创建Class对象的实例
     * 会执行无参构造器
     * <p>
     * 在jdk9中过期，使用clazz.getDeclaredConstructor().newInstance()替换
     */
    @Test
    public void newInstance() throws Exception {

        Class chinesePeople = Class.forName("lang.ChinesePeople");
        ChinesePeople chinesePeople2 = (ChinesePeople) chinesePeople.newInstance();
        ChinesePeople chinesePeople3 = (ChinesePeople) chinesePeople.getDeclaredConstructor().newInstance();
        /**
         * 加载类
         * 实例化类，我是中国人
         * 实例化类，我是中国人
         */
    }

    /**
     * 确定给定的Object是否与该Class表示的对象赋值兼容。
     *
     * 此方法是 Java 语言instanceof运算符的动态等效方法。
     *
     * 如果指定的Object参数为非 null 并且可以强制转换为此Class对象表示的引用类型而不引发ClassCastException. ，
     * 则该方法返回true 。否则返回false 。
     *
     * 具体来说，如果此Class对象表示已声明的类，则如果指定的Object参数是表示的类（或其任何子类）的实例，则此方法返回true ；否则返回false 。
     *
     * 如果此Class对象表示一个数组类，如果指定的Object参数可以通过恒等转换或扩展引用转换转换为数组类的对象，则此方法返回true ；否则返回false 。
     *
     * 如果此Class对象表示一个接口，则如果指定Object参数的类或任何超类实现此接口，则此方法返回true ；否则返回false 。
     *
     * 如果此Class对象表示原始类型，则此方法返回false 。
     * 参形：
     * obj - 要检查的对象
     * 返回值：
     * 如果obj是此类的实例，则为 true
     * 自：
     * 1.1
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void isInstance() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //指定的对象实例是否与该类对象兼容，是否可以转换
        ChinesePeople chinesePeople = new ChinesePeople();
        Person person = new Person();
        //父类不能转换为子类
        System.out.println(chinesePeople.getClass().isInstance(person)); //false
        //子类可以转换为父类
        System.out.println(person.getClass().isInstance(chinesePeople)); //true
        System.out.println(Person.class.isInstance(chinesePeople)); //true

        //对象是本身类的一个实例
        System.out.println(ChinesePeople.class.isInstance(chinesePeople)); //true
        //不是一个对象
        System.out.println(ChinesePeople.class.isInstance(ChinesePeople.class)); //false

        //如果object是数组对象
        Integer[] integers = new Integer[0];
        System.out.println(Number.class.isInstance(integers)); //false
        System.out.println(new Integer[0].getClass().isInstance(integers)); //true

        Person[] persons = new Person[0];
        ChinesePeople[] chinesePeoples = new ChinesePeople[0];
        Person[] chinesePeople2 = new ChinesePeople[0];
        //chinesePeople是Person的子类，兼容
        System.out.println(persons.getClass().isInstance(chinesePeoples)); //true
        //chinesePeople2 是ChinesePeople对象数组，与chinesePeoples兼容
        System.out.println(chinesePeoples.getClass().isInstance(chinesePeople2)); //true


        //Object是所有类的超类
        System.out.println(Object.class.isInstance(chinesePeople)); //true


        //------------instanceof-------------------
        System.out.println(chinesePeoples instanceof Person[]);
    }

    /**
     * 确定此Class对象表示的类或接口是否与指定的Class参数表示的类或接口相同，或者是其超类或超接口。如果是，则返回true ；否则返回false 。如果此Class对象表示原始类型，则如果指定的Class参数正是此Class对象，则此方法返回true ；否则返回false 。
     * 具体来说，该方法测试指定的Class参数表示的类型是否可以通过恒等转换或扩展引用转换转换为该Class对象表示的类型。有关详细信息，请参阅Java 语言规范的第 5.1.1 和 5.1.4 节。
     * 参形：
     * cls – 要检查的Class对象
     * 返回值：
     * boolean值，指示是否可以将cls类型的对象分配给此类的对象
     * 抛出：
     * NullPointerException – 如果指定的 Class 参数为 null。
     * 自：
     * 1.1
     */
    //这个也是表示类对象时候相同，或者兼容（超类或接口），但该方法表示左边的对象是否右边参数的超类、接口或同对象，是顺序的
    @Test
    public void isAssignableFrom() throws ClassNotFoundException {

        Class chinesePeople = Class.forName("lang.ChinesePeople");
        //同类
        assert chinesePeople.isAssignableFrom(ChinesePeople.class);
        //Person 是ChinesePeople 的超类
        assert Person.class.isAssignableFrom(chinesePeople);
        // ChinesePeople 不是Person的超类
        assert !chinesePeople.isAssignableFrom(Person.class);
    }


    /**
     * 确定指定的类对象是否表示接口类型
     */
    @Test
    public void isInterface() {

        assert Animal.class.isInterface();
        assert !ChinesePeople.class.isInterface();
        //注解也是接口
        assert Name.class.isInterface();
    }

    /**
     * 确定指定的类对象是否表示数组类型
     */
    @Test
    public void isArray() {

        ChinesePeople[] chinesePeopleAry = new ChinesePeople[10];
        //确定此类对象是否表示数组类
        assert chinesePeopleAry.getClass().isArray();
    }

    /**
     * 确定指定的类对象是否表示原型类型
     *
     * 只有一下几种才返回真
     Boolean.TYPE ,
     Character.TYPE ,
     Byte.TYPE ，
     Short.TYPE ，
     Integer.TYPE ，
     Long.TYPE ,
     Float.TYPE ，
     Double.TYPE ,
     Void.TYPE
     */
    @Test
    public void isPrimitive() {
        System.out.println(Boolean.TYPE.isPrimitive()); //true
        System.out.println(Person.class.isPrimitive()); //false

        Integer[] integers = new Integer[0];
        System.out.println(integers.getClass().isPrimitive()); //false
        Integer a = 1;
        System.out.println(a.getClass().isPrimitive());//false
    }

    @Test
    public void isAnnotation() {
        //确定此类对象是否表示注解类型
        System.out.println(Test.class.isAnnotation()); //true
        System.out.println(Test.class.isInterface()); //true
    }


    @Test
    public void isSynthetic() {
        //确定此类是否表示合成类
        //http://blog.sina.com.cn/s/blog_1534f339a0102y88n.html
        System.out.println(ChinesePeople.class.isSynthetic()); //false
    }

    /**
     * 返回此类对象表示的实体名称（类，接口，数组类，基本类型或void）
     * 如果此类对象表示不是数组类型的引用类型，则返回该类的二进制名称，如The Java™ Language Specification所指定。
     * <p>
     * 如果此类对象表示基本类型或void，则返回的名称是String等于与基本类型或void对应的Java语言关键字。
     * <p>
     * 如果此类对象表示一个数组类，则该名称的内部形式由元素类型的名称组成，前面是一个或多个表示数组嵌套深度的“ [ ”字符。
     */
    @Test
    public void getName() {

        System.out.println(ChinesePeople.class.getName());
        System.out.println(Animal.class.getName());
        System.out.println(String.class.getName());
        System.out.println(byte.class.getName());
        System.out.println((new Object[3]).getClass().getName());
        System.out.println((new Object[1][2]).getClass().getName());

        /**
         * lang.ChinesePeople
         * lang.Animal
         * java.lang.String
         * byte
         * [Ljava.lang.Object;
         * [[Ljava.lang.Object;
         */
    }

    /**
     * 返回类的类加载器。 某些实现可能使用null来表示引导类加载器。 如果此类由引导类加载器加载，则此方法将在此类实现中返回null。
     * 如果此对象表示基本类型或void，则返回null。
     */
    @Test
    public void getClassLoader() {
        System.out.println(ChinesePeople.class.getClassLoader());
        System.out.println(String.class.getClassLoader());

        /**
         * jdk.internal.loader.ClassLoaders$AppClassLoader@47f37ef1
         * null
         */
    }

    /**
     * 返回此类或接口所属的模块。
     * 如果此类表示数组类型，则此方法返回元素类型的模块 。
     * 如果此类表示基本类型或void，则返回java.base模块的模块对象。
     * 如果此类位于未命名的模块中，则返回 模块的类加载器的unnamed 模块 。
     */
    @Test
    public void getModule() {
        //ChinesePeople 位于lang包中，定义了一个modele名为java.test
        System.out.println(List.class.getModule());
        System.out.println(ChinesePeople.class.getModule());
        System.out.println(new Integer[0].getClass().getModule());
        System.out.println(String.class.getModule());

        /**
         * module java.base
         * module java.test
         * module java.base
         * module java.base
         */
    }

    /**
     * 返回泛型的变量名称。
     * 如果基础泛型声明未声明类型变量，则返回长度为0的数组。
     */
    @Test
    public void getTypeParameters() {

        TypeVariable[] typeVariables = List.class.getTypeParameters();
        System.out.println(Arrays.toString(typeVariables));
        TypeVariable[] typeVariables1 = Animal.class.getTypeParameters();
        System.out.println(typeVariables1.length);
        TypeVariable[] typeVariables2 = TreeMap.class.getTypeParameters();
        System.out.println(Arrays.toString(typeVariables2));

        /**
         * [E]
         * 0
         * [K, V]
         */
    }

    /**
     * 返回表示此类表示的实体的直接超类（类，接口，基本类型或void）的类 。
     * 如果此类表示Object类，接口，基本类型或void，则返回null。
     * 如果此对象表示数组类，则返回表示Object类的类对象。
     */
    @Test
    public void getSuperclass() {

        //ChinesePeople 继承Person，返回class lang.Person
        System.out.println(ChinesePeople.class.getSuperclass());
        //Person实现了Animal，Person的超类是class java.lang.Object
        System.out.println(Person.class.getSuperclass());
        //Bird实现了Animal，同理，所以该方法说的超类是指继承的父类
        System.out.println(Bird.class.getSuperclass());
        //Object、接口、原始类型、void返回null
        System.out.println(Animal.class.getSuperclass());
        System.out.println(Object.class.getSuperclass());
        System.out.println(byte.class.getSuperclass());
        System.out.println(void.class.getSuperclass());
        //数组类型返回Object
        System.out.println(new Object[0].getClass().getSuperclass());
        //枚举的超类
        System.out.println(Status.class.getSuperclass());

        /**
         * class lang.Person
         * class java.lang.Object
         * class java.lang.Object
         * null
         * null
         * null
         * null
         * class java.lang.Object
         * class java.lang.Enum
         */
    }

    /**
     * 返回Type表示此所表示的实体（类，接口，基本类型或void）的直接超类类 。
     * 如果超类是参数化类型，则返回的Type对象必须准确反映源代码中使用的实际类型参数。
     * 如果之前尚未创建超类，则创建表示超类的参数化类型。
     * 有关参数化类型的创建过程的语义，请参阅ParameterizedType的声明。
     * 如果此类表示Object类，接口，基本类型或void，则返回null。
     * 如果此对象表示数组类，则返回表示Object类的类对象。
     */
    @Test
    public void getGenericSuperclass() {

        Type type = ChinesePeople.class.getGenericSuperclass();
        System.out.println(type.getTypeName());
        Type type1 = Person.class.getGenericSuperclass();
        System.out.println(type1.getTypeName());
        //返回null
        Type type2 = Object.class.getGenericSuperclass();
        System.out.println(type2);
        Type type3 = Animal.class.getGenericSuperclass();
        System.out.println(type3);

        /**
         * lang.Person
         * java.lang.Object
         * null
         * null
         */
    }

    /**
     * 获取该类的包
     * 如果此类表示数组类型，基本类型或void，则此方法返回null
     */
    @Test
    public void getPackage() {

        System.out.println(ChinesePeople.class.getPackage());
    }

    /**
     * 返回完全限定的包名称。
     * 如果此类是顶级类，则此方法返回该类所属的包的完全限定名称，如果该类位于未命名的包中，则返回空字符串。
     * 如果此类是成员类，则此方法等效于在封闭类上调用getPackageName() 。
     * 如果此类是本地类或匿名类，则此方法等效于在封闭方法或封闭构造函数的声明类上调用getPackageName() 。
     * 如果此类表示数组类型，则此方法返回元素类型的包名称。如果此类表示原始类型或 void，则返回包名称“ java.lang ”。
     * 返回值：
     * 完全限定的包名
     * 自：9
     */
    @Test
    public void getPackageName() {

        System.out.println(ChinesePeople.class.getPackageName());
        System.out.println(ChinesePeople.ZjPeople.class.getPackageName());
        System.out.println(Object.class.getPackageName());
        System.out.println(new Object[0].getClass().getPackageName());

        Integer[] integers = new Integer[0];
        System.out.println(integers.getClass().getPackageName());
        Dog[] dogs = new Dog[0];
        System.out.println(dogs.getClass().getPackageName());

        /**
         * lang
         * lang
         * java.lang
         * java.lang
         * java.lang
         * lang.test
         */
    }

    /**
     * 返回此类的接口
     * <p>
     * 如果此对象表示类，则返回值是一个数组，其中包含表示该类直接实现的所有接口的对象。
     * <p>
     * 数组中接口对象的顺序对应于此对象所表示的类的声明的implements子句中的接口名称的顺序。 例如，鉴于声明：
     * <p>
     * class Shimmer implements FloorWax, DessertTopping { ... }
     * 假设的值s是实例Shimmer ; 表达式的值：
     * s.getClass().getInterfaces()[0]
     * 是类对象，表示接口FloorWax ; 和价值：
     * s.getClass().getInterfaces()[1]
     * 是类对象，表示接口DessertTopping 。
     * 如果此对象表示接口，则该数组包含表示由接口直接扩展的所有接口的对象。 数组中接口对象的顺序对应于此对象表示的接口声明的extends子句中接口名称的顺序。
     * <p>
     * 如果此对象表示不实现接口的类或接口，则该方法返回长度为0的数组。
     * <p>
     * 如果此对象表示基本类型或void，则该方法返回长度为0的数组。
     * <p>
     * 如果此类对象表示阵列类型， Cloneable顺序返回接口Cloneable和java.io.Serializable 。
     */
    @Test
    public void getInterfaces() {

        //ChinesePeople继承的Person,没有实现接口
        Class[] interfaces = ChinesePeople.class.getInterfaces();
        System.out.println(Arrays.toString(interfaces)); //0
        //Person实现了接口Animal
        Class[] interfaces2 = Person.class.getInterfaces();
        System.out.println(Arrays.toString(interfaces2)); //[interface lang.Animal]
        //Collection接口返回继承的接口
        System.out.println(Arrays.toString(Collection.class.getInterfaces())); //[interface java.lang.Iterable]
        //ArrayList类按顺序返回其实现的接口，不返回继承的类
        //[interface java.util.List, interface java.util.RandomAccess, interface java.lang.Cloneable, interface java.io.Serializable]
        System.out.println(Arrays.toString(ArrayList.class.getInterfaces()));
    }

    /**
     * 同getInterfaces，只是返回结果为Type类型
     * 如接口是泛型，则返回带泛型名的接口
     */
    @Test
    public void getGenericInterfaces() {

        System.out.println(Arrays.toString(Collection.class.getGenericInterfaces()));
        //[java.lang.Iterable<E>]
    }

    /**
     * 返回表示数组的组件类型的类 。
     * <p>
     * 如果此类不表示数组类，则此方法返回null
     */
    @Test
    public void getComponentType() {

        Class componentType = new Object[1].getClass().getComponentType();
        System.out.println(componentType); //class java.lang.Object

        System.out.println(new Integer[0].getClass().getComponentType());//class java.lang.Integer

        //ChinesePeople不是数组
        Class componentType2 = ChinesePeople.class.getComponentType();
        System.out.println(componentType2); //null
    }

    /**
     * 返回此类或接口的Java语言修饰符，以整数编码。
     * 修饰符由Java虚拟机的常数为public ， protected ， private ， final ， static ， abstract和interface ;
     * 它们应该使用Modifier类的方法解码。
     */
    @Test
    public void getModifiers() {

        System.out.println(ChinesePeople.class.getModifiers()); //1
        //Modifier提供了各种方法判断获取的整型代表public，还是protected
        System.out.println(Modifier.isPublic(ChinesePeople.class.getModifiers()));
    }

    /**
     * 获取此类的签名者
     * 此类的签名者，如果没有签名者则为null。 特别是，如果此对象表示基本类型或void，则此方法返回null。
     * //todo 具体怎么给类签名还不清楚，不过这个方法在Java内部经常看到
     */
    @Test
    public void getSigners() {

        assert ChinesePeople.class.getSigners() == null;
        assert int.class.getSigners() == null;
        assert Void.class.getSigners() == null;

    }

    /**
     * 如果此类对象表示方法中的本地或匿名类，则返回方法对象，该对象表示基础类的直接封闭方法。
     * 否则返回null 。
     * 特别是，如果基础类是由类型声明，实例初始化程序或静态初始化程序直接包含的本地或匿名类，则此方法返回null 。
     */
    @Test
    public void getEnclosingMethod() {

        Runnable runnable = () -> {
        };
        Method method = runnable.getClass().getEnclosingMethod();
        System.out.println(method); //null

        Method method1 = getPerson().getClass().getEnclosingMethod();
        System.out.println(method1); //private lang.Person lang.ClassTest.getPerson()
    }

    private Person getPerson() {
        class BjPerson extends Person {

        }

        return new BjPerson();
    }

    /**
     * 如果此类对象表示构造函数中的本地或匿名类，则返回构造器对象，该对象表示基础类的直接封闭构造函数。
     * 否则返回null 。
     * 特别是，如果基础类是由类型声明，实例初始化程序或静态初始化程序直接包含的本地或匿名类，则此方法返回null 。
     */
    @Test
    public void getEnclosingConstructor() {

        class OuterClass {
            public Object test;

            public OuterClass() {
                class InnerClass {
                }
                test = new InnerClass();
            }
        }
        Constructor constructor = new OuterClass().test.getClass().getEnclosingConstructor();
        assert constructor.getName().equals("lang.ClassTest$1OuterClass");
    }

    /**
     * 如果此类对象表示的类或接口是另一个类的成员，则返回表示声明它的类的类对象。
     * 如果此类或接口不是任何其他类的成员，则此方法返回null。
     * 如果此类对象表示数组类，基本类型或void，则此方法返回null。
     */
    @Test
    public void getDeclaringClass() {
        Class cls = ChinesePeople.ZjPeople.class.getDeclaringClass();
        assert cls.getName().equals("lang.ChinesePeople");
        Class cls2 = ChinesePeople.class.getDeclaringClass();
        assert cls2 == null;
    }


    /**
     * 返回基础类的直接封闭类。 如果底层类是顶级类，则此方法返回null 。
     */
    @Test
    public void getEnclosingClass() {

        Runnable runnable = () -> {
        };
        Class cls = runnable.getClass().getEnclosingClass();
        assert cls == null;
        Class cls2 = ChinesePeople.ZjPeople.class.getEnclosingClass();
        assert cls2.equals("lang.ChinesePeople");
    }

    /**
     * 返回源代码中给出的基础类的简单名称。 如果基础类是匿名的，则返回空字符串。
     * 数组的简单名称是附加了“[]”的组件类型的简单名称。 特别是组件类型为匿名的数组的简单名称是“[]”。
     */
    @Test
    public void getSimpleName() {

        System.out.println(Integer.class.getSimpleName());
        System.out.println(ChinesePeople.class.getSimpleName());
        System.out.println(new Object[0].getClass().getSimpleName());
    }

    /**
     * 返回此类名称的信息字符串
     */
    @Test
    public void getTypeName() {

        System.out.println(ChinesePeople.class.getTypeName());
        System.out.println(int.class.getTypeName());
        System.out.println(new Object[0].getClass().getTypeName());
    }

    /**
     * 返回Java语言规范定义的基础类的规范名称。
     * 如果基础类没有规范名称（即，如果它是本地或匿名类或其组件类型没有规范名称的数组），则返回null。
     */
    @Test
    public void getCanonicalName() {

        Runnable runnable = () -> {
        };

        System.out.println(runnable.getClass().getCanonicalName());

        class OuterClass {
            public Object test;

            public OuterClass() {
                class InnerClass {
                }
                test = new InnerClass();
            }
        }

        System.out.println(OuterClass.class.getCanonicalName());
        System.out.println(new OuterClass().test.getClass().getCanonicalName());
    }

    /**
     * 当且仅当基础类是匿名类时，返回 true
     */
    @Test
    public void isAnonymousClass() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        System.out.println(runnable.getClass().isAnonymousClass());
    }

    /**
     * 当该类是本地类时，返回true
     */
    @Test
    public void isLocalClass() {

        class OuterClass {

        }
        System.out.println(OuterClass.class.isLocalClass());
    }

    /**
     * 当该类是成员类时，返回true
     */
    @Test
    public void isMemberClass() {

        System.out.println(ChinesePeople.ZjPeople.class.isMemberClass());
        System.out.println(ChinesePeople.class.isMemberClass());
    }

    /**
     * 返回一个数组，其中包含类对象，这些对象表示属于此Class对象所表示的类的成员的所有公共类和接口。
     * 这包括从超类继承的公共类和接口成员，以及由类声明的公共类和接口成员。
     * 如果此类对象没有公共成员类或接口，则此方法返回长度为0的数组。
     * 如果此类对象表示基本类型，数组类或void，则此方法还返回长度为0的数组。
     */
    @Test
    public void getClasses() {

        class OuterClass {
            class InnerClass {
            }
        }
        System.out.println(Arrays.toString(ChinesePeople.class.getClasses()));
        System.out.println(Arrays.toString(ChinesePeople.ZjPeople.class.getClasses()));
        System.out.println(Arrays.toString(OuterClass.class.getClasses()));
    }

    /**
     * 返回一个包含字段对象的数组， 字段对象反映此类对象所表示的类或接口的所有可访问公共字段。
     * 如果此类对象表示没有可访问的公共字段的类或接口，则此方法返回长度为0的数组。
     * <p>
     * 如果此类对象表示一个类，则此方法返回该类及其所有超类和超接口的公共字段。
     * <p>
     * 如果此类对象表示接口，则此方法返回接口及其所有超接口的字段。
     * <p>
     * 如果此类对象表示数组类型，基本类型或void，则此方法返回长度为0的数组。
     * <p>
     * 返回数组中的元素未排序，并且不按任何特定顺序排列。
     */
    @Test
    public void getFields() {

        System.out.println(Arrays.toString(ChinesePeople.class.getFields()));
    }

    /**
     * 返回一个包含方法对象的数组， 方法对象反映此类对象所表示的类或接口的所有公共方法，
     * <p>
     * 包括由类或接口声明的那些以及从超类和超接口继承的那些。
     */
    @Test
    public void getMethods() {

        System.out.println(Arrays.toString(Person.class.getMethods()));
    }

    /**
     * 返回一个包含构造器对象的数组， 构造器对象反映了此类对象所表示的类的所有公共构造函数。
     * <p>
     * 如果类没有公共构造函数，或者类是数组类，或者类反映了基本类型或void，则返回长度为0的数组。
     */
    @Test
    public void getConstructors() {

        System.out.println(Arrays.toString(ChinesePeople.class.getConstructors()));
        System.out.println(Arrays.toString(new Object[0].getClass().getConstructors()));
    }

    /**
     * 返回字段对象，该对象反映此类对象表示的类或接口的指定公共成员字段。 name参数是String指定所需字段的简单名称。
     * 要反映的字段由下面的算法确定。 设C为此对象表示的类或接口：
     * 如果C声明一个具有指定名称的公共字段，那就是要反映的字段。
     * 如果在上面的步骤1中没有找到字段，则该算法递归地应用于C的每个直接超接口。直接超接口按它们被声明的顺序搜索。
     * 如果在上面的步骤1和2中没有找到字段，并且C具有超类S，则在S上递归调用该算法。如果C没有超类，则抛出NoSuchFieldException 。
     * 如果此类对象表示数组类型，则此方法找不到数组类型的length字段。
     */
    @Test
    public void getField() throws NoSuchFieldException {

        Field field = Person.class.getField("name");
        System.out.println(field.getName());
        //无法获取私有的address属性，java.lang.NoSuchFieldException: address
        //Field field1 = Person.class.getField("address");
    }

    /**
     * 返回一个方法对象，该对象反映此类对象所表示的类或接口的指定公共成员方法。
     * name参数是String指定所需方法的简单名称。
     * parameterTypes参数是一个类对象的数组，以声明的顺序标识方法的形式参数类型。
     * 如果parameterTypes是null ，则将其视为空数组。
     */
    @Test
    public void getMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = Person.class.getMethod("setName", String.class);
        System.out.println(method.getName());
    }

    /**
     * 返回一个构造器对象，该对象反映此类对象所表示的类的指定公共构造函数。
     * parameterTypes参数是一个类对象的数组，它按声明的顺序标识构造函数的形式参数类型。
     * 如果此类对象表示在非静态上下文中声明的内部类，则形式参数类型包括显式封闭实例作为第一个参数。
     * 要反映的构造函数是此类对象所表示的类的公共构造函数，其形式参数类型与parameterTypes指定的类型相匹配。
     */
    @Test
    public void getConstructor() throws NoSuchMethodException {

        Constructor constructor = ChinesePeople.class.getConstructor();
        System.out.println("无参构造函数名称：" + constructor.getName());
        Constructor constructor1 = ChinesePeople.class.getConstructor(String.class);
        System.out.println("有参构造函数的参数类型：" + constructor1.getParameterTypes()[0]);
    }

    /**
     * 返回类对象的数组， 返回此类对象的成员类和接口。
     * 这包括公共，受保护，默认（包）访问以及类声明的私有类和接口，但不包括继承的类和接口。
     * 如果类声明没有类或接口作为成员，或者此类对象表示基本类型，数组类或void，则此方法返回长度为0的数组。
     */
    @Test
    public void getDeclaredClasses() {

        System.out.println(Arrays.toString(ChinesePeople.class.getDeclaredClasses()));
        System.out.println(Arrays.toString(Person.class.getDeclaredClasses()));
    }

    /**
     * 返回字段对象的数组， 字段对象反映由此类对象表示的类或接口声明的所有字段。
     * <p>
     * 这包括公共，受保护，默认（包）访问和私有字段，但不包括继承的字段。
     * <p>
     * 如果此类对象表示没有声明字段的类或接口，则此方法返回长度为0的数组。
     * <p>
     * 如果此类对象表示数组类型，基本类型或void，则此方法返回长度为0的数组。
     * <p>
     * 返回数组中的元素未排序，并且不按任何特定顺序排列。
     */
    @Test
    public void getDeclaredFields() {

        System.out.println(Arrays.toString(ChinesePeople.class.getDeclaredFields()));
        System.out.println(Arrays.toString(Person.class.getDeclaredFields()));
    }

    /**
     * 返回一个包含方法对象的数组， 方法对象反映此类对象表示的类或接口的所有已声明方法，包括公共，受保护，默认（包）访问和私有方法，但不包括继承的方法。
     * <p>
     * 如果此类对象表示具有多个具有相同名称和参数类型但返回类型不同的声明方法的类型，则返回的数组对于每个此类方法都有一个方法对象。
     * <p>
     * 如果此类对象表示具有类初始化方法的类型<clinit> ，则返回的阵列不具有相应的方法对象。
     * <p>
     * 如果此类对象表示没有声明方法的类或接口，则返回的数组的长度为0。
     * <p>
     * 如果此类对象表示数组类型，基本类型或void，则返回的数组的长度为0。
     * <p>
     * 返回数组中的元素未排序，并且不按任何特定顺序排列。
     */
    @Test
    public void getDeclaredMethods() {

        System.out.println(Arrays.toString(ChinesePeople.class.getDeclaredMethods()));
        System.out.println(Arrays.toString(Person.class.getDeclaredMethods()));
    }

    /**
     * 返回构造器对象的数组， 构造器对象反映由此类对象表示的类声明的所有构造函数。
     * <p>
     * 这些是公共，受保护，默认（包）访问和私有构造函数。
     * <p>
     * 返回的数组中的元素没有排序，也没有任何特定的顺序。
     * <p>
     * 如果类具有默认构造函数，则它包含在返回的数组中。
     * <p>
     * 如果此类对象表示接口，基本类型，数组类或void，则此方法返回长度为0的数组。
     */
    @Test
    public void getDeclaredConstructors() {

        System.out.println(Arrays.toString(ChinesePeople.class.getDeclaredConstructors()));
        System.out.println(Arrays.toString(Person.class.getDeclaredConstructors()));
    }

    /**
     * 返回字段对象，该对象反映此类对象表示的类或接口的指定声明字段。不论是否公开。
     * <p>
     * name参数是String ，它指定所需字段的简单名称。
     * <p>
     * 如果此类对象表示数组类型，则此方法找不到数组类型的length字段。
     */
    @Test
    public void getDeclaredField() throws NoSuchFieldException {

        Field field = Person.class.getDeclaredField("name");
        //address 是私有属性
        Field field1 = Person.class.getDeclaredField("address");

    }


    /**
     * 返回方法对象，该对象反映此类对象所表示的类或接口的指定声明方法。
     * <p>
     * name参数是String ，它指定所需方法的简单名称， parameterTypes参数是类对象的数组，
     * <p>
     * 类对象按声明的顺序标识方法的形式参数类型。
     * <p>
     * 如果在类中声明了多个具有相同参数类型的方法，并且其中一个方法的返回类型比任何其他方法更具体，则返回该方法; 否则任意选择其中一种方法。
     * <p>
     * 如果名称为“<init>”或“<clinit>”，则引发NoSuchMethodException 。
     * <p>
     * 如果此类对象表示数组类型，则此方法找不到clone()方法。
     */
    @Test
    public void getDeclaredMethod() throws NoSuchMethodException {
        Method method = Person.class.getDeclaredMethod("setName", String.class);
        System.out.println(method.getName());
        Method method1 = Person.class.getDeclaredMethod("getAddress");
        System.out.println(method1.getName());
    }

    /**
     * 返回一个构造器对象，该对象反映此类对象所表示的类或接口的指定构造函数。
     * parameterTypes参数是一个类对象的数组，它按声明的顺序标识构造函数的形式参数类型。
     * 如果此类对象表示在非静态上下文中声明的内部类，则形式参数类型包括显式封闭实例作为第一个参数。
     */
    @Test
    public void getDeclaredConstructor() throws NoSuchMethodException {
        Constructor constructor = Person.class.getDeclaredConstructor();
        System.out.println(constructor);
    }

    /**
     * 查找具有给定名称的资源。
     */
    @Test
    public void getResourceAsStream() {
        //通过这种是能找到文件的
//        InputStream i = new FileInputStream(getClass().getResource("/File.txt").getPath());
        //无法找到文件
//        InputStream i = getClass().getResourceAsStream(getClass().getResource("/File.txt").getPath());
        //将File.txt放到该文件同目录就可以找到
        try (InputStream i = getClass().getResourceAsStream("/File.txt");
             BufferedReader r = new BufferedReader(new InputStreamReader(i))) {
            String l;
            String val = "";
            while ((l = r.readLine()) != null) {
                val = val + l;
            }
            System.out.println(val);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 查找具有给定名称的资源。返回URL
     */
    @Test
    public void getResource() {
        URL url = getClass().getResource("/File.txt");
        System.out.println(url);
    }

    /**
     * 返回ProtectionDomain 。
     * 如果安装了安全管理器，则此方法首先使用RuntimePermission("getProtectionDomain")权限调用安全管理器的checkPermission方法，以确保可以获取ProtectionDomain 。
     * <p>
     * 当类装载器将类型装入Java虚拟机时，它们将为每个类型指派一个保护域。
     * 保护域定义了授予一段特定代码的所有权限。（一个保护域对应策略文件中的一个或多个Grant子句。）
     * 装载入Java虚拟机的每一个类型都属于一个且仅属于一个保护域
     * https://blog.csdn.net/yfqnihao/article/details/8271415
     */
    @Test
    public void getProtectionDomain() {
        ProtectionDomain protectionDomain = getClass().getProtectionDomain();
        System.out.println(protectionDomain);
    }


    /**
     * 如果要在调用此方法时初始化，则返回将分配给此类的断言状态。 如果此类已设置其断言状态，则将返回最新设置;
     * 否则，如果任何包默认断言状态属于此类，则返回最具体的相关包默认断言状态的最新设置;
     * 否则，如果此类不是系统类（即，它具有类加载器），则返回其类加载器的默认断言状态; 否则，返回系统类的默认断言状态。
     * 很少有程序员需要这种方法; 它是为了JRE本身的利益而提供的。 （它允许类在初始化时确定是否应该启用断言。）
     * 请注意，此方法不保证返回与指定类关联的（或将要）关联的实际断言状态（或将被初始化）。
     */
    @Test
    public void desiredAssertionStatus() {
        System.out.println(getClass().desiredAssertionStatus());
    }

    /**
     * 当且仅当此类在源代码中声明为枚举时返回true
     */
    @Test
    public void isEnum() {
        assert Status.class.isEnum();
    }

    /**
     * 返回此枚举类的元素，如果此Class对象不表示枚举类型，则返回null。
     */
    @Test
    public void getEnumConstants() {
        System.out.println(Arrays.toString(Status.class.getEnumConstants()));
    }


    /**
     * 将指定对象转换为当前Class表示的类或接口
     */
    @Test
    public void cast() {
        ChinesePeople chinesePeople = new ChinesePeople();
        chinesePeople.setAge(18);
        chinesePeople.setName("jujunchen");
        Person person = Person.class.cast(chinesePeople);
        System.out.println(person.getName());

        //java.lang.ClassCastException: Cannot cast lang.Person to lang.ChinesePeople
//        System.out.println(ChinesePeople.class.cast(new Person()));
    }

    /**
     * 将该类转换成指定类的子类
     */
    @Test
    public void asSubclass() {
        Class<? extends Animal> subclass = Person.class.asSubclass(Animal.class);
        System.out.println(subclass.getName());
    }

    /**
     * 获取注解类,忽略父类注解，获取父类的注解，注解必须有@Inherited
     */
    @Test
    public void getAnnotation() {
        JavaBean javaBean = ChinesePeople.class.getAnnotation(JavaBean.class);
        assert javaBean == null;
        Car car = ChinesePeople.class.getAnnotation(Car.class);
        assert car != null;
    }


    /**
     * 如果此元素上存在指定类型的注解，则返回true，否则返回false。 此方法主要用于方便地访问标记注解。
     */
    @Test
    public void isAnnotationPresent() {
        assert Person.class.isAnnotationPresent(JavaBean.class);
    }


    /**
     * 返回与指定类相关连的注解数组,获取父类的注解，注解必须有@Inherited
     */
    @Test
    public void getAnnotationsByType() {
        Name[] annotations = ChinesePeople.class.getAnnotationsByType(Name.class);
        assert annotations.length == 1;

        Car[] annotations1 = ChinesePeople.class.getAnnotationsByType(Car.class);
        assert annotations1.length == 1;
    }


    /**
     * 返回此类上存在的注解,获取父类的注解，注解必须有@Inherited
     */
    @Test
    public void getAnnotations() {
        Annotation[] allAnnotations = ChinesePeople.class.getAnnotations();
        assert allAnnotations.length == 2;
    }


    /**
     * 获取指定注解类，忽略父类的注解,有@Inherited 也获取不到
     */
    @Test
    public void getDeclaredAnnotation() {
        JavaBean javaBean1 = ChinesePeople.class.getDeclaredAnnotation(JavaBean.class);
        assert javaBean1 == null;

        Car car = ChinesePeople.class.getDeclaredAnnotation(Car.class);
        assert car == null;
    }

    /**
     * 获取指定注解类，返回数组，忽略父类的注解,有@Inherited 也获取不到
     */
    @Test
    public void getDeclaredAnnotationsByType() {
        Name[] names = ChinesePeople.class.getDeclaredAnnotationsByType(Name.class);
        assert names.length == 1;

        Car[] cars = ChinesePeople.class.getDeclaredAnnotationsByType(Car.class);
        assert cars.length == 0;
    }


    /**
     * 获取该类上的所有注解，忽略父类的注解
     */
    @Test
    public void getDeclaredAnnotations() {
        Annotation[] javaBeans = ChinesePeople.class.getDeclaredAnnotations();
        assert javaBeans.length == 1;
    }


    /**
     * 返回一个AnnotatedType对象，获取该Class对象的超类
     * 如果此类表示Object类，接口类型，数组类型，基元类型或void，则返回值为null 。
     */
    @Test
    public void getAnnotatedSuperclass() {
        AnnotatedType annotatedType = ChinesePeople.class.getAnnotatedSuperclass();
        System.out.println(annotatedType.getType());

        AnnotatedType annotatedType1 = Person.class.getAnnotatedSuperclass();
        System.out.println(annotatedType1.getType());
    }

    /**
     * 获取该类的接口,返回AnnotatedType类型数组
     * <p>
     * 如果此类对象表示类，则返回值是一个数组，其中包含表示接口类型用于指定类实现的接口的对象。 数组中对象的顺序对应于此类对象的声明的“implements”子句中使用的接口类型的顺序。
     * <p>
     * 如果此类对象表示接口，则返回值是一个数组，其中包含表示接口类型用途的对象，以指定由接口直接扩展的接口。 数组中对象的顺序对应于此类对象的声明的“extends”子句中使用的接口类型的顺序。
     * <p>
     * 如果此类对象表示其声明未明确指示任何带注释的超接口的类或接口，则返回值为长度为0的数组。
     * <p>
     * 如果此类对象表示Object类，数组类型，基本类型或void，则返回值是长度为0的数组。
     */
    @Test
    public void getAnnotatedInterfaces() {
        AnnotatedType[] annotatedTypes = ChinesePeople.class.getAnnotatedInterfaces();
        assert annotatedTypes.length == 0;

        AnnotatedType[] annotatedTypes1 = Person.class.getAnnotatedInterfaces();
        assert annotatedTypes1.length == 1;
    }


    /**
     * 嵌套主机,内部类所在父类，如果不是内部类返回本身
     */
    @Test
    public void getNestHost() {
        Class<?> chinesePeopleClass = ChinesePeople.ZjPeople.class.getNestHost();
        System.out.println(chinesePeopleClass.getName());
    }


    /**
     * 确定指定的类和该类是否是同一个嵌套的成员
     */
    @Test
    public void isNestmateOf() {
        assert ChinesePeople.class.isNestmateOf(ChinesePeople.ZjPeople.class);
    }


    /**
     * 返回一个数组，内部类，包括本身。
     */
    @Test
    public void getNestMembers() {
        Class<?>[] chinesePeoples = ChinesePeople.class.getNestMembers();
        System.out.println(Arrays.toString(chinesePeoples));
    }


}
