package hr.ferit.sandroblavicki.rma_lv3_zad2.model

import java.io.Serializable

data class Person(
    val id: Int = 0,
    val name: String,
    val dateOfBirth: String,
    val quotes: List<String>,
    val description: String,
    val imageUrl: String
) : Serializable
