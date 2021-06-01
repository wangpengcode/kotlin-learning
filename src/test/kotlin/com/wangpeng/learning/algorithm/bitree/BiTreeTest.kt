package com.wangpeng.learning.algorithm.bitree

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class BiTreeTest {
	/**
	 * 判断两个二叉树是否相同
	 */
	@Test
	fun isEqualBiTree() {
		val biTree1 = mockBiTree(intArrayOf(1, 2, 3, 4, 5, 8, 9, 10))
		val biTree2 = mockBiTree(intArrayOf(1, 2, 3, 4, 5, 8, 9, 10))
		println("biTree1 is equal biTree2 " + isEqual(biTree1, biTree2))
		val biTree3 = mockBiTree(intArrayOf(1, 2, 3, 4, 5, 8, 9, 10, 18))
		println("biTree1 is equal biTree3 " + isEqual(biTree1, biTree3))
	}
	
	private fun isEqual(standard: BiTree?, compare: BiTree?): Boolean {
		if (standard == null && compare == null) return true
		if (standard != null && compare == null) return false
		if (standard == null && compare != null) return false
		return if (standard?.data == compare?.data) {
			isEqual(standard?.leftChild, compare?.leftChild)
					&& isEqual(standard?.rightChild, compare?.rightChild)
		} else false
	}
	
	private fun mockBiTree(array: IntArray): BiTree? {
		return toBiTree(array, 0, array.size - 1)
	}
	
	
	@Test
	fun changeArrayToBiTree() {
		val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		val biTree = toBiTree(arr, 0, arr.size - 1)
		printBiTree(biTree)
	}
	
	/**
	 * 将数组转化为二叉树
	 */
	private fun toBiTree(array: IntArray, start: Int, end: Int): BiTree? {
		val root: BiTree?
		if (end > start) {
			root = BiTree()
			val mid = (start + end + 1) / 2
			root.data = array[mid]
			root.leftChild = toBiTree(array, start, mid - 1)
			root.rightChild = toBiTree(array, mid + 1, end)
		} else {
			root = null
		}
		return root
	}
	
	/**
	 * 中序遍历法打印树的结点
	 * **/
	private fun printBiTree(root: BiTree?) {
		if (root == null) return
		if (root.leftChild != null) printBiTree(root.leftChild)
		println("${root.data}")
		if (root.rightChild != null) printBiTree(root.rightChild)
	}
	
	class BiTree {
		var data = 0
		var leftChild: BiTree? = null
		var rightChild: BiTree? = null
	}
}