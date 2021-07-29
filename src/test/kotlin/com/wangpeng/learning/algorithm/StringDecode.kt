package com.wangpeng.learning.algorithm

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class StringDecode {
	/**
	 * 394. 字符串解码
	给定一个经过编码的字符串，返回它解码后的字符串。
	编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
	你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
	此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
	
	示例 1：
	输入：s = "3[a]2[bc]"
	输出："aaabcbc"
	示例 2：
	
	输入：s = "3[a2[c]]"
	输出："accaccacc"
	示例 3：
	
	输入：s = "2[abc]3[cd]ef"
	输出："abcabccdcdcdef"
	示例 4：
	
	输入：s = "abc3[cd]xyz"
	输出："abccdcdcdxyz"
	
	解题思路
	定义两个栈和两个变量，其中
	
	stack1存放字符串
	stack2存放表示重复次数的数字
	str表示当前正在处理的字符串
	times表示当前正在处理的重复次数，也是一个字符串类型
	依次读取输入字符串中的字符，按下述四种情况处理：
	
	如果是普通字符，添加到str后面
	如果是数字，有两种情况，如果前面一个字符是数字，直接把当前数字接在times后面，否则，将str入栈并重新初始化
	如果是左括号，前面一定是数字，也就是已经处理完成的times，此时要将times转成数字入栈
	如果是右括号，stack1和stack2同时出栈，得到上次入栈的字符串和重复次数，该字符串后面接上str的重复，重新赋值给str
	所有字符读取完成后得到的str即为答案
	 */
	@Test
	fun test() {
		val rawData = "abc3[cd]xyz"
		
		val strStack = mutableListOf<String>()
		val timesStack = mutableListOf<Int>()
		var str = ""
		var times= ""
		
		for (char in rawData) {
			when (char) {
				in '0'..'9' -> {
					if (times.isEmpty()) {
						strStack.add(str)
						str = ""
						times = char.toString()
					} else {
						times += char
					}
				}
				'[' -> {
					timesStack.add(times.toInt())
					times = ""
				}
				']' -> {
					val time = timesStack.removeAt(timesStack.lastIndex)
					val s = strStack.removeAt(strStack.lastIndex)
					str = s + str.repeat(time)
				}
				else -> {
					str += char
				}
			}
		}
		
		println(str)
	}
	
}