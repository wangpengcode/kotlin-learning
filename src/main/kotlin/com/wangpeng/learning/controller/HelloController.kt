package com.wangpeng.learning.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
	
	@GetMapping("/hello")
	fun download(): String {
		return "hello"
	}
}

