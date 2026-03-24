package javaLearn.reflect

class ReflectTest {
    fun testClass() {
        // Class.forName("类的全路径")
        val class1 = Class.forName("javaLearn.reflect.Student")
        // 类名.class
        val class2 = Student::class.java

        val student = Student("haha", "10001", 19)
        // 对象名.getClass()
        val class3 = student.javaClass

        // 包装类.TYPE
        val class4 = Integer.TYPE

        // Class类.getSuperClass()
        val class5 = class4.superclass
    }

    fun testFields() {
        try {
            val student = Student("haha", "10001", 19)
            // 对象名.getClass()
            val studentClass = student.javaClass
            val studentFields = studentClass.fields
            println("通过getFields获取Student类所有公开属性")
            for (field in studentFields) {
                println("属性的类型：${field.type}, 属性的名称：${field.name}, 属性的值：${field.get(student)}")
            }

            val studentDeclaredFields = studentClass.declaredFields
            println("\n通过getDeclaredFields获取Student类所有属性（包括私有，不包括继承）")
            for (field in studentDeclaredFields) {
                field.isAccessible = true
                println("属性的类型：${field.type}, 属性的名称：${field.name}, 属性的值：${field.get(student)}")
            }

            val companionField = studentClass.getField("Companion")
            companionField.isAccessible = true
            println("\n通过getField(\"Companion\")获取公开属性Companion")
            println("属性的类型：${companionField.type}, 属性的名称：${companionField.name}, 属性的值：${companionField.get(student)}")
            println("studend = ${student.printInfo()}")

            val idField = studentClass.getDeclaredField("id")
            idField.isAccessible = true
            val nameField = studentClass.getDeclaredField("name")
            nameField.isAccessible = true
            val numberField = studentClass.getDeclaredField("number")
            numberField.isAccessible = true
            val ageField = studentClass.getDeclaredField("age")
            ageField.isAccessible = true
            ageField.set(student, ageField.get(student) as Int + 1)
            println("\n通过getDeclaredField(\"id\")获取公开属性id")
            println("属性的类型：${idField.type}, 属性的名称：${idField.name}, 属性的值：${idField.get(student)}, 修改属性的值：${idField.set(student, "100_${nameField.get(student)}_${numberField.get(student)}_${ageField.get(student)}")}")
            println("studend = ${student.printInfo()}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}