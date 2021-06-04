package com.wangpeng.learning.proxy.impl

import com.wangpeng.learning.proxy.Instrument
import com.wangpeng.learning.proxy.PaymentApi

class PaymentApiImpl: PaymentApi {
	override fun pay(instrument: Instrument) {
		println("already pay ${instrument.amount} with : ${instrument.type}.")
	}
}