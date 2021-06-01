package com.wangpeng.learning.algorithm.bitree

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class BiTreeTest {
	
	@Test
	fun changeArrayToBiTree() {
		val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9,10)
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