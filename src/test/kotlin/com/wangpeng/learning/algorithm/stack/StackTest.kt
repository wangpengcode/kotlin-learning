package com.wangpeng.learning.algorithm.stack

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class StackTest {
	
	@Test
	fun test() {
		val stack1 = TestStack(1, "Joshua")
		val stack2 = TestStack(2,"Moses")
		val myStack = MyStack<TestStack>()
		myStack.push(stack1)
		myStack.push(stack2)
		while (!myStack.isEmpty()) {
			val stack = myStack.pop()
			println("$stack")
		}
	}
	
	data class TestStack(
		val id: Int,
		val name: String
	)
	
	class MyStack<T> {
		private val data = mutableListOf<T>()
		private var stackSize = 0
		fun size(): Int = stackSize
		
		fun isEmpty(): Boolean = stackSize == 0
		
		fun pop(): T? {
			return if (!isEmpty()) {
				data[-- stackSize]
			} else null
		}
		
		fun push(t: T) {
			data.add(t)
			stackSize ++
		}
		
		fun top(): T? {
			return if (!isEmpty()) {
				data[stackSize - 1]
			} else null
		}
	}
}