package com.wangpeng.learning.algorithm

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class DependencyLoop {
	
	@Test
	fun test() {
		val pair1 = Pair(1, 2)
		val pair2 = Pair(0, 2)
		val pair3 = Pair(2, 3)
		val pair4 = Pair(2, 4)
		val pair5 = Pair(4, 1)
		val rawData = ArrayList<Pair<Int, Int>>()
		rawData.add(pair1)
		rawData.add(pair2)
		rawData.add(pair3)
		rawData.add(pair4)
		rawData.add(pair5)
		val result = findNoDepend(rawData)
		println(result.size)
	}
	
	fun findNoDepend(rawData: ArrayList<Pair<Int, Int>>): ArrayList<Pair<Int, Int>> {
		var leftKeys = rawData.map { it.first }.toList()
		val rightKeys = rawData.map { it.second }.toList()
		val removeKey = leftKeys.filter { it -> (!rightKeys.contains(it)) }.toList().firstOrNull()
		if (removeKey != null) {
			val iterator = rawData.iterator()
			while (iterator.hasNext()) {
				val pair = iterator.next()
				if (pair.first == removeKey) {
					iterator.remove()
					findNoDepend(rawData)
				}
			}
		}
		return rawData
	}
}