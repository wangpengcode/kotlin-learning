package com.wangpeng.learning.designpattern

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class AbstractFactoryTest {
	@Test
	fun test(){
		println("I am traveling at shanghai")
		val pizza = OrderCenter().order(location = Location.SHANG_HAI, flavor = Flavor.CHEESE)
		println("I get a pizza with: $pizza")
	}
}