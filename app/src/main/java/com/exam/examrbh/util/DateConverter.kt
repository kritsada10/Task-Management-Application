package com.exam.examrbh.util

import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


object DateConverter {

    fun convertDate(date: String): String{

        val currentDate = getCurrentDate()
        val tomorrow = getTomorrow()
        val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
        var parsed : LocalDate? = null
        if(date != ""){
            parsed = ZonedDateTime.parse(date, formatter).toLocalDate()
        }

        val resultDate = if(parsed?.isEqual(currentDate) == true){
            "Today"
        }
        else if(parsed?.isEqual(tomorrow) == true){
            "Tomorrow"
        }
        else{
            parsed.toString() ?: ""
        }

        return resultDate
    }

    private fun getCurrentDate(): LocalDate {
        val current = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        return LocalDate.parse(current)
    }

    private fun getTomorrow(): LocalDate {
        val tomorrow = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        return LocalDate.parse(tomorrow)
    }

}