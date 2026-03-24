package javaLearn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Star createProxy(BigStar bigStar) {
        System.out.println("proxy,classLoader = " + ProxyUtil.class.getClassLoader());
        System.out.println("String,classLoader = " + String.class.getClassLoader());
        System.out.println("BigStar,classLoader = " + BigStar.class.getClassLoader());
        /*
        public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
             loader: 用于指定一个类加载器，一般是用当前的类加载器
             interfaces: 指定生产的代理长什么样子，也就是有哪些方法
             h: 用来生产的代理对象要干什么事情
         */
        return (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                (proxy, method, args) -> {
                    System.out.println("proxy = "  + proxy.getClass().getName() + ", method = " + method.getName());
                    if ("sing".equals(method.getName())) {
                        System.out.println("准备话题，收取20万");
                    } else if ("dance".equals(method.getName())) {
                        System.out.println("准备话题，收取1000万");
                    }
                    return method.invoke(bigStar, args);
                }
        );
    }
}
