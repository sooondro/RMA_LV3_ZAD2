package hr.ferit.sandroblavicki.rma_lv3_zad2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "people")
data class Person(
        @PrimaryKey(autoGenerate = true) val id: Long,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "dateOfBirth") val dateOfBirth: String,
        //@ColumnInfo(name = "title") val quotes: List<String>,
        @ColumnInfo(name = "description") val description: String,
        @ColumnInfo(name = "imageUrl") val imageUrl: String
) : Serializable
