package com.wangpeng.learning.algorithm.str

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class StringTest {
	@Test
	fun hash() {
		val s = "wangpeng"
		println(s.hashCode())
		println()
		val s1 = "z"
		println(s1.hashCode())
		println()
		val a = "a"
		println(a.hashCode())
		println()
	}
}