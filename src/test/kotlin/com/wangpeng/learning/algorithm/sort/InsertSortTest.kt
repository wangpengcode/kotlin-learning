package com.wangpeng.learning.algorithm.sort

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class InsertSortTest {
	@Test
	fun testInsertSort() {
		val arr = intArrayOf(99, 88, 77, 66, 55, 44, 1, 5)
		println("Before sort")
		arr.forEach { print("$it,") }
		println()
		val afterSort = insertSort(arr)
		println("After sort")
		afterSort.forEach { print("$it,") }
	}
	
	private fun insertSort(arr: IntArray): IntArray {
		var temp: Int
		for (i in 1 until arr.size) {
			temp = arr[i]
			var j = i - 1
			while (j >= 0) {
				if (temp < arr[j]) {
					arr[j + 1] = arr[j]
				} else {
					break
				}
				j --
			}
			arr[j + 1] = temp
		}
		return arr
	}
}