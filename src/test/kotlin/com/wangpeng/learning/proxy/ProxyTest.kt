package com.wangpeng.learning.proxy

import com.wangpeng.learning.proxy.impl.PaymentApiImpl
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigDecimal

@ExtendWith(MockKExtension::class)
class ProxyTest {

	@Test
	fun testProxy() {
		val instrument = Instrument(BigDecimal("100"),"USD","Visa")
		val paymentJDKProxy = PaymentJDKProxy()
		val paymentApi = paymentJDKProxy.newProxy(PaymentApiImpl())
		paymentApi.pay(instrument)
	}
}