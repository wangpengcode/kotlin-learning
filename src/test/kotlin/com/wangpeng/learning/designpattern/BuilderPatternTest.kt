package com.wangpeng.learning.designpattern

import org.junit.jupiter.api.extension.ExtendWith
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test

@ExtendWith(MockKExtension::class)
class BuilderPatternTest {
	
	@Test
	fun testBuilderPatternPeople() {
		val people = BuilderPatternPeople.build {
			name = "wangpeng"
			id = "31000000000"
			age = 18
			work = "coder"
		}
		println(people)
	}
}