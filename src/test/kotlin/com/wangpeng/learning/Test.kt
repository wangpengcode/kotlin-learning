package com.wangpeng.learning

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigInteger
import kotlin.math.absoluteValue

@ExtendWith(MockKExtension::class)
class Test {
	
	@Test
	fun test() {
		var height: IntArray = intArrayOf(- 1, 0, 1, 2, - 1, - 4)
		var new = threeSum(height)
		new.forEach {
			println(
				it.forEach { it2 ->
					println(it2)
				}
			)
		}
	}
	
	fun threeSum(nums: IntArray): List<List<Int>> {
		val result = mutableListOf<List<Int>>()
		if (nums.size < 3) return result
		nums.sort()
		var j: Int
		var k: Int
		
		for (i in 0 until nums.size - 2) {
			if (nums[i] > 0) break
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue
			}
			j = i + 1
			k = nums.size - 1
			
			while (j < k) {
				val sum = nums[i] + nums[j] + nums[k]
				when {
					sum > 0 -> {
						k --
					}
					sum == 0 -> {
						val a = listOf(nums[i], nums[j], nums[k])
						result.add(a)
						while (j < k && nums[j] == nums[++ j]) {
							continue
						}
						while (j < k && nums[k] == nums[-- k]) {
							continue
						}
					}
					else -> {
						j ++
					}
				}
			}
		}
		
		return result
	}
	
	fun threeSumClosest(nums: IntArray, target: Int): Int {
		var result = Int.MAX_VALUE
		if (nums.size < 3) return - 1
		nums.sort()
		var j: Int
		var k: Int
		var sum: Int
		var diff: Int
		for (i in 0 until nums.size - 2) {
			j = i + 1
			k = nums.size - 1
			while (j < k) {
				sum = nums[i] + nums[j] + nums[k]
				diff = (sum - target).absoluteValue
				if (diff < result) {
					result = sum - target
				}
				k --
				j ++
				
				
			}
		}
		return result
	}
	
	@Test
	fun four() {
		val result = fourSum(intArrayOf(- 2, - 1, 0, 0, 1, 2), 0)
		result.forEach { it ->
			{
				it.forEach { it2 ->
					{
						print("${it2},")
					}
				}
			}
		}
	}
	
	fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
		if (nums.size < 4) return listOf()
		var list = mutableListOf<List<Int>>()
		var left: Int
		var right: Int
		var temp: Int
		nums.sort()
		for (i in 0 until nums.size - 2) {
			left = i + 1
			right = nums.size - 1
			while (left < right) {
				temp = target - nums[i] - nums[left] - nums[right]
				if (temp >= nums[right]) {
					right --
					continue
				}
				if (temp <= nums[left]) {
					left ++
					continue
				}
				var tempIndex = left + 1
				while (tempIndex < right) {
					if (temp == nums[tempIndex]) {
						list.add(listOf(nums[i], nums[left], nums[tempIndex], nums[right]))
						break
					}
					tempIndex ++
				}
				left ++
			} // [-2,-1,0,0,1,2]
		} // 解答失败: 测试用例:[1,0,-1,0,-2,2] 0 测试结果:[[-2,-1,1,2],[-2,0,0,2]] 期望结果:[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] stdout:
		return list
	}
	
	@Test
	fun testsss() {
		letterCombinations("23")
	}
	
	fun letterCombinations(digits: String): List<String> {
		val map = java.util.HashMap<String, String>()
		map["2"] = "abc"
		map["3"] = "def"
		map["4"] = "ghi"
		map["5"] = "jkl"
		map["6"] = "mno"
		map["7"] = "pqrs"
		map["8"] = "tuv"
		map["9"] = "wxyz"
		println(digits)
		var str = ""
		for (i in digits.toCharArray()) {
			println(i.toString())
			str += map[i.toString()]
		}
		println(str)
		val array = str.toCharArray()
		var list = mutableListOf<String>()
		list = find(array,list, StringBuffer(),0)
		list.forEach{
			print(it+",")
		}
		return list
	}
	
	/**
	 * string 的所有字符串组合
	 */
	fun find(array: CharArray, list: MutableList<String>, buffer: java.lang.StringBuffer, start: Int): MutableList<String> {
		var i = start
		while (i < array.size) {
			buffer.append(array[i])
			if (i < array.size - 1) {
				find(array,list,buffer,i+1)
			}
			list.add(buffer.toString())
			buffer.setLength(buffer.length - 1 )
			i ++
		}
		return list
	}
}