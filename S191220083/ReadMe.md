# ReadMe

## 分析代码

本次代码的重点是类是如何从隐写术图中加载出来的.

*为什么一开始解码的代码出错但正常运行，在删除BubbleSorter.java文件之后才报错？*	

因为类的加载是向上委托向下查找,SteganographyClassLoader的parent是ClassLoader,在初始化的时候由super()构造实例super()的功能就是直接构造调用它的类的父类的实体。一开始BubbleSorter.java没有被删除的时候，SteganographyClassLoader委托给ClassLoader查找BubbleSorter，因为文件中存在该类，所以不需要读取图片中的代码也能找到BubbleSorter的类。只有在删除文件之后才会调用SteganographyClassLoader来解码图片中的BubblerSorter的字节码，此时出错，解码失败，所以报错。

在SteganographyClassLoader中，以图片的url作为必要的参数，在findClass中进行解码。findClass中调用解码函数得到图片中的字节码，然后用defineClass将字节码构造成类，因为返回值是Class<?>，所以只要是类（用户自定义的类可以被认为是Class泛型的加入参数后构造的类），无论具体是什么类型都可以被兼容并且返回。

Scene调用了上述过程，因此在之前代码的基础上只是将类加载的过程自定义成了从图片中得到Sorter。



## 给自己的代码制作隐写术图

### HeapSorter

![example.HeapSorter](/home/njucs/Java/jw03-August0830/example.HeapSorter.png)

[![asciicast](https://asciinema.org/a/439483.svg)](https://asciinema.org/a/439483)

### QuickSorter

![](/home/njucs/Java/jw03-August0830/example.QuickSorter.png)

[![asciicast](https://asciinema.org/a/439488.svg)](https://asciinema.org/a/439488)



## 交换隐写术图

待定