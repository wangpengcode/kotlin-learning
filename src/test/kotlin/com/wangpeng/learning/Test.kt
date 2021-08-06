package com.wangpeng.learning

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.math.absoluteValue
import kotlin.math.max

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
		letterCombinations("23").forEach { print(it + ",") }
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
		var result = mutableListOf<String>()
		var originalRaw = mutableListOf<List<String>>()
		val originalList = digits.toCharArray().map { it.toString() }.toList()
		originalList.forEach {
			map[it]?.let { it2 -> originalRaw.add(listOf(it2)) }
		}
		
		
		return result
	}
	
	/**
	 * string 的所有字符串组合
	 */
	fun find(array: CharArray, list: MutableList<String>, buffer: StringBuffer, start: Int): MutableList<String> {
		var i = start
		while (i < array.size) {
			buffer.append(array[i])
			if (i < array.size - 1) {
				find(array, list, buffer, i + 1)
			}
			list.add(buffer.toString())
			buffer.setLength(buffer.length - 1)
			i ++
		}
		return list
	}
	
	fun addBinary(a: String, b: String): String {
		val buffer = StringBuffer()
		var i = a.length - 1
		var j = b.length - 1
		var needAddOne = 0
		while (i > 0 || j > 0) {
			var sum: Int
			val a1 = if (i >= 0) a[i] - '0' else 0
			val b1 = if (i >= 0) b[i] - '0' else 0
			sum = a1 + b1
			buffer.append(sum % 2)
			needAddOne = sum / 2
			i --
			j --
		}
		
		if (needAddOne == 1) {
			buffer.append(1)
		}
		return buffer.reverse().toString()
	}
	
	fun maxProfit(prices: IntArray): Int {
		var maxProfit = 0
		var minPrice = Int.MAX_VALUE
		for (i in prices) {
			if (i < minPrice) {
				minPrice = i
			} else if (i - minPrice > maxProfit) {
				maxProfit = i - minPrice
			}
		}
		return maxProfit
	}
	
	fun removeDuplicates(nums: IntArray): Int {
		if (nums.isEmpty()) return 0
		var p = 0
		var q = 1
		while (q < nums.size) {
			if (nums[p] != nums[q]) {
				nums[p + 1] = nums[q]
				q ++
			}
			p ++
		}
		return p + 1
	}
	
	@Test
	fun testSearchInsert() {
		val array = intArrayOf(1,3,5,6)
		println(searchInsert(array,2))
//		println(searchInsert(array,9))
//		println(searchInsert(array,0))
//		val array1 = intArrayOf(1,3)
//		println(searchInsert(array1,2)) 解答失败: 测试用例:[1,3,5,6] 2 测试结果:2 期望结果:1 stdout:
	}
	
	fun searchInsert(nums: IntArray, target: Int): Int {
		if (nums[0] >= target) return 0
		if (nums[nums.size - 1] == target) return nums.size - 1
		if (nums[nums.size - 1] < target) return nums.size
		var start = 0
		var end = nums.size - 1
		var mid = 0
		var result = Int.MAX_VALUE
		
		while (start < end) {
			mid = (start + end) / 2
			if (nums[mid] > target) {
				end = mid - 1
			} else if (nums[mid] == target) {
				result = mid
				break
			} else {
				start = mid + 1
			}
		}
		
		println(mid)
		println(start)
		println(end)
		
		if (end == 0) {
			result = mid
		}
		
		if (start > 0) {
			result = mid - 1
		}
		println(result)
		return result
	} // 解答失败: 测试用例:[1,3] 2 测试结果:0 期望结果:1 stdout:
	
	
	class TreeNode(var `val`: Int) {
		var left: TreeNode? = null
		var right: TreeNode? = null
	}
	
	fun inorderTraversal(root: TreeNode?): List<Int> {
		val list = mutableListOf<Int>()
		getVal(root,list)
		return list
	}
	
	fun getVal(root: TreeNode?, list: MutableList<Int>){
		if (root == null) return
		if (root.left != null) getVal(root,list)
		list.add(root.`val`)
		if (root.right != null) getVal(root,list)
	}
	
	@Test
	fun testisUnique() {
		println(isUnique("eabdf"))
	}
	
	fun isUnique(astr: String): Boolean {
		val charArray = astr.toCharArray()
		val array = IntArray(300)
		var result = false
		var temp: Int
		for ( a in charArray) {
			temp = a - 'a'
			println(" temp = $temp")
			if (++ array[temp] > 1) {
				result = true
				break
			}
		}
		return result
	}
	
	fun CheckPermutation(s1: String, s2: String): Boolean {
		if (s1.length != s2.length) return false
		var result = true
		
		val int1 = IntArray(s1.length)
		val int2 = IntArray(s2.length)
		for ((i, a) in s1.toCharArray().withIndex()) {
			int1[i] = a - 'a'
		}
		for ((i, a) in s2.toCharArray().withIndex()) {
			int2[i] = a - 'a'
		}
		int1.sort()
		int2.sort()
		for (i in int1) {
			if (int1[i] != int2[i]) {
				result = false
				break
			}
		}
		
		return result
	}
	
	fun pre(root: TreeNode?,list: MutableList<Int>) {
	
	}
	
}