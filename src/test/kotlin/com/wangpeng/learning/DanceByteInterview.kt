package com.wangpeng.learning

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class DanceByteInterview {
	
	@Test
	fun test() {
	
	}
	
	@Test
	fun LRU(operators: Array<IntArray>,k: Int): IntArray  {
		// write code here
		val list = mutableListOf<Int>()
		val map = mutableMapOf<Integer,IntArray>()
		var priority = 0
		var oper = 0
		for(o in operators) {
			oper = o[0]
			// 写入
			if(oper == 1) {
				var min = Integer.MAX_VALUE
				var key = Integer(0)
				
				// 移除
				if(map.size == k) {
					for(e in map.entries) {
						if(e.value[1] < min) {
							min = e.value[1]
							key = e.key
						}
					}
					// 获得最小值后移除
					map.remove(key)
				}
				map[Integer(o[1])] = intArrayOf(o[2],priority++)
			} else { // 读取
				if(map.keys.contains(o[1])) {
					val value = map[Integer(o[1])]
					list.add(value!![0])
					value[1] = priority ++
				} else {
					list.add(-1)
				}
			}
		}
		val arr = IntArray(list.size)
		var j = 0
		for(i in list) {
			arr[j] = list[j]
			j ++
		}
		return arr
	}
}