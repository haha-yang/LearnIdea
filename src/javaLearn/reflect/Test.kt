package javaLearn.reflect

import java.lang.reflect.Field
import java.lang.reflect.Method


class Test {
    fun test() {
        val simpleTest = ReflectExercise()
        simpleTest.set("hehe", -100)

        val reflectExerciseClass = ReflectExercise::class.java
        val mObserversClass = reflectExerciseClass.getDeclaredField("mObservers")
        mObserversClass.isAccessible = true
        val value = mObserversClass.get(simpleTest)

        val mVersionClass = reflectExerciseClass.getDeclaredField("mVersion")
        mVersionClass.isAccessible = true
        val mVersionValue = mVersionClass.get(simpleTest)
        println("mVersionValue = $mVersionValue")

        if (value is HashMap<*, *>) {
            val observerWrapper = value["haha"] ?: return
            val superClass = observerWrapper::class.java
            val mLastVersion = superClass.getDeclaredField("mLastVersion")
            mLastVersion.isAccessible = true
            val mLastVersionValue = mLastVersion.get(observerWrapper)
            println("mLastVersionValue = $mLastVersionValue")

            mLastVersion.set(observerWrapper, mVersionValue)
            val temp = mLastVersion.get(observerWrapper)
            println("mLastVersionValue = $temp")
        } else {
            println("no")
        }
    }

    fun testExercise() {
        println("-------------------------------------------")
        val clazz: Class<*> = Class.forName("javaLearn.reflect.ReflectExercise");
        println("clazz = $clazz")
        val staticField: Field = clazz.getDeclaredField("START_VERSION")
        println("staticField = $staticField")
        staticField.isAccessible = true
        val staticValue: Int = staticField.get(null) as Int
        println("staticValue = $staticValue")

        val mObserversField: Field = clazz.getDeclaredField("mObservers")
        println("mObserversField = $mObserversField")
        mObserversField.isAccessible = true
        val instance = clazz.getDeclaredConstructor().newInstance()
        println("instance = $instance")
        val mObservers: HashMap<*, *> = mObserversField.get(instance) as HashMap<*, *>
        val mSetMethod: Method = clazz.getMethod("set", String::class.java, Int::class.java)
        println("mSetMethod = $mSetMethod")
        mSetMethod.invoke(instance, "nihao", 100)

        var observerWrapperClazz: Class<*>? = null
        var staticClazz: Class<*>? = null
        var staticPrivateClazz: Class<*>? = null
        for (declaredClass in clazz.declaredClasses) {
            println("declaredClass = $declaredClass")
            if ("javaLearn.reflect.ReflectExercise\$ObserverWrapper" == declaredClass.name) {
                observerWrapperClazz = declaredClass
                println("find ${declaredClass.name}")
            } else if ("javaLearn.reflect.ReflectExercise\$Companion" == declaredClass.name) {
                println("find ${declaredClass.name}")
                declaredClass.declaredClasses.forEach {
                    if ("javaLearn.reflect.ReflectExercise\$Companion\$StaticPrivateClass" == it.name) {
                        println("find ${it.name}")
                        staticPrivateClazz = it
                    } else if ("javaLearn.reflect.ReflectExercise\$Companion\$StaticClass" == it.name) {
                        println("find ${it.name}")
                        staticClazz = it
                    }
                }
            }
        }

        staticClazz?.let {
            val staticInstance = it.getDeclaredConstructor().newInstance()
            val staticField = it.getDeclaredField("staticValue")
            staticField.isAccessible = true
            val staticValue = staticField.get(staticInstance)
            println("staticValue = $staticValue")
        }

        staticPrivateClazz?.let {
            val privateInstance = it.getDeclaredConstructor().newInstance()
            val staticPrivateField = it.getDeclaredField("staticPrivateValue")
            staticPrivateField.isAccessible = true
            val staticPrivateValue = staticPrivateField.get(privateInstance)
            println("staticPrivateValue = $staticPrivateValue")
        }

        mObservers.forEach { (key, observerWrapper) ->
            if (key is String && key == "nihao") {
                println("String = $key, ObserverWrapper = $observerWrapper")
                // private 内部类里面的public 成员对象，也需要通过getDeclaredField来获取
                val mLastVersionField = observerWrapperClazz?.getDeclaredField("mLastVersion")
                mLastVersionField?.isAccessible = true
                val lastVersion = mLastVersionField?.get(observerWrapper)
                println("ObserverWrapper.mLastVersion = $lastVersion")
            }
        }
        println("-------------------------------------------")
    }
}