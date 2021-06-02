package com.wangpeng.learning.algorithm.sort

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class SelectSortTest {
	
	/**
	 * 选择排序
	 */
	@Test
	fun testSelectSort() {
		val arr = intArrayOf(99,88,66,55,44,33,22,11)
		println("Before select sort: ")
		arr.forEach { print("$it,") }
		println()
		val afterSortArr = selectSort(arr)
		println("After select sort:")
		afterSortArr.forEach { print("$it,") }
		println()
	}
	
	private fun selectSort(arr: IntArray): IntArray {
		val size = arr.size
		var temp: Int
		var flag: Int
		
		for (i in 0 until size) {
			temp = arr[i]
			flag = i
			
			// 找出其后最小值
			for (j in i + 1 until size) {
				if (temp > arr[j]) {
					flag = j
					temp = arr[j]
				}
			}
			// 将最小值与arr[i]交换
			if (flag != i) {
				arr[flag] = arr[i]
				arr[i] = temp
			}
		}
		return arr
	}
}