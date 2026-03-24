package javaLearn.reflect

class ReflectExercise {
    companion object {
        val START_VERSION = -1

        class StaticClass {
            private val staticValue = 1
        }

        private class StaticPrivateClass {
            private val staticPrivateValue = 100
        }
    }

    private val mObservers: HashMap<String, ObserverWrapper> = HashMap()
    private var mVersion = START_VERSION + 1

    init {
        mObservers["haha"] = ObserverWrapper(100)
    }

    fun set(key: String, version: Int) {
        mObservers[key] = ObserverWrapper(version)
    }

    private class ObserverWrapper {
        var mLastVersion = START_VERSION

        constructor(value: Int) {
            mLastVersion = value
        }

        constructor() {
            mLastVersion = START_VERSION
        }
    }

    interface IClass {
        fun getValue()
    }
}