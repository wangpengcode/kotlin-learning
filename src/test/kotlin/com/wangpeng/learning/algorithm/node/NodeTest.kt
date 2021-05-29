package com.wangpeng.learning.algorithm.node

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class NodeTest {
	data class Node(var data: Int = 0, var next: Node? = null)
	
	@Test
	fun removeDuplicateNode() {
		val head = mockNode()
		println("去除前")
		printNode(head)
		var outerCur = head.next
		var innerCur: Node?
		var innerPre: Node?
		while (outerCur != null) {
			innerCur = outerCur.next
			innerPre = outerCur
			while (innerCur != null) {
				if (outerCur.data == innerCur.data) {
					innerPre?.next = innerCur !!.next
					innerCur = innerCur.next
				} else {
					innerPre = innerCur
					innerCur = innerCur.next
				}
			}
			
			outerCur = outerCur.next
		}
		println("移除后")
		printNode(head)
	}
	
	
	@Test
	fun testReverse() {
		val head = mockNode()
		println("逆序前")
		printNode(head)
		var cur: Node? // 当前节点
		var next: Node? // 下一个节点
		
		cur = head.next?.next // 从第二个节点开始
		head.next?.next = null // 第一个节点指向null 即是尾节点
		
		while (cur != null) {
			// 下一个节点为当前节点的下一个节点
			next = cur.next
			// 交换
			// 当前节点指向头节点的下一个节点
			cur.next = head.next
			// 头节点指向当前节点
			head.next = cur
			// 程序游标右移动
			cur = next
		}
		
		println("逆序后")
		printNode(head)
	}
	
	private fun printNode(head: Node) {
		var printCur = head.next
		while (printCur != null) {
			print("${printCur.data},")
			printCur = printCur.next
		}
	}
	
	private fun mockNode(): Node {
		val head = Node()
		head.next = null
		
		var tmp: Node?
		var cur: Node? = head
		var i = 0
		while (i < 9) {
			tmp = Node(i, null)
			if (i == 6) {
				tmp = Node(5, null) // 构造重复的节点
			}
			// 赋值给下一个节点
			cur?.next = tmp
			// 当前节点右移
			cur = tmp
			i ++
		}
		return head
	}
}