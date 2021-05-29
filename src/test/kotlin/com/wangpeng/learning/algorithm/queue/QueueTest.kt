package com.wangpeng.learning.algorithm.queue

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class QueueTest {
	
	@Test
	fun test() {
		val queue1 = TestQueue(1,"Joshua")
		val queue2 = TestQueue(2,"Moses")
		val myQueue = MyQueue<TestQueue>()
		myQueue.enQueue(queue1)
		myQueue.enQueue(queue2)
		while (!myQueue.isEmpty()){
			val tmp = myQueue.deQueue()
			println("$tmp")
		}
	}
	
	data class TestQueue(
		val id: Int,
		val name: String
	)
	
	class MyQueue<T> {
		private val data = mutableListOf<T>()
		private var front = 0 // 头
		private var rear = 0 // 尾
		
		fun isEmpty(): Boolean = front == rear
		fun size(): Int = rear - front
		fun enQueue(t: T) {
			data.add(t)
			rear ++
		}
		
		fun deQueue(): T? {
			return if (isEmpty()) {
				return null
			} else {
				data[front ++]
			}
		}
		
		fun back(): T? {
			return if (isEmpty()) {
				null
			} else {
				data[rear - 1]
			}
		}
		
		fun front(): T? {
			return if (isEmpty()) null else data[front]
		}
	}
}