package com.gettogether.domain.mapper

interface Mapper<in From, out To> {
    fun map(from: From): To
    fun mapList(fromList: List<From>): List<To> = fromList.map { map(it) }
}