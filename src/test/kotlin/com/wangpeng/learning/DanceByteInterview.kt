package com.wangpeng.learning

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class DanceByteInterview {
	
	/**
	 * NC76 用两个栈实现队列
	 *
	 * 描述
	用两个栈来实现一个队列，分别完成在队列尾部插入整数(push)和在队列头部删除整数(pop)的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
	
	示例:
	输入:
	["PSH1","PSH2","POP","POP"]
	返回:
	1,2
	解析:
	"PSH1":代表将1插入队列尾部
	"PSH2":代表将2插入队列尾部
	"POP“:代表删除一个元素，先进先出=>返回1
	"POP“:代表删除一个元素，先进先出=>返回2
	示例1
	输入：
	["PSH1","PSH2","POP","POP"]
	复制
	返回值：
	1,2
	 
	 */
	@Test
	fun queue() {
		val stack1 = Stack<Int>()
		val stack2 = Stack<Int>()
		
		fun push(i: Int) {
			stack1.push(i)
		}
		
		fun pop(): Int {
			if (stack2.isEmpty()) {
				while (stack1.isNotEmpty()) {
					stack2.push(stack1.pop())
				}
			}
			return stack2.pop()
		}
		
		push(1)
		push(2)
		println("first: "+pop())
		println("second: "+pop())
	}
	
	/**
	 * 描述
	设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
	set(key, value)：将记录(key, value)插入该结构
	get(key)：返回key对应的value值
	[要求]
	set和get方法的时间复杂度为O(1)
	某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
	当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
	若opt=1，接下来两个整数x, y，表示set(x, y)
	若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
	对于每个操作2，输出一个答案
	示例1
	输入：
	[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
	复制
	返回值：
	[1,-1]
	复制
	说明：
	第一次操作后：最常使用的记录为("1", 1)
	第二次操作后：最常使用的记录为("2", 2)，("1", 1)变为最不常用的
	第三次操作后：最常使用的记录为("3", 2)，("1", 1)还是最不常用的
	第四次操作后：最常用的记录为("1", 1)，("2", 2)变为最不常用的
	第五次操作后：大小超过了3，所以移除此时最不常使用的记录("2", 2)，加入记录("4", 4)，并且为最常使用的记录，然后("3", 2)变为最不常使用的记录
	备注：
	1 \leq K \leq N \leq 10^51≤K≤N≤10
	5
	
	-2 \times 10^9 \leq x,y \leq 2 \times 10^9−2×10
	9
	≤x,y≤2×10
	9
	 */
	@Test
	fun LRU(operators: Array<IntArray>, k: Int): IntArray {
		// write code here
		val list = mutableListOf<Int>()
		val map = mutableMapOf<Integer, IntArray>()
		var priority = 0
		var oper = 0
		for (o in operators) {
			oper = o[0]
			// 写入
			if (oper == 1) {
				var min = Integer.MAX_VALUE
				var key = Integer(0)
				
				// 移除
				if (map.size == k) {
					for (e in map.entries) {
						if (e.value[1] < min) {
							min = e.value[1]
							key = e.key
						}
					}
					// 获得最小值后移除
					map.remove(key)
				}
				map[Integer(o[1])] = intArrayOf(o[2], priority ++)
			} else { // 读取
				if (map.keys.contains(o[1])) {
					val value = map[Integer(o[1])]
					list.add(value !![0])
					value[1] = priority ++
				} else {
					list.add(- 1)
				}
			}
		}
		val arr = IntArray(list.size)
		var j = 0
		for (i in list) {
			arr[j] = list[j]
			j ++
		}
		return arr
	}
}