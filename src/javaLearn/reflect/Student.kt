package javaLearn.reflect

class Student() {
    companion object {
        var count = 0
            private set
    }
    private var name: String = ""

    var number: String = ""

    var age: Int = -1

    private var id: String? = null

    constructor(name: String):this (name, "", -1)

    constructor(name: String, number: String, age: Int) : this() {
        this.name = name
        this.number = number
        this.age = age
        id = "${count ++}_${name}_$number"
    }

    constructor(name: String, number: String): this (name, number, -1)

    fun getId(): String? = id

    fun printInfo(): String {
        return "id = ${id}, name = ${name}, number = ${number}, age = ${age}"
    }

    fun printInfo(extra: String): String {
        return "id = ${id}, name = ${name}, number = ${number}, age = ${age}, extra = ${extra}"
    }
}