package com.wangpeng.learning.algorithm.arr

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class TopKTest {
	
	private val maxSize = 9
	private var currentSize = 1
	
	/**
	 * 找出数组中最大的3个数
	 * **/
	@Test
	fun topK() {
		val arr = intArrayOf(1, 8, 999, 8, 20, 8909, 7, 22, 360)
		println("Before sort")
		arr.forEach { print("$it,") }
		println()
		for (element in arr) {
			heapInsert(arr, element)
		}
		arr.forEach { print("$it,") }
		
	}
	
	private fun heapInsert(arr: IntArray, value: Int) {
		if (currentSize < maxSize) {
			arr[currentSize ++] = value
			if (currentSize == maxSize) {
				var lag: Int = currentSize / 2
				while (lag > 0) {
					heapAdjust(arr, lag, currentSize)
					lag --
				}
			}
		} else {
			val max = arr[1]
			if (value < max) {
				arr[1] = value
				heapAdjust(arr, 1, currentSize)
			}
		}
	}
	
	private fun heapAdjust(arr: IntArray, s: Int, len: Int) {
		var temp = arr[s]
		var lag: Int = 2* s
		var position = s
		for (i in lag until len) {
			if (lag < len - 1 && arr[lag] < arr[lag + 1])
				lag ++
			if (arr[lag] < temp)
				break
			arr[position] = arr[lag]
			position = i
			lag *= 2
		}
		arr[position] = temp
	}
	
}