package com.wangpeng.learning.algorithm.arr

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigDecimal

@ExtendWith(MockKExtension::class)
class FindNum {
	/**
	 * An array with only one num have appear once, another appear twice.
	 * Find the num which appear once.
	 */
	@Test
	fun whichOneAppearOnce() {
		val arr = intArrayOf(1, 2, 3, 2, 1, 8, 9, 9, 8)
		var onceNum = 0
		for (i in arr) {
			onceNum = onceNum xor i
		}
		println(onceNum)
	}
	
	fun whichOneDuplicate() {
	
	}
	
	@Test
	fun testBigDecimal() {
		val str = "2.00000000000099999999999999999999999"
		val b1 = BigDecimal(str)
		println(b1)
		println(b1.stripTrailingZeros())
		println(b1.stripTrailingZeros().toPlainString())
	}
}