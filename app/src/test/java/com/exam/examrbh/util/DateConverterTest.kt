package com.exam.examrbh.util


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DateConverterTest {

    @Test
    fun convertDate() {
        val dateMock = "2023-10-03T19:30:00Z"
        assertThat(DateConverter.convertDate(dateMock)).isEqualTo("2023-10-03")
    }

    @Test
    fun convertDataFailed(){
        val dataMock = ""
        val result = DateConverter.convertDate(dataMock)
        assertThat(result).isEqualTo("null")
    }


}