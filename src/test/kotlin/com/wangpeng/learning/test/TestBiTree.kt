package com.wangpeng.learning.test

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class TestBiTree {
	class BiTree {
		var data = 0
		var left: BiTree? = null
		var right: BiTree? = null
	}
	
	/**
	 *
	 */
	
	@Test
	fun testArrayToBiTree() {
		val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
		val biTree = toBiTree(array, 0, array.size - 1)
		printTree(biTree)
	}
	
	fun toBiTree(array: Array<Int>, start: Int, end: Int): BiTree? {
		var root: BiTree?
		if (end > start) {
			val mid = (start + end + 1) / 2
			root = BiTree()
			root.data = array[mid]
			root.left = toBiTree(array, start, mid - 1)
			root.right = toBiTree(array, mid + 1, end)
		} else {
			root = null
		}
		return root
	}
	
	fun printTree(root: BiTree?) {
		if (root == null) return
		if (root.left != null) printTree(root.left)
		println("${root.data}")
		if (root.right != null) printTree(root.right)
	}
}