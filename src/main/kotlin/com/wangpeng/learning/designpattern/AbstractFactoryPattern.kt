package com.wangpeng.learning.designpattern

interface AbstractPizzaFactory {
	fun makePizza(flavor: Flavor): Pizza
}

class ShangHaiPizzaFactory : AbstractPizzaFactory {
	
	override fun makePizza(flavor: Flavor): Pizza {
		return Pizza(flavor).apply { location = Location.SHANG_HAI }
	}
}

class BeiJingPizzaFactory : AbstractPizzaFactory {
	
	override fun makePizza(flavor: Flavor): Pizza {
		return Pizza(flavor).apply { location = Location.BEI_JING }
	}
}

class OrderCenter {
	fun order(location: Location, flavor: Flavor): Pizza {
		return when(location) {
			Location.SHANG_HAI -> ShangHaiPizzaFactory().makePizza(flavor)
			else -> BeiJingPizzaFactory().makePizza(flavor)
		}
	}
}

enum class Flavor {
	CHEESE,
	PEPPER
}


data class Pizza(
	val flavor: Flavor
) {
	lateinit var location: Location
	
	override fun toString(): String {
		return "Pizza(flavor=$flavor, location=$location)"
	}
}

enum class Location {
	SHANG_HAI,
	BEI_JING
}