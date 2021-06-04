package com.wangpeng.learning.proxy

interface PaymentApi {
	fun pay(instrument: Instrument)
}