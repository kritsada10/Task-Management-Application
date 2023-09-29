package com.exam.examrbh.domain.mapper

@FunctionalInterface
interface Mapper<in DomainObject, out UIObject> {
    fun mapFrom(item: DomainObject): UIObject
}
