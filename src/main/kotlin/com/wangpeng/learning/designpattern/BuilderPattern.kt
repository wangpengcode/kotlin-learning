package com.wangpeng.learning.designpattern

class BuilderPatternPeople(
	private val name: String,
	private val id: String,
	private val age: Int?,
	private val work: String?
) {
	private constructor(builder: Builder) : this(builder.name, builder.id, builder.age, builder.work)
	
	class Builder {
		var name = ""
		var id = ""
		var age = - 1
		var work: String? = null
		
		fun builder() = BuilderPatternPeople(this)
	}
	
	companion object {
		inline fun build(block: Builder.() -> Unit) = Builder().apply(block).builder()
	}
	
	override fun toString(): String {
		return "BuilderPatternPeople(name='$name', id='$id', age=$age, work=$work)"
	}
}