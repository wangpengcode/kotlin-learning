package com.wangpeng.learning.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

class PaymentJDKProxy : InvocationHandler {
	lateinit var paymentApi: PaymentApi
	
	fun newProxy(paymentApi: PaymentApi): PaymentApi {
		this.paymentApi = paymentApi
		return Proxy.newProxyInstance(
			paymentApi.javaClass.classLoader,
			paymentApi.javaClass.interfaces,
			this
		) as PaymentApi
	}
	
	override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
		println("Before invoke")
		val any: Any? = (method?.invoke(paymentApi, *args.orEmpty())) // kotlin的可变参数传入java需要进行星型展开（*），如果展开为空则返回空，合起来就是（*args.orEmpty）
		println("After invoke")
		return any
	}
}