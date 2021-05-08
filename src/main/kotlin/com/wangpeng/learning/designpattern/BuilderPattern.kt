package com.wangpeng.learning.designpattern

import java.math.BigDecimal
import kotlin.random.Random

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

abstract class ApplyCardBuilder {
	protected var creditCard: CreditCard = CreditCard()
	abstract fun kyc()
	abstract fun applyToCentralBank()
	abstract fun makeCard()
	abstract fun deliver()
	abstract fun builder(): CreditCard
}

class AliBaBaCreditCardBuilder : ApplyCardBuilder() {
	override fun kyc() {
		this.creditCard.apply { kycPass = true }
	}
	
	override fun applyToCentralBank() {
		this.creditCard.apply { applyToCentralBank = true }
	}
	
	override fun makeCard() {
		this.creditCard.apply {
			id = Random(10000).nextInt().toString()
			holder = "holder"
			balance = BigDecimal.ONE
			issuer = "Alibaba"
		}
	}
	
	override fun deliver() {
		this.creditCard.apply { deliverd = true }
	}
	
	override fun builder(): CreditCard {
		this.kyc()
		this.applyToCentralBank()
		this.makeCard()
		this.deliver()
		return this.creditCard
	}
}

class Issuer(
	val builder: ApplyCardBuilder
) {
	fun deliverCard(): CreditCard {
		return builder.builder()
	}
}

class CreditCard {
	var id: String = ""
	var balance: BigDecimal = BigDecimal.ZERO
	var holder: String = ""
	var issuer: String = ""
	var kycPass: Boolean = false
	var applyToCentralBank: Boolean = false
	var deliverd: Boolean = false
	override fun toString(): String {
		return "CreditCard(id='$id', balance=$balance, holder='$holder', issuer='$issuer', kycPass=$kycPass, applyToCentralBank=$applyToCentralBank, deliverd=$deliverd)"
	}
	
}