package leetCode.Test

open class Country {
    var nameCountry: String? = null
}

open class Province: Country() {
    var nameProvince: String? = null
}

class City: Province() {
    var nameCity: String? = null
}

class FruitOut<out City>(private var fruit: City) {
    fun getFruit(): City = fruit
}

class FruitIn<in Country>(private var fruit: Country) {
    fun setFruit(fruit: Country) {
        this.fruit = fruit
    }
}

